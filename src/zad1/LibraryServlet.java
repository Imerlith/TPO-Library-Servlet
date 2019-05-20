package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/LibraryServlet")
public class LibraryServlet extends HttpServlet {
    private DataSource dataSource;
    private List<Book> books;
    private BooksView view;

    public void init() throws ServletException {
        try {

            Context init = new InitialContext();
            Context context = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) context.lookup("jdbc/ksidb");

        } catch (NamingException e) {
            throw new ServletException("Cannot connect to java:comp/env/jdbc/ksidb", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        view = new BooksView();
        getBooksFromDB();
        view.setContent(books);
        writer.println(view.getPageView());



    }

    public void getBooksFromDB() {
        books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT  * from POZYCJE " +
                        "inner join AUTOR on AUTOR.AUTID = POZYCJE.AUTID " +
                        "inner join WYDAWCA on WYDAWCA.WYDID = POZYCJE.WYDID");
                System.out.println("INSIDE if rs ");
                while (rs.next()) {
                    String ISBN = rs.getString("ISBN");
                    String title = rs.getString("TYTUL");
                    String year = rs.getString("ROK");
                    String price = rs.getString("CENA");
                    books.add(new Book(ISBN, title, year, price));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Book> searchForBooks(String phrase){
        List<Book> searchedBooks = new ArrayList<>();
        if (books!=null){
            searchedBooks = books.stream().filter(book->book.getTitle().contains(phrase)).collect(Collectors.toList());
        }
        return searchedBooks;
    }
}