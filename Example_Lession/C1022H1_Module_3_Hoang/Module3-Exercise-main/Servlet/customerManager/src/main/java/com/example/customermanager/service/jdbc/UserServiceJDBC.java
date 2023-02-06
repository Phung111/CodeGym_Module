package com.example.customermanager.service.jdbc;

import com.example.customermanager.model.Customer;
import com.example.customermanager.model.User;
import com.example.customermanager.service.IUserservice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJDBC extends DatabaseContext implements IUserservice {
    private static final String SELECT_ALL_CUSTOMER = "select * from user;";
    private static final String CHECK_EMAIL = "SELECT email FROM user where email = ";

    private static final String CHECK_USERNAMESIGNUP = "SELECT username FROM user where username = ";


    private static final String INSERT_USER = "INSERT INTO `user` (`id`,`fullname`, `username`, `email`,`password`) VALUES (?, ?, ?, ?, ?);";

    private static final String CHECK_USERNAMELOGIN = "SELECT * FROM c8_customermanager.user where username = ";

    private static final String CHECK_USERPASSWORDLOGIN = "SELECT password FROM c8_customermanager.user where username = ";

    public boolean checkUserNamePassword(String username, String password) {
        try {
            User user;
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String queryusername = CHECK_USERNAMELOGIN + "'" + username + "'";
            ResultSet rs = statement.executeQuery(queryusername);
            String usernameDAO = "";
            String passwordDAO = "";
            while (rs.next()) {
                usernameDAO = getUserFromResulset(rs).getUsername();
                passwordDAO = getUserFromResulset(rs).getPassword();
            }
            System.out.println(usernameDAO);
            System.out.println(passwordDAO);

            if (usernameDAO.equals(username) && passwordDAO.equals(password)) {
                return true;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return false;
    }

    private User getUserFromResulset(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String fullname = rs.getString("fullname");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");
        User user = new User(id, fullname, username, email, password);
        return user;
    }

    public boolean checkEmailSignup(String email) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = CHECK_EMAIL + "'" + email + "'";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs);
            while (rs.next()) {
                return false;
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return true;
    }

    public boolean checkUsernameSignup(String username) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = CHECK_USERNAMESIGNUP + "'" + username + "'";
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs);
            while (rs.next()) {
                return false;
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return true;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = getUserFromResulset(rs);
                users.add(user);
            }
            connection.close();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return users;
    }

    public void addCustomer(User user) {
        try {
            //INSERT INTO `customer` (`name`, `address`, `idCountry`) VALUES (?, ?, ?);";
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getFullname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

}
