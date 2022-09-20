package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Book;
import net.proselyte.springbootdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(int id){
        // метод getOne попробовать
        return  bookRepository.findById(id).orElse(null);

    }
    public List<Book> findAll(){
       return bookRepository.findAll();
    }
    public Book saveBook(Book book){
        return bookRepository.save(book);

    }
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }

    public void deleteAllBook(){
       bookRepository.deleteAll();
    }

}
