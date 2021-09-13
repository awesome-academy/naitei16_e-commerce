package com.javanaitei.phoneshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.javanaitei.phoneshop.model.UserModel;

public interface UserService extends UserDetailsService {
    UserModel findUser(Long id);

    UserModel findUserByUserName(String userName);

    UserModel findUserByEmail(String email);

    boolean checkExisted(Long id, String field, String value, String column);

    boolean checkPassword(String password, Long id);

    UserModel addUser(UserModel user) throws Exception;

    UserModel editUser(UserModel userModel) throws Exception;

    UserModel changePassword(UserModel userModel) throws Exception;

    boolean deleteUser(UserModel userModel) throws Exception;

    List<UserModel> findAll();

    Page<UserModel> paginate(UserModel userModel);
}