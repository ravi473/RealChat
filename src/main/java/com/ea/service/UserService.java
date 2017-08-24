package com.ea.service;

import com.ea.dao.UserDao;
import com.ea.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers(){
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id){
        return this.userDao.getUserById(id);
    }
    public User getUserByEmail(String email){
        return this.userDao.getUserByEmail(email);
    }

//    public void removeUserById(int id) {
//        this.userDao.removeUserById(id);
//    }
//
//    public void updateUser(User user){
//        this.userDao.updateUser(user);
//    }

    public void insertUser(User user) {
        this.userDao.insertUserToDb(user);
    }
}
