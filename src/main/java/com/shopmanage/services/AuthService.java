package com.shopmanage.services;

import com.shopmanage.dao.UserDAO;
import com.shopmanage.models.user;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public user login(String username, String password) {
        user user = userDAO.getByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
