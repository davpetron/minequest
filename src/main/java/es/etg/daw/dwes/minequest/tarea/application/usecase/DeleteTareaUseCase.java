package es.etg.daw.dwes.minequest.tarea.application.usecase;

import es.etg.daw.dwes.minequest.tarea.domain.repository.TareaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class DeleteTareaUseCase {

        private final TareaRepository tareaRepository;
        private final FindTareaUseCase findTareaUseCase;
    
    public void delete(int id) {
        
        findTareaUseCase.findById(id);

        tareaRepository.deleteById(id);
    }
}
