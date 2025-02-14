package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Registration;

import java.util.List;

public interface RegistrationService {

    List<Registration> getAllRegisterTeams();
    Registration createRegistration(Registration registration, Long teamId);
    Registration upateRegistration(String registrationName, Registration registration);
    void deleteRegistration(String teamName);
    


}
