package es.etg.daw.dwes.minequest.tarea.domain.error;

public class TareaNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "tarea";

    public TareaNotFoundException() {
        super(ENTIDAD);
    }

    public TareaNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}
