package es.etg.daw.dwes.minequest.tarea.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dwes.minequest.tarea.application.service.CreateTareaService;
import es.etg.daw.dwes.minequest.tarea.application.usecase.CreateTareaUseCase;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class TareaConfig {

    @Bean
    public CreateTareaUseCase createTareaUseCase() {
        return new CreateTareaUseCase();
    }

    @Bean
    public CreateTareaService createTareaService() {
        return new CreateTareaService(createTareaUseCase());
    }

}