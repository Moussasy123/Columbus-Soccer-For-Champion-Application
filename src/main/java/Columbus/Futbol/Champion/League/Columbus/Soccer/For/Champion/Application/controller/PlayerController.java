package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.controller;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Player;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping("/createplayer")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.createPlayer(player);

//        createdPlayer.getTeam().getTeamName();
//        createdPlayer.getTeam().getLeagueId();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @GetMapping("/getplayers")
    public ResponseEntity<List<Player>>getPlayer(){
        List<Player> allPlayers = playerService.getPlayers();
        return ResponseEntity.status(HttpStatus.OK).body(allPlayers);
    }

    @GetMapping("/playerName/{playerName}")
    public ResponseEntity<List<Player>> getPlayersByName(@PathVariable String playerName) {
        List<Player> getListOfPlayerByname = playerService.getPlayersByName(playerName);
        return ResponseEntity.status(HttpStatus.OK).body(getListOfPlayerByname);
    }

    @GetMapping("/{playerByTeam}")
    public ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable String playerByTeam){
        List<Player> getPlayersFromTeam = playerService.getPlayersFromTeams(playerByTeam);
        return ResponseEntity.status(HttpStatus.OK).body(getPlayersFromTeam);
    }
    @GetMapping("/{playerPosition}")
    public ResponseEntity<List<Player>> getPlayerByPosition(@PathVariable String playerPosition){
        List<Player> gettingPlayerByPosition =  playerService.getPlayersByPosition(playerPosition);
       return ResponseEntity.status(HttpStatus.OK).body(gettingPlayerByPosition);
    }

    @GetMapping("/{team}/{position}")
    public ResponseEntity<List<Player>> getPlayerByTeamAndPosition(@PathVariable String team, @PathVariable String position){
        List<Player> gettingPlayerByTeamAndPosition = playerService.getPlayersByTeamAndPosition(team,position);
                return ResponseEntity.status(HttpStatus.OK).body(gettingPlayerByTeamAndPosition);

    }

    @PutMapping("updatePlayer")
        public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatingPlayer = playerService.updatePlayer(player);
        return ResponseEntity.status(HttpStatus.OK).body(updatingPlayer);
    }

    @PostMapping("creatplayerbirth")
    public ResponseEntity<Player> creatingPlayerDOB(@RequestParam String name,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate dateOfBirth){
        Player creatingPlayerDob = playerService.createPlayerDateOfBirth(name,dateOfBirth);
        return ResponseEntity.status(HttpStatus.CREATED).body(creatingPlayerDob);
    }
    @PutMapping("updateplayerdob")
    public ResponseEntity<Player> updatingPlayerDob(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dateOfBirth){
        Player updatingPlayerDob = playerService.updatePlayerDOB(dateOfBirth);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatingPlayerDob);

    }

    @DeleteMapping("delete/{playername}")
    public ResponseEntity<Void> deletePlayerByName(@PathVariable String playername){
        playerService.deletePlayerByName(playername);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
