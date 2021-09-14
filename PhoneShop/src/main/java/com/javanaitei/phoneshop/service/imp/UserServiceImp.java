package com.javanaitei.phoneshop.service.imp;

import com.javanaitei.phoneshop.dao.UserDao;
import com.javanaitei.phoneshop.entity.User;
import com.javanaitei.phoneshop.model.UserModel;
import com.javanaitei.phoneshop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public boolean deleteUser(UserModel userModel) throws Exception {
        try {
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<UserModel> findAll() {
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            List<User> userList = userDao.findAll();
            for (User user : userList) {
                UserModel userModel = new UserModel();
                BeanUtils.copyProperties(user, userModel);
                userModelList.add(userModel);
            }
        } catch (Exception e) {
        }
        return userModelList;
    }
}
