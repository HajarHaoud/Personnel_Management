package com.mstrsi.pers_management.services;

import com.mstrsi.pers_management.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class IdentificationServiceImpl implements IdentificationService {



    @Override
    public String genererMatricule(Role role) {
        // Format : ROLE-YYYYMMDD-XXXX
        String prefix = role.name().substring(0,2);
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        String random = String.format("%04d", new Random().nextInt(10000));
        return String.format("%s%s%s", prefix, date, random);
    }

    @Override
    public String genererMotDePasse() {
        String chars = "AZERTYUIOPQSDFGHJKLMWXCVBNazertyuiopqsdfghjklmwxcvbn1234567890!@#$%" ;
        StringBuilder pass = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            pass.append(chars.charAt(random.nextInt(chars.length())));
        }
        return pass.toString();
    }
}
