package es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.etg.daw.dwes.minequest.tarea.application.command.CreateTareaCommand;
import es.etg.daw.dwes.minequest.tarea.application.command.EditTareaCommand;
import es.etg.daw.dwes.minequest.tarea.application.service.CreateTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.DeleteTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.EditTareaService;
import es.etg.daw.dwes.minequest.tarea.application.service.FindTareaService;
import es.etg.daw.dwes.minequest.tarea.domain.model.Tarea;
import es.etg.daw.dwes.minequest.tarea.infraestructure.mapper.TareaMapper;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaRequest;
import es.etg.daw.dwes.minequest.tarea.infraestructure.web.mvc.dto.TareaResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

  private final CreateTareaService createTareaService;
  private final FindTareaService findTareaService;
  private final DeleteTareaService deleteTareaService;
  private final EditTareaService editTareaService;

  @PostMapping
  @ResponseBody
  public String createTarea(TareaRequest request) {
    CreateTareaCommand comando = TareaMapper.toCommand(request);

    Tarea tarea = createTareaService.createTarea(comando);

    return """
        <!DOCTYPE html>
        <html lang="es">
          <head>
            <meta charset="UTF-8">
            <title>Tarea</title>
          </head>
          <body>
            <h1>Tarea: %s - %s</h1>
            <p>Descripción: %s </p>
            <p>Tipo: %s </p>
            <p>Prioridad: %s </p>
            <p>Creada el: %s </p>
          </body>
        </html>
        """.formatted(tarea.getId(), tarea.getNombre(), tarea.getDescripcion(),
        tarea.getTipo(), tarea.getPrioridad(), tarea.getCreatedAt());
  }

  @GetMapping 
  @ResponseBody 
  public List<TareaResponse> allTarea() {
    return findTareaService.findAll().stream().map(TareaMapper::toResponse).toList();
  }

  @DeleteMapping ("/{id}")
  public ResponseEntity<?> deleteTarea(@PathVariable int id){
    deleteTareaService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping ("/{id}")
  @ResponseBody 
  public TareaResponse editTarea(@PathVariable int id, @RequestBody TareaRequest tareaRequest) {
    EditTareaCommand comando = TareaMapper.toCommand(id, tareaRequest);
    Tarea tarea = editTareaService.update(comando);
    return TareaMapper.toResponse(tarea);
  }

}