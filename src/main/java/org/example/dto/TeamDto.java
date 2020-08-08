package org.example.dto;

import org.springframework.stereotype.Component;

import java.util.List;


public class TeamDto {

    private long idTeam;
    private String nameTeam;
    private String countryTeam;
    private String cityTeam;
    private List<PlayerDto> players;

    public TeamDto() {
    }

    public TeamDto(long idTeam, String nameTeam, String countryTeam, String cityTeam) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
        this.countryTeam = countryTeam;
        this.cityTeam = cityTeam;
    }

    public TeamDto(long idTeam, String nameTeam, String countryTeam, String cityTeam, List<PlayerDto> players) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
        this.countryTeam = countryTeam;
        this.cityTeam = cityTeam;
        this.players = players;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getCountryTeam() {
        return countryTeam;
    }

    public void setCountryTeam(String countryTeam) {
        this.countryTeam = countryTeam;
    }

    public String getCityTeam() {
        return cityTeam;
    }

    public void setCityTeam(String cityTeam) {
        this.cityTeam = cityTeam;
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }
}
