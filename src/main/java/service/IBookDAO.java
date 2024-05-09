package service;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    public List<Book> showAllBooks();
    public Book searchBookById(int id);
    public boolean borrowBook(Book book) throws SQLException;
}