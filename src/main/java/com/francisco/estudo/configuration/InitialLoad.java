package com.francisco.estudo.configuration;

import com.francisco.estudo.model.Perfil;
import com.francisco.estudo.model.User;
import com.francisco.estudo.model.enuns.PerfilEnum;
import com.francisco.estudo.repo.PerfilRepository;
import com.francisco.estudo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Set;

@Configuration
public class InitialLoad implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        Perfil p1 = new Perfil(null, PerfilEnum.ADMIN.getDescricao());
        Perfil p2 = new Perfil(null, PerfilEnum.USER.getDescricao());
        perfilRepository.saveAll(Arrays.asList(p1, p2));

        User u1 = new User(null, "Francisco", passwordEncoder().encode("123"), Set.of(p1));
        User u2 = new User(null, "Miria", passwordEncoder().encode("123"), Set.of(p2));

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
