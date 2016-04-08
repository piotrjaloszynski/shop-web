package com.piotr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jalos on 08.04.2016.
 */

@Controller
public class MainController {
    @RequestMapping(value="/", method= GET)
    public String getMainView(){
        return "index";
    }
}
