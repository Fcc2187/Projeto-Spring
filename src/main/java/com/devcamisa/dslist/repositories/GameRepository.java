package com.devcamisa.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamisa.dslist.entities.Game;

//Game = entity type, Long = type of the ID attribute
public interface GameRepository extends JpaRepository<Game, Long> {

}
