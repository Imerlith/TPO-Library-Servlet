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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("\t \t \t \t \t \t \t \t \t \t \t ---Baza danych ksiazek--- ");
        writer.println("ISBN \t \t \t \t AUTOR \t \t \t TYTUL \t \t \t \t \t \t \t WYDAWNICTWO \t \t ROK \t CENA ");
        if(connection!=null){
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT  * from POZYCJE " +
                        "inner join AUTOR on AUTOR.AUTID = POZYCJE.AUTID " +
                        "inner join WYDAWCA on WYDAWCA.WYDID = POZYCJE.WYDID");
                System.out.println("INSIDE if rs ");
                while (rs.next()){
                    String ISBN = rs.getString("ISBN");
                   // String authorName = rs.getString("AUTOR.NAME");
                    String title = rs.getString("TYTUL");
                    //String publisherName = rs.getString("WYDID.NAME");
                    String year = rs.getString("ROK");
                    String price = rs.getString("CENA");

                    writer.println(ISBN+"\t \t \t"+"autor"+"\t \t"+title+"\t \t \t \t \t \t \t"+"Wwydawnictwo"+"\t \t"+year+"\t"+price);
                }

            } catch (SQLException e) {

            }
        }

    }



}
