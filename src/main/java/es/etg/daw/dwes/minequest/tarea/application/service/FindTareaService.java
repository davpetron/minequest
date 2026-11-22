package es.etg.daw.dwes.minequest.tarea.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dwes.minequest.tarea.application.usecase.FindTareaUseCase;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class FindTareaService {

    private final FindTareaUseCase findTareaUseCase;

    public List<Tarea> findAll() {
        return findTareaUseCase.findAll();
    }

    public List<Tarea> findByPrioridad(int prioridad) {
        return findTareaUseCase.findByPrioridad(prioridad);
    }
}
