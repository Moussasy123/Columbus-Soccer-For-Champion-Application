package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String leagueId;
    @Column(unique = true)
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> players; // One team can have many players

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, optional = false)
    private Registration registration; // One registration per team

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<LeagueStanding> leagueStandings; // One team can have many league standings


    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", leagueId=" + leagueId +
                ", team_name='" + teamName + '\'' +
                '}';
    }
}
