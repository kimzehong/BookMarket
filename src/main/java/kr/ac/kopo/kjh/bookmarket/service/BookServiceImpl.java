package kr.ac.kopo.kjh.bookmarket.service;

import kr.ac.kopo.kjh.bookmarket.domain.Book;
import kr.ac.kopo.kjh.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBookList() {
        return bookRepository.getAllBookList();
    }

    @Override
    public Book getBookById(String bookId) {
        Book book = bookRepository.getBookById(bookId);
        return book;
    }

    @Override
    public List<Book> getBookListByCategory(String category){
        List<Book> boosByCategory = bookRepository.getBookListByCategory(category);
        return boosByCategory;
    }

    @Override
    public Set<Book> getBookSetByFilter(Map<String, List<String>> filter) {
        Set<Book> bookSetByFilter = bookRepository.getBookSetByFilter(filter);

        return bookSetByFilter;
    }

    @Override
    public void setNewBook(Book book) {

    }
}