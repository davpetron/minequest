package es.etg.daw.dwes.minequest.tarea.application.usecase;

import es.etg.daw.dwes.minequest.tarea.application.command.EditTareaCommand;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.domain.repository.TareaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class EditTareaUseCase {

    private final TareaRepository tareaRepository;
    private final FindTareaUseCase findTareaUseCase;

    public Tarea update(EditTareaCommand command) {

        Tarea tareaExistente = findTareaUseCase.findById(command.id());

    tareaExistente.setNombre(command.nombre());
    tareaExistente.setDescripcion(command.descripcion());
    tareaExistente.setTipo(command.tipo());
    tareaExistente.setPrioridad(command.prioridad());
    
        return tareaRepository.save(tareaExistente);
    }

}
