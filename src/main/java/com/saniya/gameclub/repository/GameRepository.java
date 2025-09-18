package com.saniya.gameclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.saniya.gameclub.modal.Game;

@Repository
public interface GameRepository extends MongoRepository<Game,String>{

    
}

