package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/dvdstore-home";
    }

    //Redirection de la racine vers /dvdstore-home
    @GetMapping("/dvdstore-home")
    public void displayHome(){}



    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movie){}
}
