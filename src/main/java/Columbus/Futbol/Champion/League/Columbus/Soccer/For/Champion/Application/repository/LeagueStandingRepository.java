package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.LeagueStanding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueStandingRepository extends JpaRepository<LeagueStanding,String> {

    List<LeagueStanding> findByTeamName(String teamName);

    List<LeagueStanding> findBytopScore(String topScorer);





}
