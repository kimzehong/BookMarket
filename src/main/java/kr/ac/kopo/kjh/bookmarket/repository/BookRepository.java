package kr.ac.kopo.kjh.bookmarket.repository;
import kr.ac.kopo.kjh.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String id);
    List<Book> getBookListByCategory(String title);
    Set<Book> getBookSetByFilter(Map<String, List<String>> filter);
    void setNewBook(Book book);
}