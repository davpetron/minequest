package es.etg.daw.dwes.minequest.tarea.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dwes.minequest.tarea.application.service.CreateTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.DeleteTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.EditTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.FindTareaService;
import es.etg.daw.dwes.minequest.tarea.application.usecase.CreateTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.application.usecase.DeleteTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.application.usecase.EditTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.application.usecase.FindTareaUseCase;
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

    @Bean 
    public FindTareaUseCase findTareaUseCase() {
        return new FindTareaUseCase();
    }

    @Bean 
    public FindTareaService findTareaService() {
        return new FindTareaService(findTareaUseCase());
    }

    @Bean 
    public DeleteTareaUseCase deleteTareaUseCase() {
        return new DeleteTareaUseCase();
    }

    @Bean 
    public DeleteTareaService deleteTareaService() {
        return new DeleteTareaService(deleteTareaUseCase());
    }

    @Bean 
    public EditTareaUseCase editTareaUseCase() {
        return new EditTareaUseCase();
    }

    @Bean
    public EditTareaService editTareaService() {
        return new EditTareaService(editTareaUseCase());
    }

}