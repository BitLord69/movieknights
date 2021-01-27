package com.movieknights.server.controllers;

import com.movieknights.server.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public void getAll() {
        System.out.println("Hej hopp i getAll!");
    }
}
