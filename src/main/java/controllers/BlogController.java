package controllers;


import DAO.PostgresDAO;
import Other.Blog;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class BlogController {

    @RequestMapping("blogs")
    public ModelAndView blogsList() throws SQLException, ClassNotFoundException {
        PostgresDAO dao= new PostgresDAO();
        ArrayList<Blog>blogsList=dao.getBlogs();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("blogListView");
        mv.addObject("blogList",blogsList);
        return mv;
    }



    @RequestMapping("blog")
    public ModelAndView blog(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        PostgresDAO dao= new PostgresDAO();
        ModelAndView mv=new ModelAndView();
        Blog curBlog=dao.getBlog(Integer.parseInt(req.getParameter("num")));
        mv.addObject("title",curBlog.getTitle());
        mv.addObject("text",curBlog.getBlog());
        mv.setViewName("blogView");
        return mv;
    }

}
