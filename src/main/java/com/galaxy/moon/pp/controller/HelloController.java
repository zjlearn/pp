package com.galaxy.moon.pp.controller;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello zj and manman";
    }

    @RequestMapping("/tt")
    public void account(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("");
            response.sendRedirect(request.getContextPath()+"/#/account");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
