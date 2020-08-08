package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class PlayerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_player")
  private long idPlayer;
  @Column(name = "name_player")
  private String namePlayer;
  @Column(name = "role_team")
  private String roleTeam;


  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="id_team_player")
  private TeamEntity teamEntity;


  public PlayerEntity() {
  }

  public PlayerEntity(long idPlayer, String namePlayer, String roleTeam) {
    this.idPlayer = idPlayer;
    this.namePlayer = namePlayer;
    this.roleTeam = roleTeam;
  }

  public PlayerEntity(long idPlayer, String namePlayer, String roleTeam, TeamEntity teamEntity) {
    this.idPlayer = idPlayer;
    this.namePlayer = namePlayer;
    this.roleTeam = roleTeam;
    this.teamEntity = teamEntity;
  }



  public long getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(long idTeam) {
    this.idPlayer = idTeam;
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

  public TeamEntity getTeamEntity() {
    return teamEntity;
  }

  public void setTeamEntity(TeamEntity teamEntity) {
    this.teamEntity = teamEntity;
  }
}
