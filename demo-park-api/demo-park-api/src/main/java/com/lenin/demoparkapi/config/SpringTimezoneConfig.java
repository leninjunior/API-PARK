package com.lenin.demoparkapi.config;


import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class SpringTimezoneConfig {


    @PostConstruct //Após a classe ser iniciado pelo spring, o método construct é executado, fazendo-o executar o Timezone.
    public void timezoneConfig(){

        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
