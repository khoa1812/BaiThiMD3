package service;



import model.Book;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class BookDAO implements IBookDAO {

    private static final String SELECT_ALL_BOOKS = "select * from books ;";
    private static final String SELECT_BOOK_BY_ID = "select * from books where id = ?;";
    ConnectionDAO cs = new ConnectionDAO();
    @Override
    public List<Book> showAllBooks() {
        List<Book> books = new ArrayList<>();

        try {
            Connection connection = cs.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_BOOKS);

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                Book book = new Book(id, title, author, description, quantity);
                books.add(book);
            }
        } catch (SQLException sqlException) {
            cs.printSQLException(sqlException);
        }

        return books;
    }

    @Override
    public Book searchBookById(int id) {
        Book book = null;
        try (Connection connection = cs.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                String className = rs.getString("classroom_name");

                book = new Book(id, title, author, description, quantity);
            }
        } catch (SQLException e) {
            cs.printSQLException(e);
        }
        return book;
    }

    @Override
    public boolean borrowBook(Book book) throws SQLException {
        return false;
    }
}

