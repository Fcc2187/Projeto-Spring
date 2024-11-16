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

@Service //Registering the class as a component to be injected in other classes
public class GameListService {

    @Autowired //Injects the dependency automatically
    private GameListRepository gameListRepository;
    
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList(); 
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List <GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.get(sourceIndex); 
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
