package br.com.willamessantos.challenge_itau.config;

import br.com.willamessantos.challenge_itau.core.models.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    public List<Transaction> transactions () {
        return new ArrayList<>();
    }
}
