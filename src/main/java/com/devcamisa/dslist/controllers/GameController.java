package com.devcamisa.dslist.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcamisa.dslist.services.GameService;
import com.devcamisa.dslist.dto.GameDTO;
import com.devcamisa.dslist.dto.GameMinDTO;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//The controllers are responsible for receiving the requests and returning the responses
@RestController
@RequestMapping(value = "/games")//Defines the base URL for the controller(simmilar to the views in Django)
public class GameController {
    @Autowired
    private GameService gameService;

    //Method to handle GET requests to /games/{id}
    @GetMapping(value = "/{id}") 
    public GameDTO findById(@PathVariable Long id) {
        //Calls the GameService to find a game by its ID
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping //Annotation to define that this method is a GET request(Simmilar to Django) 
    public List<GameMinDTO> findAll() {
        //Calls the GameService to get all games
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
