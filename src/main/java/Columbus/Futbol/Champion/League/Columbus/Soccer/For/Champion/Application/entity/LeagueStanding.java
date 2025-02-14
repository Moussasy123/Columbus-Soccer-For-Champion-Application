package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "league_standings", uniqueConstraints = @UniqueConstraint(columnNames = "teamName"))
@Entity
public class LeagueStanding {

    @Id
    private  String teamName;
    private String fixture;
    private String timeOfGame;
    private int fieldNumber;
    private int teamStanding;
    private String topScore;


    @ManyToOne(optional = false) // Ensures `team` cannot be null
    @JoinColumn(name = "team_id", nullable = false)
    private Team team; // Foreign key to Team entity
}


