package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.service;

import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.repository.TeamRepository;
import Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application.entity.Team;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteTeam(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }

        Optional<Team> team = teamRepository.findByTeamName(name).stream().findFirst();

        if (team.isPresent()) {
            teamRepository.deleteByTeamName(name);
        } else {
            throw new EntityNotFoundException("Team with name " + name + " not found.");
        }
    }

    @Override
    public Team updateTeamByName(String teamName, Team team) {
        // Retrieve the first team with the specified name
        Optional<Team> existingTeam = teamRepository.findByTeamName(teamName).stream().findFirst();

        if (existingTeam.isPresent()) {
            Team teamToUpdate = existingTeam.get();

            // Update the fields with values from the input `team` object
            teamToUpdate.setLeagueId(team.getLeagueId());
            teamToUpdate.setTeamName(team.getTeamName());

            // Save the updated team back to the repository
            return teamRepository.save(teamToUpdate);
        } else {
            // Handle the case where the team was not found (throw an exception or return null as appropriate)
            throw new EntityNotFoundException("Team with name " + teamName + " not found");
        }
    }


}
