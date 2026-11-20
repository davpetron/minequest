package es.etg.daw.dwes.minequest.tarea.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dwes.minequest.tarea.application.command.CreateTareaCommand;
import es.etg.daw.dwes.minequest.tarea.application.command.EditTareaCommand;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaRequest;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaResponse;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    CreateTareaCommand toCommand(TareaRequest request);

    TareaResponse toResponse(Tarea tarea);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.descripcion", target = "descripcion")
    @Mapping(source = "request.prioridad", target = "prioridad")
    EditTareaCommand toCommand(int id, TareaRequest request);
}