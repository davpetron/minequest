package es.etg.daw.dwes.minequest.tarea.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public class TareaFactory {

    public static final Map<Integer, Tarea> getDemoData(){
        Map<Integer, Tarea> datos = new LinkedHashMap<>();

        datos.put(0, new Tarea(0, "Tarea1","descripcion1","Construccion", 3, LocalDateTime.now()));
        datos.put(1, new Tarea(1, "Tarea2","descripcion2","Mineria", 5, LocalDateTime.now()));
        datos.put(2, new Tarea(2, "Tarea3","descripcion3","Granjas", 1, LocalDateTime.now()));

        return datos;
    }
    
}
