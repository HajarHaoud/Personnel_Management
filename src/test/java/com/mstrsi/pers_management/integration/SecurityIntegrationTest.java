package com.mstrsi.pers_management.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAuthenticationFlow() throws Exception {
        // 1. Test accès non authentifié
        mockMvc.perform(get("/api/auth/test-auth"))
                .andExpect(status().isUnauthorized());

        // 2. Test login avec credentials
        mockMvc.perform(post("/login")
                        .param("username", "AG-20240111-0001")  // Exemple de matricule
                        .param("password", "password"))
                .andExpect(status().isOk());

        // 3. Test accès authentifié
        mockMvc.perform(get("/api/auth/test-auth")
                        .with(user("AG-20240111-0001").roles("AGENT")))
                .andExpect(status().isOk())
                .andExpect(content().string("Authentification réussie !"));
    }
}
