package es.etg.daw.dwes.minequest.tarea.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public class TareaFactory {

    public static final Map<Integer, Tarea> getDemoData(){
        Map<Integer, Tarea> datos = new LinkedHashMap<>();

        datos.put(1, new Tarea(1, "Levantar las paredes del castillo", "Muros de piedra de 5 bloques de alto", "Construcción", 4, LocalDateTime.now()));
        datos.put(2, new Tarea(2, "Conseguir diamantes", "Bajar a la capa -58 y minar al menos 10", "Minería", 5, LocalDateTime.now()));
        datos.put(3, new Tarea(3, "Granja de trigo", "Granja de 9x9 junto a la base con agua en el centro", "Granjas", 2, LocalDateTime.now()));

        return datos;
    }
    
}
