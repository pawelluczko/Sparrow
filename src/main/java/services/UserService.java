package services;

import dao.UserDAO;
import model.User;

import javax.persistence.NoResultException;

public class UserService {

    public UserService() {
        userDAO = new UserDAO();
    }

    UserDAO userDAO = new UserDAO();


    public UserService(UserDAO userDAO) {  // to jest construktor
        this.userDAO = userDAO;

    }

    public boolean registerUser(User user) {
        if (isUserAlreadyExist(user.getEmail())) {
            return false;
        }
        userDAO.createUser(user);
        return true;
    }

    private boolean isUserAlreadyExist(String email) {
        try {
            userDAO.getUserByEmail(email);
            return true;

        } catch (NoResultException e) {
            return false;
        }
    }

}
