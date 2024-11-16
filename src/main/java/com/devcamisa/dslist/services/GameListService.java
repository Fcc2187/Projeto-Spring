package com.devcamisa.dslist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcamisa.dslist.dto.GameListDTO;
import com.devcamisa.dslist.entities.GameList;
import com.devcamisa.dslist.projections.GameMinProjection;
import com.devcamisa.dslist.repositories.GameListRepository;
import com.devcamisa.dslist.repositories.GameRepository;

import java.util.List;

@Service // Registering the class as a component to be injected in other classes
public class GameListService {

    @Autowired // Injects the dependency automatically
    private GameListRepository gameListRepository;
    
    @Autowired // Injects the dependency automatically
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Marks the method as read-only transactional
    public List<GameListDTO> findAll() {
        // Retrieves all game lists from the repository
        List<GameList> result = gameListRepository.findAll();
        // Converts each GameList entity to a GameListDTO and returns the list
        return result.stream().map(x -> new GameListDTO(x)).toList(); 
    }

    @Transactional // Marks the method as transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        // Retrieves the list of games associated with the given listId
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        // Gets the game at the source index
        GameMinProjection obj = list.get(sourceIndex); 
        // Adds the game to the destination index
        list.add(destinationIndex, obj);

        // Determines the minimum and maximum indices between source and destination
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; 
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; 

        // Updates the position of each game in the list within the range
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i); 
        }
    }
}