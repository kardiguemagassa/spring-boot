package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    private final MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    @GetMapping("/dvdstore-home")
    public void displayHome(){

    }

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movie){
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
    }


}
