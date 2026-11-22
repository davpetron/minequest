package es.etg.daw.dwes.minequest.tarea.domain.error;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity) {
        super("%s no encontrada".formatted(entity));
    }
    
    public EntityNotFoundException(String entity, int id) {
        super("%s con id %s no encontrada".formatted(entity, id));
    }

    public EntityNotFoundException(String entityPlural, String campo, Object valor) {
        super("No hay %s con %s %s".formatted(entityPlural, campo, valor));
    }
}
