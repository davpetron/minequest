package es.etg.daw.dwes.minequest.tarea.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dwes.minequest.tarea.application.command.CreateTareaCommand;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public class CreateTareaUseCase {

    public Tarea create(CreateTareaCommand comando) {

        Tarea tarea = Tarea.builder()
                .nombre(comando.nombre())
                .descripcion(comando.descripcion())
                .tipo(comando.tipo())
                .prioridad(comando.prioridad())
                .createdAt(LocalDateTime.now()).build();

        return tarea;
    }

}