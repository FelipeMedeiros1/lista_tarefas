package medeiros.felipe.lista_tarefas.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medeiros.felipe.lista_tarefas.domain.tarefa.Tarefa;
import medeiros.felipe.lista_tarefas.domain.tarefa.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@AllArgsConstructor
public class TarefaController {

    private TarefaService service;


    @PostMapping
    public ResponseEntity<List<Tarefa>> create(@RequestBody @Valid Tarefa tarefa) {
        List<Tarefa> tarefas = service.create(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefas);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> list() {
        List<Tarefa> tarefaList = service.list();
        return ResponseEntity.ok(tarefaList);
    }

    @PutMapping
    public ResponseEntity<List<Tarefa>> update(@RequestBody @Valid Tarefa tarefa) {
        List<Tarefa> update = service.update(tarefa);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Tarefa>> delete(@PathVariable("id") Long id) {
        List<Tarefa> delete = service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
