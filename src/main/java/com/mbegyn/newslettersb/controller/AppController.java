package com.mbegyn.newslettersb.controller;

import com.mbegyn.newslettersb.model.User;
import com.mbegyn.newslettersb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @RequestMapping("/")
    public String showNewProductPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("usersList", listUsers);
        return "users";
    }

    @RequestMapping("/subscribe/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("subscribe");
        User user = service.getId(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/confirmUnsubscribe/{id}")
    public ModelAndView confirmUnsubscription(@PathVariable(name = "id") int id) {

        ModelAndView mav = new ModelAndView("unsubscribe");
        User user = service.getId(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value = "/unsubscribe", method = RequestMethod.POST)
    public ModelAndView unsubscribeUser(@ModelAttribute("user") User user) {

        User userToUpdate = service.getId(user.getId());
        userToUpdate.setMailAddress(null);
        service.save(userToUpdate);

        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("user", userToUpdate);

        return mav;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user) {

        User userToUpdate = service.getId(user.getId());
        userToUpdate.setMailAddress(user.getMailAddress());
        service.save(userToUpdate);

        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("user", userToUpdate);

        return mav;
    }

    @RequestMapping(value = "/retrieveUser", method = RequestMethod.POST)
    public ModelAndView getUser(@ModelAttribute("user") User user) {

        User userToRetrieve = new User();
        List<User> listUsers = service.listAll();
        for (User user2:listUsers) {
            if(user2.getFirstName().equals(user.getFirstName())) {
                userToRetrieve = user2;
            }
        }

        ModelAndView mav = new ModelAndView("profile");
        User userToGet = service.getId(userToRetrieve.getId());
        mav.addObject("user", userToRetrieve);

        return mav;
    }

}
