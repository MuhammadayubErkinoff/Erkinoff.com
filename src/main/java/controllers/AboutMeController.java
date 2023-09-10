package controllers;

import dao.PostgresHibernateDAO;
import entities.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutMeController {

    @RequestMapping("about_me")
    public ModelAndView aboutMe(){
        ModelAndView mv=new ModelAndView();
        Blog blog=new PostgresHibernateDAO().getBlog(0);
        mv.setViewName("blogView");
        mv.addObject("title",blog.getTitle());
        mv.addObject("text",blog.getBlog());
        return mv;
    }
}
