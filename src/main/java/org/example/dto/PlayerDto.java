package org.example.dto;

import org.springframework.stereotype.Component;


public class PlayerDto {
    
    private long idPlayer;
    private String namePlayer;
    private String roleTeam;
    private String nameTeam;


    public PlayerDto() {
    }

    public PlayerDto(long idPlayer, String namePlayer, String roleTeam) {
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.roleTeam = roleTeam;
    }

    public PlayerDto(long idPlayer, String namePlayer, String roleTeam, String nameTeam) {
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.roleTeam = roleTeam;
        this.nameTeam = nameTeam;
    }

    public long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(long idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getRoleTeam() {
        return roleTeam;
    }

    public void setRoleTeam(String roleTeam) {
        this.roleTeam = roleTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
