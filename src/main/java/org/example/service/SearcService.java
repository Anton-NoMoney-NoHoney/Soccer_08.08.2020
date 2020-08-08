package org.example.service;

import org.example.dto.PlayerDto;
import org.example.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearcService {


    /** В каждой команде должны быть определены следующие свойства: страна(String), город(String) и уникальное имя.
     * В каждом игроке должны быть определены следующие свойства: имя(String), позиция на которой игрок играет(String) и имя.
     * Приложение должно давать возможность выполнять все CRUD операции через REST как для команды так и для игрока.
     * Также ваша программа должна иметь следующие функции доступные по REST:

     найти является ли команда полной(колличество людей в команде 11 и более)
     найти всех игроков команды по имени команды
     найти всех игроков команды по имени команды  и позиции на которой эти игроки играют
     * @return
     */

     boolean addPlayer(PlayerDto player);
     boolean addTeam(TeamDto team);
     boolean modifyPlayer(PlayerDto player);
     boolean modifyTeam(TeamDto team);
     boolean removePlayer(PlayerDto player);
     boolean removeTeam(TeamDto team);

     boolean validateTeam(String nameTeam);
     List<PlayerDto> findPlayers(String nameTeam);
     List<PlayerDto> findPlayers(String nameTeam,String role);






}
