package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.LeagueStanding;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.LeagueStandingRepository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueStandingImpl implements LeagueStandingServices{


    @Autowired
    private LeagueStandingRepository leagueStandingRepository;

    @Autowired
    private TeamRepository teamRepository;



    @Override
    public LeagueStanding createLeagueStanding(LeagueStanding leagueStanding, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));

        leagueStanding.setTeam(team);

        return leagueStandingRepository.save(leagueStanding);


    }

    @Override
    public List<LeagueStanding> getLeagueStandings() {
        return leagueStandingRepository.findAll();
    }

    @Override
    public LeagueStanding updatingLeagueStandingByName(String teamName) {
        List<LeagueStanding> leagueStandings = leagueStandingRepository.findByTeamName(teamName);
        if(leagueStandings.isEmpty()){
            return null;
        }
        LeagueStanding leagueStanding = leagueStandings.get(0);
        return leagueStandingRepository.save(leagueStanding);
    }

    @Override
    public List<LeagueStanding> getTopScorer(String topScorer) {
        return leagueStandingRepository.findBytopScore(topScorer);
    }

    @Override
    public void deleteStanding() {
        leagueStandingRepository.deleteAll();
    }
}
