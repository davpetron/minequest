package es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto;

import es.etg.daw.dwes.minequest.tarea.infraestructure.web.validation.TipoTarea;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TareaRequest(
        @NotBlank(message = "{tarea.valid.nombre.no_vacio}")
        @Size(max = 100, message = "{tarea.valid.nombre.size}")
        String nombre,

        @Size(max = 255, message = "{tarea.valid.descripcion.size}")
        String descripcion,

        @NotBlank(message = "{tarea.valid.tipo.no_vacio}")
        @TipoTarea
        String tipo,

        @Min(value = 1, message = "{tarea.valid.prioridad.min}")
        @Max(value = 5, message = "{tarea.valid.prioridad.max}")
        int prioridad) {

}