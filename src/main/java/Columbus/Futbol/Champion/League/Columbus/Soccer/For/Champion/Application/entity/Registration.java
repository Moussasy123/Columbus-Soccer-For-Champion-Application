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
@Table(name = "registrations")
@Entity
public class Registration {
    @Id
    private String coachFullName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String contact;
    @OneToOne
    @JoinColumn(name = "team_id", nullable = false, unique = true)
    private Team team;// Foreign key to Team entity

}
