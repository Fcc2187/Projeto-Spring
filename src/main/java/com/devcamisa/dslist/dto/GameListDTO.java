package com.devcamisa.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devcamisa.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(){}

    public GameListDTO(GameList entity) {
        BeanUtils.copyProperties(entity, this);//Method to copy some datas from entity to dto
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}