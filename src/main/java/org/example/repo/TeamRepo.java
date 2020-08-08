package org.example.repo;

import org.example.entity.TeamEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeamRepo extends CrudRepository<TeamEntity,Long> {

    @Query(value = "select t " +
            " from  TeamEntity t " +
            " where t.idTeam=:idTeam" )
    TeamEntity getTeam(@Param("idTeam") long idTeam);

    @Query(value = "select count(*) \n" +
            "    from  TeamPlay.Team t inner join TeamPlay.Player p on t.id_team=p.id_team_player\n" +
            "    where t.name_team=:teamName",nativeQuery = true)
    Integer getCountPlayer(@Param("teamName") String teamName);


    @Query(value = "select t " +
            "    from  TeamEntity t " +
            "    where t.nameTeam=:teamName")
    TeamEntity getAllPlayerFromTeam(@Param("teamName") String teamName);


    @Query(value = " select  t.idTeam " +
            " from TeamEntity t " +
            " where t.nameTeam=:teamName")
    Integer findIdByTaamName(@Param("teamName")String teamName);


    TeamEntity findByIdTeam(long idTeam);
    TeamEntity findByNameTeam(String nameTeam);
}
