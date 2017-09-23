package com.ghost.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/a")
    public String b(Map<String, Object> model){
        model.put("msg", "张三");     
        return "regiester";
    }

    @RequestMapping("/b")
    public ModelAndView b(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName("regiester");

        request.setAttribute("msg", "jack");
        return view;
    }
}
