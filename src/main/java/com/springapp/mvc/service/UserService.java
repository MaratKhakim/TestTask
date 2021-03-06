package com.springapp.mvc.service;

import com.springapp.mvc.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void editUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
}
