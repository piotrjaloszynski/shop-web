package com.piotr.controller;

import com.piotr.dao.UserDao;
import com.piotr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by jalos on 05.04.2016.
 */

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/usersListServletMapping", method = GET)
    public String getUserListView(Model model) throws SQLException {

        List<User> users = userDao.findAll();
        model.addAttribute("usersLoop", users);
        return "user-list";// nazwa strony internetowej ktora trafia do view resolvera dokleja co dostalem w prefix
        // web-inf / views/user.list


    }

    @RequestMapping(value = "/user-create", method = GET)
    public String getUserCreateView() {
        return "user-create";
    }

    @RequestMapping(value = "/user-create", method = POST)
    public String create(@RequestParam(value = "firstname") String imie,
                         @RequestParam(value = "lastname") String nazwisko,
                         @RequestParam(value = "email") String email) throws SQLException {


        User user = new User(imie, nazwisko, email);
        userDao.save(user);
        return "redirect:/usersListServletMapping";
    }

    @RequestMapping(value = "/user-edit", method = GET)
    public String getUserEdit(Model model,
                              @RequestParam(value = "id") Integer id) throws SQLException {
        User user = userDao.findById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @RequestMapping(value = "/user-edit", method = POST)
    public String update(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "firstname") String imie,
                         @RequestParam(value = "lastname") String nazwisko,
                         @RequestParam(value = "email") String email) throws SQLException {
        User user = new User(id, imie, nazwisko, email);
        userDao.update(user);
        return "redirect:/usersListServletMapping";
    }

    @RequestMapping(value = "/deleteUserAction", method = POST)
    public String delete(@RequestParam(value = "id") Integer id) throws SQLException {
        userDao.deleteById(id);
        return "redirect:/usersListServletMapping";
    }


}


//This String will be interpreted by Spring MVC as the name of the view that
//will be rendered. DispatcherServlet will ask the view resolver to resolve this logical
//      view name into an actual view.