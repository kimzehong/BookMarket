package kr.ac.kopo.kjh.bookmarket.repository;
import kr.ac.kopo.kjh.bookmarket.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String id);
    List<Book> getBookListByCategory(String title);
}