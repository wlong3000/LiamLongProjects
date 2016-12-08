/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.controller;


import com.sg.soupastars.dao.SoupaStarsUserDao;
import com.sg.soupastars.model.User;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author softwareguild
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    private SoupaStarsUserDao dao;

    // #1 - PasswordEncoder interface
    private PasswordEncoder encoder;

    // #2 - Inject a PasswordEncoder
    @Inject
    public UserController(SoupaStarsUserDao dao, PasswordEncoder encoder) {
        this.dao = dao;
        this.encoder = encoder;
    }

    // #1 - This endpoint retrieves all users from the database and puts the
    // List of users on the model
    @RequestMapping(value = {"/","/displayUserList"}, method = RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = dao.getAllUsers();
        model.put("users", users);
        return "displayUserList";
    }
    // #2 - This endpoint just displays the Add User form

    @RequestMapping(value = "/displayUserForm", method = RequestMethod.GET)
    public String displayUserForm(Map<String, Object> model) {
        return "addUserForm";
    }
    // #3 - This endpoint processes the form data and creates a new User

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req) {
        User newUser = new User();
        // #4 - This example uses a plain HTML form so we must get values from the request
        newUser.setUsername(req.getParameter("username"));
        //  - Hash the password and then set it on the User object before saving it
        String clearPw = req.getParameter("password");
        String hashPw = encoder.encode(clearPw);
        newUser.setPassword(hashPw);
        // #5 - All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin box is checked
        newUser.addAuthority("ROLE_USER");
        if (null != req.getParameter("isAdmin")) {
            newUser.addAuthority("ROLE_ADMIN");
        }

        dao.addUser(newUser);

        return "redirect:displayUserList";
    }
    // #6 - This endpoint deletes the specified User

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("username") String username,
            Map<String, Object> model) {
        dao.deleteUser(username);
        return "redirect:displayUserList";
    }
    
}
