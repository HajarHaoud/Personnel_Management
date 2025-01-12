package com.mstrsi.pers_management.service;


import com.mstrsi.pers_management.dtos.AgentDto;
import com.mstrsi.pers_management.services.AgentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
public class AgentServiceTest {

    @Autowired
    private AgentService agentService;

    @Test
    void testCreationAgent() {
        AgentDto agentDto = new AgentDto();
        agentDto.setFirstName("John");
        agentDto.setLastName("Doe");
        agentDto.setEmail("john.doe@example.com");
        agentDto.setPhone("0123456789");
        agentDto.setBirthDate("1990-01-01");
        agentDto.setCity("Paris");
        agentDto.setCountry("France");
        agentDto.setSalary(45000.0);

        AgentDto createdAgent = agentService.createAgent(agentDto);


    }
}
