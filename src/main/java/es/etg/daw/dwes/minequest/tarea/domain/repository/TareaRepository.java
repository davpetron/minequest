package es.etg.daw.dwes.minequest.tarea.domain.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;

public interface TareaRepository extends CRUDRepository <Tarea, Integer> {
    public Optional<Tarea> getByName(String name);
    public List<Tarea> getByPrioridad(int prioridad);
}
