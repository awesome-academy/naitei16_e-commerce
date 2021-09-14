package com.javanaitei.phoneshop.service;

import com.javanaitei.phoneshop.entity.User;
import com.javanaitei.phoneshop.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public boolean deleteUser(UserModel userModel) throws Exception;

    public List<UserModel> findAll();
}
