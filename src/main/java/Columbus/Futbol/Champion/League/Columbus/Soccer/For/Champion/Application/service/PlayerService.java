package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Player;

import java.time.LocalDate;
import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);
    List<Player> getPlayers();
    List<Player> getPlayersFromTeams(String teamName);
    List<Player> getPlayersByName(String searchText);
    List<Player> getPlayersByPosition(String searchText);
    List<Player> getPlayersByTeamAndPosition(String team, String position);
    Player updatePlayer(Player updatedPlayer);
    Player createPlayerDateOfBirth(String name, LocalDate dateOfBirth);
    Player updatePlayerDOB(LocalDate dateOfBirth);
    void deletePlayerByName(String playerName);



}
