package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
@Entity
public class Player {
    @Id
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMMM dd, yyyy")
    private LocalDate dateOfBirth;
    private String position;
    @ManyToOne(fetch = FetchType.EAGER) // Fetch Team immediately
    private Team team;
}
