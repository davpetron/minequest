package es.etg.daw.dwes.minequest.tarea.application.usecase;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dwes.minequest.tarea.domain.error.TareaNotFoundException;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.domain.repository.TareaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class FindTareaUseCase {

    private final TareaRepository tareaRepository;
    
    public List<Tarea> findAll() {
        List<Tarea> tareas = tareaRepository.getAll();

        if (tareas.isEmpty())
            throw new TareaNotFoundException();

        return tareas;
    }

    public Tarea findById(int id) {
        Optional<Tarea> tareaOpt = tareaRepository.getById(id);

        if (tareaOpt.isEmpty()) 
            throw new TareaNotFoundException(id);
        
        return tareaOpt.get();
    }
}