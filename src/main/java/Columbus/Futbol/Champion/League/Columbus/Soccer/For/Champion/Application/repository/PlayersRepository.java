package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface PlayersRepository extends JpaRepository<Player, String > {

    void deleteByName(String playerName);

    Optional<Player> findByName(String name);

    Optional<Player> findBydateOfBirth(LocalDate dateOfBirth);


}
