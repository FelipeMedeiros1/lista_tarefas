package medeiros.felipe.lista_tarefas.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medeiros.felipe.lista_tarefas.domain.resposavel.Responsavel;
import medeiros.felipe.lista_tarefas.domain.resposavel.ResponsavelRepository;
import medeiros.felipe.lista_tarefas.domain.resposavel.ResponsavelService;
import medeiros.felipe.lista_tarefas.domain.tarefa.Tarefa;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
@AllArgsConstructor
public class ResponsavelController {
    private ResponsavelService service;

    @PostMapping
    public void create(@RequestBody @Valid Responsavel responsavel) {
        service.create(responsavel);
    }

    @GetMapping
    public List<Responsavel> list() {
        return service.list();
    }

    @PutMapping
    public void update(@RequestBody @Valid Responsavel responsavel) {
        service.update(responsavel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }


}
