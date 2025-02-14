package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.controller;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.LeagueStanding;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service.LeagueStandingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leaguestanding")
public class LeagueStandingController {

    @Autowired
    private LeagueStandingServices leagueStandingService;



    public LeagueStandingController(LeagueStandingServices leagueStandingService) {
        this.leagueStandingService = leagueStandingService;
    }


    @PostMapping("/createstanding")
    public ResponseEntity<LeagueStanding> createLeagueStanding(@RequestBody LeagueStanding leagueStandingRequest){
        Team team = new Team();
        team.setTeamId(leagueStandingRequest.getTeam().getTeamId());


        LeagueStanding leagueStanding = new LeagueStanding(
                leagueStandingRequest.getTeamName(),
                leagueStandingRequest.getFixture(),
                leagueStandingRequest.getTimeOfGame(),
                leagueStandingRequest.getFieldNumber(),
                leagueStandingRequest.getTeamStanding(),
                leagueStandingRequest.getTopScore(),
                team

        );
        LeagueStanding createdLeagueStanding = leagueStandingService.createLeagueStanding(leagueStanding, leagueStandingRequest.getTeam().getTeamId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeagueStanding);
    }

    @GetMapping("/getstanding")
    public ResponseEntity<List<LeagueStanding>> getLeagueStandings(){
        List<LeagueStanding> leagueStanding = leagueStandingService.getLeagueStandings();
        return ResponseEntity.status(HttpStatus.OK).body(leagueStanding);
    }

    @PutMapping("/updatestanding/{teamName}")
   public ResponseEntity<LeagueStanding> updateLeagueStandingByTeamName(@PathVariable String teamName){
        LeagueStanding updatedLeagueStanding = leagueStandingService.updatingLeagueStandingByName(teamName);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLeagueStanding);
    }

    @GetMapping("/topscorer/{topScorer}")
    public ResponseEntity<List<LeagueStanding>> getTopScorer(@PathVariable String topScorer){
        List<LeagueStanding> topScorerList = leagueStandingService.getTopScorer(topScorer);
        return ResponseEntity.status(HttpStatus.OK).body(topScorerList);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteLeagueStanding(){
        leagueStandingService.deleteStanding();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
