package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.LeagueStanding;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LeagueStandingServices {

    LeagueStanding createLeagueStanding(LeagueStanding leagueStanding, Long teamId);

    List<LeagueStanding> getLeagueStandings();

    LeagueStanding updatingLeagueStandingByName(String teamName);

    List<LeagueStanding> getTopScorer(String topScorer);

    void deleteStanding();
}
