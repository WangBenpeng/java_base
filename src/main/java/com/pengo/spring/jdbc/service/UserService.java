package com.pengo.spring.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 17:51
 */
@Component
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUserById(long id) {
        return jdbcTemplate.execute((ConnectionCallback<User>) connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where id = ?")) {
                preparedStatement.setObject(1, id);
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        return new User(rs.getLong("id"), // id
                                rs.getString("email"), // email
                                rs.getString("password"), // password
                                rs.getString("name"));
                    }
                    throw new RuntimeException("user not found");
                }
            }
        });
    }

    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("select * from users where email = ?", new Object[]{email},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getLong("id"), // id
                                rs.getString("email"), // email
                                rs.getString("password"), // password
                                rs.getString("name"));
                    }
                });
    }

    public Long getUsers() {
        return jdbcTemplate.queryForObject("select count(*) from users",null,
                (ResultSet rs,int rowNum) -> {
                    return rs.getLong(1);
                });
    }

    public List<User> getUser(int page) {
        int limit = 10;
        int offset = limit * (page - 1);
        return jdbcTemplate.query("select * from users limit ? offset ?", new Object[]{limit, offset},
                new BeanPropertyRowMapper<>(User.class));
    }

    public void updateUser(User user) {
        if (1 != jdbcTemplate.update("update users set name = ? where id = ?", user.getName(), user.getId())) {
            throw new RuntimeException("[update] user not found");
        }
    }

    public User register(String email, String password, String name) {
        KeyHolder holder = new GeneratedKeyHolder();
        if (1 != jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into users(email,password,name) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, email);
            ps.setObject(2, password);
            ps.setObject(3, name);
            return ps;
            }, holder))
        {
            throw new RuntimeException("[register]insert failed..");
        }
        return new User(holder.getKey().longValue(), email, password, name);
    }
}
