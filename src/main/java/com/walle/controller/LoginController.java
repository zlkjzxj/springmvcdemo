package com.walle.controller;

import com.walle.beans.Girl;
import com.walle.beans.SysUser;
import com.walle.dao.UserDao;
import com.walle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;
    @RequestMapping("/test")
    public @ResponseBody String test(){
        System.out.println("come into test");
//
        return "index";
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        System.out.println("come into login");
        ModelAndView view = new ModelAndView("login");
//        SysUser user = userService.getUser(1);
        List<Girl> girls = userService.getGirls();
//        System.out.println(user.getName());
        view.addObject("girls",girls);
        return view;
    }
}
