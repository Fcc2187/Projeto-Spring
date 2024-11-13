package com.devcamisa.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcamisa.dslist.dto.GameListDTO;
import com.devcamisa.dslist.entities.GameList;

import com.devcamisa.dslist.repositories.GameListRepository;

import java.util.List;

@Service //Registering the class as a component to be injected in other classes
public class GameListService {

    @Autowired //Injects the dependency automatically
    private GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList(); 
    }

}
