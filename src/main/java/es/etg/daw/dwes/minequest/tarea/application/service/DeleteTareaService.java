package es.etg.daw.dwes.minequest.tarea.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dwes.minequest.tarea.application.usecase.DeleteTareaUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class DeleteTareaService {
    
    private final DeleteTareaUseCase deleteTareaUseCase;

    public void delete(int id) {
        deleteTareaUseCase.delete(id);
    }
}
