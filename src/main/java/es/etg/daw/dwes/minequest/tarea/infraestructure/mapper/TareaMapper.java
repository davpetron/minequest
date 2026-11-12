package es.etg.daw.dwes.minequest.tarea.infraestructure.mapper;

import es.etg.daw.dwes.minequest.tarea.application.command.CreateTareaCommand;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaRequest;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaResponse;

public class TareaMapper {

    public static CreateTareaCommand toCommand(TareaRequest request) {
        return new CreateTareaCommand(request.nombre(),
                request.descripcion(), request.tipo(),
                request.prioridad());
    }

    public static TareaResponse toResponse(Tarea tarea) {
        return new TareaResponse(tarea.getId(), tarea.getNombre(),
                tarea.getDescripcion(), tarea.getTipo(),
                tarea.getPrioridad(), tarea.getCreatedAt());
    }
}