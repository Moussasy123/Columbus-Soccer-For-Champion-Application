package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByTeamName(String teamName);

    void deleteByTeamName(String teamName);


}
