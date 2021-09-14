package com.javanaitei.phoneshop.dao.imp;

import com.javanaitei.phoneshop.dao.UserDao;
import com.javanaitei.phoneshop.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp extends GenericDaoImp<User, Integer> implements UserDao {
    public UserDaoImp(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
}
