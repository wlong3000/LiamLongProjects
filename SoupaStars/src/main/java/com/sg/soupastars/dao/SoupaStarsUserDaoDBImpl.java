package com.sg.soupastars.dao;

import com.sg.soupastars.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SoupaStarsUserDaoDBImpl implements SoupaStarsUserDao {
    // #1 - We need to update both the users and authorities tables

    private static final String SQL_INSERT_USER
            = "insert into users (username, password, enabled) values (?, ?, 1)";
    private static final String SQL_INSERT_AUTHORITY
            = "insert into authorities (username, authority) values (?, ?)";
    private static final String SQL_DELETE_USER
            = "delete from users where username = ?";
    private static final String SQL_DELETE_AUTHORITIES
            = "delete from authorities where username = ?";
    private static final String SQL_SELECT_USER_BY_ID = "select * from users where user_id = ?";
    private static final String SQL_SELECT_ALL_USERS
            = "select * from users";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User addUser(User newUser) {
        // #2 - First insert user data into the users table and then insert data into
        // the authorities table (failing to do so will result in foreign key
        // constraint errors)
        jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(), newUser.getPassword());
        newUser.setUserId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        // now insert user's roles
        ArrayList<String> authorities = newUser.getAuthorities();
        for (String authority : authorities) {
            jdbcTemplate.update(SQL_INSERT_AUTHORITY, newUser.getUsername(), authority);
        }

        return newUser;
    }

    @Override
    public void deleteUser(String username) {
        // #3 - First delete all authorities for this user
        jdbcTemplate.update(SQL_DELETE_AUTHORITIES, username);
        // #3 - Second delete the user - failing to do so will result in foreign
        // key constraint errors
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public User getUserById(int userId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, new UserMapper(), userId);
    }
   private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }

}
}
