package zad1;

import java.util.List;

public class BooksView {
    public String header;
    public String footer;
    public String content;

    public BooksView() {
        header = "<html>" +
                "<head>" +
                "<meta charset=utf-8>"+
                "</head>"+
                "<body>";
        footer = "</body>"+
                "<html>";

    }

    public void setContent(List<Book> books) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<center><h1>---Baza danych ksiazek---</h1></center><br>");
        stringBuilder.append("<table style=\"width:100%\">");
        stringBuilder.append("<tr><th>ISBN</th><th>Nazwa</th><th>Rok</th><th>Cena</th></tr>");
        for (Book book : books){
            stringBuilder.append("<tr>");
            stringBuilder.append("<td>");
            stringBuilder.append(book.getISBN());
            stringBuilder.append("</td>");
            stringBuilder.append("<td>");
            stringBuilder.append(book.getTitle());
            stringBuilder.append("</td>");
            stringBuilder.append("<td>");
            stringBuilder.append(book.getYear());
            stringBuilder.append("</td>");
            stringBuilder.append("<td>");
            stringBuilder.append(book.getPrice());
            stringBuilder.append("</td>");
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("</table>");
        content = stringBuilder.toString();
    }

    public String getPageView(){
        return header + content + footer;
    }
}
