package medeiros.felipe.lista_tarefas.controller;

import jakarta.validation.Valid;
import medeiros.felipe.lista_tarefas.domain.atribuir.AtribuirTarefa;
import medeiros.felipe.lista_tarefas.domain.atribuir.AtribuirTarefaService;
import medeiros.felipe.lista_tarefas.domain.tarefa.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atribuir-tarefa")
public class AtribuirTarefaController {

    @Autowired
    private AtribuirTarefaService atribuirTarefaService;

    @PostMapping
    public ResponseEntity<String> atribuirTarefa(@RequestBody @Valid AtribuirTarefa atribuirTarefa) {
        var tarefas = atribuirTarefaService.atribuirTarefaParaResponsavel(atribuirTarefa);

        return ResponseEntity.ok(tarefas.toString());
    }
}
