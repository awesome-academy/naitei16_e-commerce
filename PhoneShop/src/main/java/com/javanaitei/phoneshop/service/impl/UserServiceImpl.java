package com.javanaitei.phoneshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.javanaitei.phoneshop.dao.UserDAO;
import com.javanaitei.phoneshop.entity.User;
import com.javanaitei.phoneshop.model.CustomUserDetails;
import com.javanaitei.phoneshop.model.UserModel;
import com.javanaitei.phoneshop.model.enu.Role;
import com.javanaitei.phoneshop.service.UserService;

public class UserServiceImpl implements UserService {
    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserModel findUser(Long id) {
        log.info("Checking the user in the database");
        try {
            User user = userDAO.find(id);
            return convertBean(user);
        } catch (Exception e) {
            log.error("An error occurred while fetching the user details from the database", e);
            return null;
        }
    }

    @Override
    public UserModel findUserByUserName(String userName) {
        log.info("Fetching the user by username in the database");
        try {
            User user = userDAO.findUserByUserName(userName);
            return convertBean(user);
        } catch (Exception e) {
            log.error("An error occurred while fetching the user details by username from the database", e);
            return null;
        }
    }

    @Override
    public UserModel findUserByEmail(String email) {
        log.info("Fetching the user by email in the database");
        try {
            User user = userDAO.findUserByEmail(email);
            return convertBean(user);
        } catch (Exception e) {
            log.error("An error occurred while fetching the user details by email from the database", e);
            return null;
        }
    }

    @Override
    public boolean checkExisted(Long id, String field, String value, String column) {
        log.info("Checking " + field + " in the database");
        try {
            return userDAO.checkExisted(id, field, value, column, "User");
        } catch (Exception e) {
            log.error("An error occurred while checking " + field + " from the database", e);
            return true;
        }
    }

    @Override
    public boolean checkPassword(String password, Long id) {
        log.info("Checking the password of the user in the database");
        try {
            return userDAO.checkPassword(password, id);
        } catch (Exception e) {
            log.error("An error occurred while checking the password of the user from the database", e);
            return true;
        }
    }

    @Transactional
    public UserModel addUser(UserModel userModel) throws Exception {
        log.info("Adding the user in the database");
        try {
            User user = new User();
            user.setId(userModel.getId());
            user.setEmail(userModel.getEmail());
            user.setUserName(userModel.getUserName());
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            user.setPhone(userModel.getPhone());
            user.setRole(Role.USER_ROLE);
            user = userDAO.makePersistent(user);
            return convertBean(user);
        } catch (Exception e) {
            log.error("An error occurred while adding the user details to the database", e);
            throw e;
        }
    }

    @Transactional
    public UserModel editUser(UserModel userModel) throws Exception {
        log.info("Updating the user in the database");
        try {
            User user = userDAO.find(userModel.getId(), true);
            if (StringUtils.hasText(userModel.getPhone())) {
                user.setPhone(userModel.getPhone());
            }
            userDAO.makePersistent(user);
            return userModel;
        } catch (Exception e) {
            log.error("An error occurred while updating the user details to the database", e);
            throw e;
        }
    }

    @Transactional
    public UserModel changePassword(UserModel userModel) throws Exception {
        log.info("Changing the password of the user in the database");
        try {
            User user = userDAO.find(userModel.getId(), true);
            if (StringUtils.hasText(userModel.getPassword())) {
                user.setPassword(passwordEncoder.encode(userModel.getPassword()));
            }
            userDAO.makePersistent(user);
            return userModel;
        } catch (Exception e) {
            log.error("An error occurred while changing the password to the database", e);
            throw e;
        }
    }

    @Transactional
    public boolean deleteUser(UserModel userModel) throws Exception {
        log.info("Deleting the user in the database");
        try {
            User user = userDAO.find(userModel.getId(), true);
            userDAO.makeTransient(user);
            return true;
        } catch (Exception e) {
            log.error("An error occurred while adding the user details to the database", e);
            throw e;
        }
    }

    public List<UserModel> findAll() {
        log.info("Fetching all users in the database");
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            List<User> userList = userDAO.findAll();
            for (User user : userList) {
                UserModel userModel = new UserModel();
                BeanUtils.copyProperties(user, userModel);
                userModelList.add(userModel);
            }
        } catch (Exception e) {
            log.error("An error occurred while fetching all users from the database", e);
        }
        return userModelList;
    }

    @Override
    public Page<UserModel> paginate(UserModel userModel) {
        try {
            return userDAO.paginate(userModel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            User user = userDAO.findUserByUserName(userName);
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(user, userModel);
            return new CustomUserDetails(userModel);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw e;
        }
    }

    private UserModel convertBean(User user) {
        UserModel userModel = null;
        if (user != null) {
            userModel = new UserModel();
            BeanUtils.copyProperties(user, userModel);
        }
        return userModel;
    }

}
