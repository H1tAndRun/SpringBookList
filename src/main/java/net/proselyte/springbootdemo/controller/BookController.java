package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Book;
import net.proselyte.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/book-create")
    public String createUserForm(Book book) {
        return "book-create";
    }

    @PostMapping("/book-create")
    public String crateUser(Book book) {
        bookService.saveBook(book);
        return "redirect:/book";
    }

    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/book";

    }
    @GetMapping("book-deleteAll")
    public String deleteAllUser(){
        bookService.deleteAllBook();
        return "redirect:/book";
    }
    @GetMapping("book-update/{id}")
    public String updateUserForm(@PathVariable("id") int id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book-update";
    }
    @PostMapping("/book-update")
    public String updateUser(Book book){
        bookService.saveBook(book);
        return "redirect:/book";
    }

}
