package org.example.rest;

import org.example.dto.PlayerDto;
import org.example.dto.TeamDto;
import org.example.service.SearcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class Rest {

    private     SearcService searcService;

    @Autowired
    public Rest(SearcService searcService) {
        this.searcService = searcService;
    }

    @GetMapping
    public String get(){
        return "";
    }

    @GetMapping("/validate/{name}")
    public boolean findById(@PathVariable(value = "name") String name) {
        return searcService.validateTeam(name);
    }

    @GetMapping("/players/{name}")
    public List<PlayerDto> findByPlayers(@PathVariable(value = "name") String name) {
        return searcService.findPlayers(name);
    }
    @GetMapping("/players/{name}/{role}")
    public List<PlayerDto> findByPlayersByRole(@PathVariable(value = "name") String name,@PathVariable(value = "role") String role) {
        return searcService.findPlayers(name,role);
    }

    /**
     * {
     * "namePlayer":"VAsay",
     * "roleTeam":"5445",
     * "nameTeam":"Dvor"
     * }
     * */
    @PostMapping("/add/players/")
    public boolean addPlaer(@RequestBody PlayerDto player){
        return searcService.addPlayer(player);
    }

    /**
     * {
     * "nameTeam":"School",
     * "countryTeam":"unknown",
     * "cityTeam":"NONE"
     * }
     * */
    @PostMapping("/add/teams/")
    public boolean addTeam(@RequestBody TeamDto team){
        return searcService.addTeam(team);
    }

    /**
     * {
     * "idPlayer": 9,
     * "namePlayer":"VAsay",
     * "roleTeam":"5445",
     * "nameTeam":"Dnipro"
     * }
     * */
    @PutMapping("/modify/player")
    public boolean putPlayer(@RequestBody PlayerDto player){
        return searcService.modifyPlayer(player);
    }

    /**
     * {
     * "idTeam":4,
     * "nameTeam":"School_1",
     * "countryTeam":"uncnown",
     * "cityTeam":"NONE"
     * }
     * */
    @PutMapping("/modify/team")
    public boolean putTeam(@RequestBody TeamDto team){
        return searcService.modifyTeam(team);
    }

    /**
     * {
     * "idPlayer": 9,
     * "namePlayer":"VAsay",
     * "roleTeam":"5445",
     * "nameTeam":"Dnipro"
     * }
     * */
    @DeleteMapping("/remove/player")
    public boolean removePlayer(@RequestBody PlayerDto player){
        return  searcService.removePlayer(player);
    }

    /**
     * {
     * "idTeam":4,
     * "nameTeam":"School_1",
     * "countryTeam":"uncnown",
     * "cityTeam":"NONE"
     * }
     * */
    @DeleteMapping("/remove/team")
    public boolean removeTeam(@RequestBody TeamDto team){
        return  searcService.removeTeam(team);
    }

}
