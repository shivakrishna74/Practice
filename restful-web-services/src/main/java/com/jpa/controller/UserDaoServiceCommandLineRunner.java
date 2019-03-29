package com.jpa.controller;
import com.jpa.Dao.UserDaoImpl;
import com.yash.restfulwebservices.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDaoImpl userDao;

    private static final Logger log=LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        User user=new User(10,"Admin",new Date());
        long insert=userDao.insert(user);
        log.info("new user is created"+user);

    }
}
