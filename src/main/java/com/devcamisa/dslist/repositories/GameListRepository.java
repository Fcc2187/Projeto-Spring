package com.devcamisa.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamisa.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}