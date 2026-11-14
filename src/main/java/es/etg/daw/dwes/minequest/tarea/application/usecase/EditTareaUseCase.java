package es.etg.daw.dwes.minequest.tarea.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dwes.minequest.tarea.application.command.EditTareaCommand;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public class EditTareaUseCase {

    public Tarea update(EditTareaCommand command) {
        Tarea tarea = Tarea.builder()
                           .id(command.id())
                           .descripcion(command.descripcion())
                           .prioridad(command.prioridad())
                           .createdAt(LocalDateTime.now()).build();

        return tarea;
    }
}
