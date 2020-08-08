package org.example.repo;

import org.example.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepo  extends CrudRepository<PlayerEntity,Long> {


    PlayerEntity findByIdPlayer(long idPlayer);
    PlayerEntity findByNamePlayer(String namePlayer);

}
