package es.etg.daw.dwes.minequest.tarea.domain.error;

public class TareaNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "tarea";
    public static final String ENTIDAD_PLURAL = "tareas";

    public TareaNotFoundException() {
        super(ENTIDAD);
    }

    public TareaNotFoundException(int id) {
        super(ENTIDAD, id);
    }

    public TareaNotFoundException(String campo, Object valor) {
        super(ENTIDAD_PLURAL, campo, valor);
    }
}
