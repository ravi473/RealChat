package com.ea.dao;

import com.ea.entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

//    void removeUserById(int id);
//
//    void updateUser(User user);

    void insertUserToDb(User user);
}
