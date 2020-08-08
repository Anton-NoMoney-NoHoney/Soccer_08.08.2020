package org.example.service.impl;

import org.example.converter.PlayerConverter;
import org.example.converter.TeamConverter;
import org.example.dto.PlayerDto;
import org.example.dto.TeamDto;
import org.example.entity.PlayerEntity;
import org.example.entity.TeamEntity;
import org.example.repo.PlayerRepo;
import org.example.repo.TeamRepo;
import org.example.service.SearcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearcService {

    private    PlayerRepo playerRepo;
    private    TeamRepo teamRepo;
    private    TeamConverter teamConverter;
    private    PlayerConverter playerConverter;

    @Autowired
    public SearchServiceImpl(PlayerRepo playerRepo, TeamRepo teamRepo, TeamConverter teamConverter, PlayerConverter playerConverter) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
        this.teamConverter = teamConverter;
        this.playerConverter = playerConverter;
    }


    @Override
    public boolean validateTeam(String nameTeam) {
        return teamRepo.getCountPlayer(nameTeam)>11;
    }


    @Override
    public List<PlayerDto> findPlayers(String nameTeam) {
        TeamEntity entity=teamRepo.getAllPlayerFromTeam(nameTeam);
        TeamDto dto=teamConverter.entityToDto(entity);
        return dto.getPlayers();
    }

    @Override
    public List<PlayerDto> findPlayers(String nameTeam, String role) {
        System.out.println("ping");
        TeamEntity entity=teamRepo.getAllPlayerFromTeam(nameTeam);
        TeamDto dto=teamConverter.entityToDto(entity);
        return dto.getPlayers().stream().filter(item -> item.getRoleTeam().equals(role)).collect(Collectors.toList());
    }

    @Override
    public boolean addPlayer(PlayerDto player) {

        PlayerEntity entity=playerConverter.dtoToEntity(player);
        try{
            playerRepo.save(entity);
            return true;
        }catch (Exception ex ){
            return false;
        }
    }

    @Override
    public boolean addTeam(TeamDto team) {

        TeamEntity entity=teamConverter.dtoToEntity(team);
        try{
            teamRepo.save(entity);
            return true;
        }catch (Exception ex ){
            return false;
        }
    }

    @Override
    public boolean removePlayer(PlayerDto player) {

        try {
            PlayerEntity entity = playerRepo.findByNamePlayer(player.getNamePlayer());
            playerRepo.delete(entity);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean removeTeam(TeamDto team) {

        try {
            TeamEntity entity = teamRepo.findByNameTeam(team.getNameTeam());
            teamRepo.delete(entity);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean modifyPlayer(PlayerDto player) {

        try{
            PlayerEntity entity= playerRepo.findByIdPlayer(player.getIdPlayer());
            entity.setNamePlayer(player.getNamePlayer());
            entity.setRoleTeam(player.getRoleTeam());
            entity.setTeamEntity(teamRepo.getTeam(Long.valueOf(teamRepo.findIdByTaamName(player.getNameTeam()))));
            playerRepo.save(entity);
            return true;
        }catch (Exception ec){
            return false;
        }
    }

    @Override
    public boolean modifyTeam(TeamDto team) {

        try{
            TeamEntity entity= teamRepo.findByIdTeam(team.getIdTeam());
            entity.setNameTeam(team.getNameTeam());
            entity.setCityTeam(team.getCityTeam());
            entity.setCountryTeam(team.getCountryTeam());
            teamRepo.save(entity);
            return true;
        }catch (Exception ec) {
            return false;
        }
    }
}
