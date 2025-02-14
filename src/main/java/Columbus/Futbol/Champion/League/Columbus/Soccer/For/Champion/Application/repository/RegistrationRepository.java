package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface RegistrationRepository extends JpaRepository<Registration, String> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Registration r WHERE r.team.teamName = :teamName")
    void deleteRegistrationByteam(@Param("teamName")String registrationName);
}
