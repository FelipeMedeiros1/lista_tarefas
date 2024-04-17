package medeiros.felipe.lista_tarefas.domain.tarefa;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TarefaService {

    private TarefaRepository repository;

    public List<Tarefa> create(Tarefa tarefa) {
        repository.save(tarefa);
        return list();

    }

    public List<Tarefa> list() {
        Sort sort = Sort.by("status").descending().and(Sort.by("nome").ascending());
        return repository.findAll(sort);


    }

    public List<Tarefa> update(Tarefa tarefa) {
        repository.save(tarefa);
        return list();

    }

    public List<Tarefa> delete(Long id) {
        repository.deleteById(id);
        return list();
    }


    public Optional<Tarefa> findById(Long tarefaId) {
        return repository.findById(tarefaId);
    }
}
