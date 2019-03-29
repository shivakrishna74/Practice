package com.yash.restfulwebservices.controller;
import com.yash.restfulwebservices.dao.UserDao;
import com.yash.restfulwebservices.exception.UserNotFoundException;
import com.yash.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class UserResourceController {
    @Autowired
    private UserDao userDao;

    //retrive all users
    @GetMapping("/retrieveAllUsers")
    public List<User> retrieveAllUsers()
    {
        return userDao.findAll();

    }

    @GetMapping("/retrieveUser/{id}")
    public Resource<User> retrievUser(@PathVariable int id)
    {
        User user=userDao.findOne(id);
        if(user==null)
        {
            throw new UserNotFoundException("id-"+id);
        }
        //Hateoas
        Resource<User> resource=new Resource<User>(user);
        ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
    {
        User savedUser=userDao.save(user);
        URI location=ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id").buildAndExpand(savedUser.getId()).
                toUri();
       return ResponseEntity.created(location).build();

    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        User user=userDao.deleteById(id);
        if(user==null)
        {
            throw new UserNotFoundException("id-"+id);

        }
    }



















}
