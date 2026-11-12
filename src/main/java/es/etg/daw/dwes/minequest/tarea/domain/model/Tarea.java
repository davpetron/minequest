package es.etg.daw.dwes.minequest.tarea.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Tarea {

    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int prioridad;
    private LocalDateTime createdAt;

}