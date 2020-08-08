package org.example.converter;

import org.example.dto.PlayerDto;
import org.example.dto.TeamDto;
import org.example.entity.PlayerEntity;
import org.example.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamConverter {

    private     PlayerConverter playerConverter;

    @Autowired
    public TeamConverter(PlayerConverter playerConverter) {
        this.playerConverter = playerConverter;
    }


    public TeamDto entityToDto(TeamEntity entity){

        List<PlayerDto> players = new ArrayList<>();
        for(PlayerEntity en: entity.getPlayers()){
            players.add(playerConverter.entityToDto(en));
        }
        return new TeamDto(entity.getIdTeam(),entity.getNameTeam(),entity.getCountryTeam(),entity.getCityTeam(),players);
    }


    public TeamEntity dtoToEntity( TeamDto dto){
        return new TeamEntity(dto.getIdTeam(),dto.getNameTeam(),dto.getCountryTeam(),dto.getCityTeam());
    }

}
