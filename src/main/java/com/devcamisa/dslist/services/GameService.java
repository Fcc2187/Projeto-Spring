package com.devcamisa.dslist.services;

import java.util.List;

import com.devcamisa.dslist.repositories.GameRepository;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcamisa.dslist.dto.GameDTO;
import com.devcamisa.dslist.dto.GameMinDTO;
import com.devcamisa.dslist.entities.Game;
import com.devcamisa.dslist.projections.GameMinProjection;

@Service //Registering the class as a component to be injected in other classes
public class GameService {

    @Autowired //Injects the dependency automatically
    private GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get(); //get a Game by id 
        return new GameDTO(result); //returns the result and converts Game to GameDTO
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); //Returns a list of Game entities
        return result.stream().map(x -> new GameMinDTO(x)).toList(); //Converts the list of Games entities to a list of GameMinDTO(Excluding some attributes)
    }


    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList(); //Converts the list of Games entities to a list of GameMinDTO(Excluding some attributes)
    }
}
