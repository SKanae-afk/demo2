package com.example.dao;

import com.example.dao.Users;
import com.example.entity.UsersEntity;

import javax.persistence.Persistence;
import java.util.List;

public class UserService {

    private Users userDao;

    public UserService() {
        try {
            userDao = new Users(Persistence.createEntityManagerFactory("default"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(UsersEntity newUser) {
        userDao.create(newUser);
    }

    public void updateUser(UsersEntity updatedUser) {
        userDao.update(updatedUser);
    }

    public void removeUser(UsersEntity removeUser, int user_id) {
        userDao.remove(removeUser, user_id);
    }

    public List<UsersEntity> getAllUsers() {
        return userDao.findAll();
    }

    //for login
    public UsersEntity findUser(String user, String pass) throws Exception {

        List<UsersEntity> users = userDao.find(user);
        if (users.size() == 0) {
            throw new Exception("User not found");
        }

        UsersEntity u = users.get(0);

        if (pass.compareTo(u.getPassword()) != 0) {
            throw new Exception("Password does not match");
        }
        return u;
    }
}
