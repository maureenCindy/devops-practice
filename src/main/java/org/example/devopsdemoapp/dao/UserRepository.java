package org.example.devopsdemoapp.dao;

import org.example.devopsdemoapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author maureen on 25/5/2020
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}
