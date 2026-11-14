package es.etg.daw.dwes.minequest.tarea.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter 
@AllArgsConstructor 
@Accessors(fluent = true)
public class EditTareaCommand {
    
    private int id;
    private String descripcion;
    private int prioridad;
}
