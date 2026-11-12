package es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record TareaResponse(int id, String nombre, String descripcion, String tipo,
                int prioridad, LocalDateTime createdAt) {

}