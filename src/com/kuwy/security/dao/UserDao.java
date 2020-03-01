package com.kuwy.security.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kuwy.security.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
