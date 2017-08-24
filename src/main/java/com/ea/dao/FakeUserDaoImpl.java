package com.ea.dao;

import com.ea.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FakeUserDaoImpl implements UserDao {

    private static Map<Integer, User> users;

    static {

        users = new HashMap<Integer, User>(){

            {
                put(1, new User(1, "Sai", "Sai@mail.com"));
                put(2, new User(2, "Alex", "alex@mail.com"));
                put(3, new User(3, "Anna", "anna@mail.com"));
            }
        };
    }

    @Override
    public Collection<User> getAllUsers(){
        return this.users.values();
    }

    @Override
    public User getUserById(int id){

        return this.users.get(id);
    }

    @Override
    public User getUserByEmail(String email){

        return this.users.get(email);
    }

//    @Override
//    public void removeUserById(int id) {
//        this.users.remove(id);
//    }
//
//    @Override
//    public void updateUser(User user){
//        User s = users.get(user.getId());
//        s.setEmail(user.getEmail());
//        s.setName(user.getName());
//        users.put(user.getId(), user);
//    }

    @Override
    public void insertUserToDb(User user) {
        this.users.put(user.getId(), user);
    }
}
