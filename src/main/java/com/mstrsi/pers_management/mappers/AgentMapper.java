package com.mstrsi.pers_management.mappers;

import com.mstrsi.pers_management.dtos.AgentDto;
import com.mstrsi.pers_management.entities.Agent;
import com.mstrsi.pers_management.entities.Role;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AgentMapper {

    public static Agent mapAgentDtoToAgent(AgentDto agentDto) {
        Agent agent = new Agent(
                agentDto.getId(),
                agentDto.getUsername(),
                agentDto.getFirstName(),
                agentDto.getLastName(),
                agentDto.getAddress(),
                agentDto.getEmail(),
                agentDto.getPhone(),
                agentDto.getGender(),
                agentDto.getBirthDate(),
                agentDto.getBirthPlace(),
                agentDto.getCity(),
                agentDto.getCountry(),
                agentDto.getJoinDate(),
                agentDto.getSalary(),
                agentDto.getMatricule(),
                agentDto.getPassword()
        );

        if (agentDto.getDiplomes() != null) {
            agent.setDiplomes(
                    agentDto.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeDtoToDiplome)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getGrades() != null) {
            agent.setGrades(
                    agentDto.getGrades().stream()
                            .map(GradeMapper::mapGradeDtoToGrade)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getConges() != null) {
            agent.setConges(
                    agentDto.getConges().stream()
                            .map(CongeMapper::mapCongeDtoToConge)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getQualifications() != null) {
            agent.setQualifications(
                    agentDto.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationDtoToQualification)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getPostes() != null) {
            agent.setPostes(
                    agentDto.getPostes().stream()
                            .map(PosteMapper::mapPosteDtoToPoste)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getAffectations() != null) {
            agent.setAffectations(
                    agentDto.getAffectations().stream()
                            .map(AffectationMapper::mapAffectationDtoToAffection)
                            .collect(Collectors.toList())
            );
        }
        return agent;
    }

    public static AgentDto mapAgentToAgentDTO(Agent agent) {

        AgentDto agentDto = new AgentDto(
                agent.getId(),
                agent.getUsername(),
                agent.getFirstName(),
                agent.getLastName(),
                agent.getAddress(),
                agent.getEmail(),
                agent.getPhone(),
                agent.getGender(),
                agent.getBirthDate(),
                agent.getBirthPlace(),
                agent.getCity(),
                agent.getCountry(),
                agent.getJoinDate(),
                agent.getSalary()
        );

        if (agent.getDiplomes() != null) {
            agentDto.setDiplomes(
                    agent.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getGrades() != null) {
            agentDto.setGrades(
                    agent.getGrades().stream()
                            .map(GradeMapper::mapGradeToGradeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getConges() != null) {
            agentDto.setConges(
                    agent.getConges().stream()
                            .map(CongeMapper::mapCongeToCongeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getQualifications() != null) {
            agentDto.setQualifications(
                    agent.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationToQualificationDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getPostes() != null) {
            agentDto.setPostes(
                    agent.getPostes().stream()
                            .map(PosteMapper::mapPosteToPosteDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getAffectations() != null) {
            agentDto.setAffectations(
                    agent.getAffectations().stream()
                            .map(AffectationMapper::matAffectationToAffectationDto)
                            .collect(Collectors.toList())
            );
        }
        return agentDto;
    }

    public static Agent mapAgentDtoToAgentWithAuth(AgentDto agentDto , String matricule , String password , Role role) {
        Agent agent = mapAgentDtoToAgent(agentDto);
        agent.setMatricule(matricule);
        agent.setPassword(password);
        agent.setRole(role);
        return agent;
    }

    public static AgentDto mapAgentToAgentDtoWithAuth(Agent agent) {
        AgentDto agentDto = mapAgentToAgentDTO(agent);
        agentDto.setMatricule(agent.getMatricule());
        agentDto.setRole(Role.valueOf(agent.getRole().name()));
        return agentDto;
    }

}
