package org.example.converter;

import org.example.dto.PlayerDto;
import org.example.entity.PlayerEntity;
import org.example.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerConverter {

    private    TeamRepo teamRepo;

    @Autowired
    public PlayerConverter(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }


    public PlayerDto entityToDto(PlayerEntity entity){

        return new PlayerDto(entity.getIdPlayer(),entity.getNamePlayer(),entity.getRoleTeam(),entity.getTeamEntity().getNameTeam());
    }


    public PlayerEntity dtoToEntity(PlayerDto dto){


        return new PlayerEntity(dto.getIdPlayer(),
                dto.getNamePlayer(),
                dto.getRoleTeam(),
                teamRepo.getTeam(Long.valueOf(teamRepo.findIdByTaamName(dto.getNameTeam()))));
    }
}
