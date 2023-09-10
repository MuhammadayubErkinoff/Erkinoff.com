package controllers;


import dao.PostgresHibernateDAO;
import entities.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class SignAndLogInController {
    @RequestMapping("sign_in")
    public ModelAndView signIn(HttpServletRequest req){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("signInView");
        return mv;
    }

    @RequestMapping("signed_in")
    public void signedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PostgresHibernateDAO dao=new PostgresHibernateDAO();
        String username=req.getParameter("username");
        if(dao.getAccount(username)!=null){
            req.setAttribute("usernameAlreadyExists",true);
            req.getRequestDispatcher("sign_in").forward(req, res);
        }
        else{
            dao.addAccount(username,req.getParameter("password"));
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("/").forward(req, res);
        }
        //return mv;
    }


    @RequestMapping("log_in")
    public ModelAndView logIn(HttpServletRequest req){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("logInView");
        return mv;
    }

    @RequestMapping("logged_in")
    public void logedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PostgresHibernateDAO dao=new PostgresHibernateDAO();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Account account=dao.getAccount(username);
        if(account!=null){
            if(password.equals(account.getPassword())) {
                req.getSession().setAttribute("username", req.getParameter("username"));
                req.getRequestDispatcher("/").forward(req, res);
            }
            else{
                req.setAttribute("incorrectPassword",true);
                req.getRequestDispatcher("log_in").forward(req, res);
            }
        }
        else{
            req.setAttribute("usernameDoesNotExist",true);
            req.getRequestDispatcher("log_in").forward(req, res);
        }
    }

}
