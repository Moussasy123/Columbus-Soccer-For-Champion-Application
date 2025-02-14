package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.controller;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Player;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Registration;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.RegistrationRepository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.TeamRepository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

    @Autowired
    private  RegistrationService registrationService;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping ("/createregisteration")
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration, @RequestParam Long teamId){
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));
        registration.setTeam(team);

        Registration createdRegistration = registrationRepository.save(registration);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdRegistration);
    }

    @GetMapping("/getallregistration")
    public ResponseEntity<List<Registration>> getAllRegistration(){
        List<Registration> registrationList = registrationService.getAllRegisterTeams();
        return ResponseEntity.status(HttpStatus.OK).body(registrationList);
    }

    @PutMapping("/updateregistration/{registrationname}")
    public ResponseEntity<Registration> updateRegistrationName(@PathVariable String registrationname,@RequestBody Registration registration){
        Registration updateRegistration = registrationService.upateRegistration(registrationname,registration);
        return ResponseEntity.status(HttpStatus.OK).body(updateRegistration);
    }

    @DeleteMapping("/delete/{registration}")
    public ResponseEntity<Registration> deleteRegistration(@PathVariable String registration){
        registrationService.deleteRegistration(registration);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
