package es.etg.daw.dwes.minequest.tarea.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dwes.minequest.tarea.application.command.CreateTareaCommand;
import es.etg.daw.dwes.minequest.tarea.application.usecase.CreateTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateTareaService {

    private final CreateTareaUseCase createTareaUseCase;

    public Tarea createTarea(CreateTareaCommand comando) {
        Tarea tarea = createTareaUseCase.create(comando);
        return tarea;
    }
}
