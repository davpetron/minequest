package es.etg.daw.dwes.minequest.tarea.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.domain.repository.TareaRepository;

@Repository 
public class TareaRepositoryMockImpl implements TareaRepository {

    private final Map<Integer, Tarea> tareas = TareaFactory.getDemoData();

    @Override
    public Tarea save(Tarea t) {
        if(t.getId()==0)
            t.setId(obtenerSiguienteId());
        tareas.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId(){
        int ultimo = 0;
        if(!tareas.isEmpty()){
            Collection<Tarea> lista = tareas.values();
            
            for (Tarea t : lista) {
                ultimo = t.getId();
            }

        }
        return ultimo+1;
    }

    @Override
    public List<Tarea> getAll() {
        return new ArrayList<>(tareas.values());
    }

    @Override
    public Optional<Tarea> getById(Integer id) {
        return Optional.ofNullable(tareas.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        tareas.remove(id);
    }

    @Override
    public Optional<Tarea> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    
}
