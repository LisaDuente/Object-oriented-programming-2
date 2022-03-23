package com.example.SpringExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//this is the class that talks to the DAO
@Service
public class UserService {
    //create a reference to the DAO, use Autowired to connect it
    @Autowired
    UserDAO dao;

    //create methods that equal the methods in DAO
    public void insertUser(User user){
        dao.insertNewUser(user.getID(), user.getName());
    }

    public User downloadUser(String ID){
        User user = dao.downloadUser(ID);
        return user;
    }

    public void insertNewUsers(List<User> userList){
        dao.insertNewUsers(userList);
    }

    public String getMaxUserID(){
        return dao.getMaxUserID();
    }

    public List<User> getAllUsers(){
        return dao.getAllUsers();
    }
}

