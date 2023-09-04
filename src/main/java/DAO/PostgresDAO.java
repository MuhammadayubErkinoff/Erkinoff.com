package DAO;

import Other.Blog;
import Other.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;

public class PostgresDAO{
    private final Connection connection;

    public PostgresDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection=DriverManager.getConnection(Constants.DbUrl,Constants.DbUser,Constants.DbPassword);
    }

    public ArrayList<Blog> getBlogs() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("SELECT \"ID\",\"Title\",\"Blog\",\"DateOfEntry\" from \"Blogs\" ORDER BY \"DateOfEntry\" ASC ");
        ArrayList<Blog>list=new ArrayList<>();
        while(resultSet.next()){
            Blog cur=new Blog(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            list.add(cur);
        }
        return list;
    }

    public Blog getBlog(int ind) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("SELECT \"ID\",\"Title\",\"Blog\",\"DateOfEntry\" from \"Blogs\" Where \"ID\"="+ind);

        Blog cur=new Blog();
        if(resultSet.next()){
            cur.setID(resultSet.getInt(1));
            cur.setTitle(resultSet.getString(2));
            cur.setBlog(resultSet.getString(3));
            cur.setDate(resultSet.getString(4));
        }
        return cur;
    }


}
