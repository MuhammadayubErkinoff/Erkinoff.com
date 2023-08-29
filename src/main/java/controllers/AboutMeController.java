package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutMeController {

    @RequestMapping("about_me")
    public ModelAndView aboutMe(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("blogView");
        mv.addObject("title","About me");
        mv.addObject("text","I was born on 19 April, 2006");
        return mv;
    }
}
