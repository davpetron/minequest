package es.etg.daw.dwes.minequest.tarea.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public class FindTareaUseCase {
    
    public List<Tarea> findAll() {
        
        List<Tarea> lista =  new ArrayList<>();
        lista.add(new Tarea(1, "Levantar las paredes del castillo", "Muros de piedra de 5 bloques de alto", "Construcción", 4, LocalDateTime.now()));
        lista.add(new Tarea(2, "Conseguir diamantes", "Bajar a la capa -58 y minar al menos 10", "Minería", 5, LocalDateTime.now()));
        lista.add(new Tarea(3, "Granja de trigo", "Granja de 9x9 junto a la base con agua en el centro", "Granjas", 2, LocalDateTime.now()));

        return lista;
    }
}
