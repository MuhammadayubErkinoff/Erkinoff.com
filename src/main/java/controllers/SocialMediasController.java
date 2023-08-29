package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SocialMediasController {

    @RequestMapping("social")
    public ModelAndView social(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("socialMediasView");
        ArrayList<SocialMedia>list=new ArrayList<>();
        list.add(new SocialMedia("telegram","https://t.me/My_Boring_Iife"));
        mv.addObject("socialMediaList",list);
        return mv;
    }

}