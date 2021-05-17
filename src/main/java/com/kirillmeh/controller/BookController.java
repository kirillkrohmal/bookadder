package com.kirillmeh.controller;

import com.kirillmeh.model.Book;
import com.kirillmeh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(path = "")
    public String viewBooksList (


        return "books/list";
    }

    @GetMapping(path = "/{id}")
    public String viewBook (@PathVariable Long id, Model uiModel){
        Book book =  bookService.findById (id);

        uiModel.addAttribute ("book", book);

        return "books/view";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        Book book = bookService.findById (id);
        bookService.delete(book);

        return "redirect:/books";
    }

    @PostMapping(path = "/ready/{id}")
    public String isReadyBook(@PathVariable Long id, RedirectAttributes redirectAttributes){


        return "redirect:/books/{id}";
    }

    @GetMapping(path = "/edition/{id}")
    public String newEditionBook(@PathVariable Long id, Model uiModel){


        return "books/edition";
    }

    @PostMapping(path = "/edition/{id}")
    public String editionSubmit(
            @ModelAttribute Book book,
            @PathVariable Long id,
            @RequestParam MultipartFile file,
            RedirectAttributes redirectAttributes
    ) throws IOException {

    }

    @GetMapping(path = "/add")
    public String addBook(Model uiModel){

        uiModel.addAttribute ("book", new Book());

        return "books/newBook";
    }

    @PostMapping(path = "/add")
    public String addSubmit(
            @ModelAttribute Book book
            ,@RequestParam MultipartFile file
    ) throws IOException {


        return "redirect:/books";
    }

    @GetMapping(path = "/{id}/image")
    @ResponseBody
    public ResponseEntity<byte[]> getImageData(@PathVariable Long id){


    }
}



