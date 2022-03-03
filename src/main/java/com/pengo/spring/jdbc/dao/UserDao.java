package com.pengo.spring.jdbc.dao;

import com.pengo.spring.jdbc.service.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pengo
 * @description:
 * @date 2022/3/2 10:39
 */
@Component
@Transactional
public class UserDao extends AbstractDao<User>{

//    public User getById(Long id) {
////        return getJdbcTemplate().queryForObject("select * from users where id = ?", new BeanPropertyRowMapper<>(User.class), id);
//        return getById(id);
//    }

}
