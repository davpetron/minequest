package es.etg.daw.dwes.minequest.tarea.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dwes.minequest.tarea.application.command.EditTareaCommand;
import es.etg.daw.dwes.minequest.tarea.application.usecase.EditTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class EditTareaService {

    private final EditTareaUseCase editTareaUseCase;
    
    public Tarea update(EditTareaCommand command) {
        return editTareaUseCase.update(command);
    }
}
