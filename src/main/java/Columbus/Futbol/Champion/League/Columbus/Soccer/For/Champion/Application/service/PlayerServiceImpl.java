package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Player;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayersRepository playersRepository;


    @Override
    @Transactional
    public Player createPlayer(Player player) {
        Player newPlayer = new Player();
        newPlayer.setName(player.getName());
        newPlayer.setTeam(player.getTeam());
        newPlayer.setPosition(player.getPosition());
        newPlayer.setDateOfBirth(player.getDateOfBirth());
        return newPlayer;
    }


    @Override
    public List<Player> getPlayers() {
        return playersRepository.findAll();
    }

    @Override
    public List<Player> getPlayersFromTeams(String teamName) {
        return playersRepository.findAll().stream().filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByName(String searchText) {
        return playersRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByPosition(String searchText) {
        return  playersRepository.findAll().stream()
                .filter(players -> players.getPosition().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playersRepository.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }


    @Override
    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playersRepository.findByName(updatedPlayer.getName());
        if (existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setName(updatedPlayer.getTeam().getTeamName());
            playerToUpdate.setName(updatedPlayer.getPosition());

            playersRepository.save(playerToUpdate);
            return  playerToUpdate;
        }
        return null;
    }

    @Override
    public Player createPlayerDateOfBirth(String name, LocalDate dateOfBirth) {
        Player creatingPlayerDOB = new Player();
        creatingPlayerDOB.setName(name);
        creatingPlayerDOB.setDateOfBirth(dateOfBirth);
        return playersRepository.save(creatingPlayerDOB);
    }

    @Override
    public Player updatePlayerDOB(LocalDate dateOfBirth) {
        Optional<Player> playerOptional = playersRepository.findBydateOfBirth(dateOfBirth);
        if(playerOptional.isPresent()){
            Player playerToUpdate = playerOptional.get();
            playerToUpdate.setDateOfBirth(dateOfBirth);
            playersRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }


    @Override
    @Transactional
    public void deletePlayerByName(String playerName) {
        playersRepository.deleteByName(playerName);
    }
}
