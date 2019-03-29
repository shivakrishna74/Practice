package com.jpa.Dao;

import com.yash.restfulwebservices.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user)
    {

        entityManager.persist(user);
        return user.getId();

    }










}
