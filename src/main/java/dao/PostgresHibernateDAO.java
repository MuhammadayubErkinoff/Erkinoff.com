package dao;

import entities.Account;
import entities.Blog;
import entities.SocialMedia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class PostgresHibernateDAO {

    private static final Configuration cfg=new Configuration().configure("hibernate.cfg.xml");

    public ArrayList<Blog> getBlogs() {
        Session session=cfg.buildSessionFactory().openSession();
        return (ArrayList<Blog>) session.createQuery("from Blog",Blog.class).list();
    }

    public Blog getBlog(int id) {
        Session session=cfg.buildSessionFactory().openSession();
        return session.get(Blog.class,id);
    }

    public ArrayList<SocialMedia> getSocialMedias(){
        Session session=cfg.buildSessionFactory().openSession();
        return (ArrayList<SocialMedia>) session.createQuery("from SocialMedia",SocialMedia.class).list();
    }

    public void addAccount(String username,String password){
        Account account=new Account(username,password,false);
        Session session=cfg.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.persist(account);
        transaction.commit();
    }

    public Account getAccount(String username){
        Session session=cfg.buildSessionFactory().openSession();
        return session.get(Account.class,username);
    }

}
