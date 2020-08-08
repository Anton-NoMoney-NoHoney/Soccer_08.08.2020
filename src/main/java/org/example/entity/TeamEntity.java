package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class TeamEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_team")
  private long idTeam;
  @Column(name = "name_team")
  private String nameTeam;
  @Column(name = "country_team")
  private String countryTeam;
  @Column(name = "city_team")
  private String cityTeam;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "teamEntity")
  private List<PlayerEntity> player = new ArrayList<>();

  public TeamEntity() {
  }

  public TeamEntity(long idTeam, String nameTeam, String countryTeam, String cityTeam) {
    this.idTeam = idTeam;
    this.nameTeam = nameTeam;
    this.countryTeam = countryTeam;
    this.cityTeam = cityTeam;
  }

  public TeamEntity(long idTeam, String nameTeam, String countryTeam, String cityTeam, List<PlayerEntity> player) {
    this.idTeam = idTeam;
    this.nameTeam = nameTeam;
    this.countryTeam = countryTeam;
    this.cityTeam = cityTeam;
    this.player = player;
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

  public List<PlayerEntity> getPlayers() {
    return player;
  }

  public void setPlayers(List<PlayerEntity> players) {
    this.player = players;
  }
}
