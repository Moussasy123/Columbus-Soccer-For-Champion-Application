package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team createTeam(Team team);
    List<Team> getAllTeams();
    Optional<Team> getTeamById(Long id);
    void deleteTeam(String name);
    Team updateTeamByName(String teamName, Team team);
}
