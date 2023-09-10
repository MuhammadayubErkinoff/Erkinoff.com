package controllers;


import dao.PostgresHibernateDAO;
import entities.Blog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @RequestMapping("blogs")
    public ModelAndView blogsList(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("blogListView");
        mv.addObject("blogList", new PostgresHibernateDAO().getBlogs());
        return mv;
    }



    @RequestMapping("blog")
    public ModelAndView blog(HttpServletRequest req){
        ModelAndView mv=new ModelAndView();
        Blog curBlog=new PostgresHibernateDAO().getBlog(Integer.parseInt(req.getParameter("num")));

        mv.addObject("title",curBlog.getTitle());
        mv.addObject("text",curBlog.getBlog());
        mv.setViewName("blogView");

        return mv;
    }

}
