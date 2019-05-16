package zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/LibraryServlet")
public class LibraryServlet extends HttpServlet {
    private Connection connection;

    public void init() throws ServletException{
        try {

            connection = DriverManager.getConnection("jdbc:derby:C:/DerbyDbs/Ksidb");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT  * from AUTOR");
            while (rs.next()){
                String name = rs.getString("NAME");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter().println("Hello");
    }

}
