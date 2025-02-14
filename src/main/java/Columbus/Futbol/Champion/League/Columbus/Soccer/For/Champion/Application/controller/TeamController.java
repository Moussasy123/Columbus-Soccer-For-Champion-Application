package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.controller;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/team")
public class TeamController {


    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        Team createdTeam = teamService.createTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @GetMapping("/allteams")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> allTeams = teamService.getAllTeams();
        return ResponseEntity.status(HttpStatus.OK).body(allTeams);
    }


    @GetMapping("/{id}")
        public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
            Optional<Team> teamOptional = teamService.getTeamById(id);
            if (teamOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(teamOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }

        @PutMapping("/update/{teamName}")
        public ResponseEntity<Team> updateTeamByName(@PathVariable String teamName, @RequestBody Team team) {
            Team updatedTeam = teamService.updateTeamByName(teamName,team);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTeam);
        }

        @DeleteMapping("/delete/{teamName}")
        public ResponseEntity<Void> deleteTeam(@PathVariable String teamName) {
            teamService.deleteTeam(teamName);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


}
