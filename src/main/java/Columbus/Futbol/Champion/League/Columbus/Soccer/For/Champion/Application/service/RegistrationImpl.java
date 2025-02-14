package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Registration;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.RegistrationRepository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistrationImpl implements RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private  TeamRepository teamRepository;


    @Override
    public List<Registration> getAllRegisterTeams() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration createRegistration(Registration registration, Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));

        // Check if a registration already exists for this team
        if (team.getRegistration() != null) {
            throw new RuntimeException("Registration already exists for this team");
        }

        // Assign the team to the registration
        registration.setTeam(team);

        // Save and return the registration
        return registrationRepository.save(registration);
    }



    @Override
    public Registration upateRegistration(String registrationName, Registration registrationSetup) {
        List<Registration> registrationlList = registrationRepository.findAll();
        if (!registrationlList.isEmpty()) {
            Registration registration = registrationlList.getFirst();
            registration.setCoachFullName(registrationSetup.getCoachFullName());
            registration.setTeam(registrationSetup.getTeam());
            registration.setAddress(registrationSetup.getAddress());
            registration.setContact(registrationSetup.getContact());
            registrationRepository.save(registration);

            return registration;

        }
        return null;

    }

    @Override
    @Transactional
    public void deleteRegistration(String teamName) {
        registrationRepository.deleteRegistrationByteam(teamName);
    }



}
