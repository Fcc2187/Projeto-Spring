package com.devcamisa.dslist.services;

import java.util.List;

import com.devcamisa.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamisa.dslist.dto.GameMinDTO;
import com.devcamisa.dslist.entities.Game;

@Service //Registering the class as a component to be injected in other classes
public class GameService {

    @Autowired //Injects the dependency automatically
    private GameRepository gameRepository;
    
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //Returns a list of Game entities
        return result.stream().map(x -> new GameMinDTO(x)).toList(); //Converts the list of Games entities to a list of GameMinDTO(Excluding some attributes)
    }
}
