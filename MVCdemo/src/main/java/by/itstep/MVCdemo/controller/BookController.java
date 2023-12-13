package by.itstep.MVCdemo.controller;

import by.itstep.MVCdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String findAll(Model model){
        model.addAttribute("bookList", bookRepository.findAll());
        return "index";
    }
}
