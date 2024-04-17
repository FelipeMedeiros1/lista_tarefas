package medeiros.felipe.lista_tarefas.domain.resposavel;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResponsavelService {
    private ResponsavelRepository repository;

    public void create(Responsavel responsavel) {
        repository.save(responsavel);
    }

    public List<Responsavel> list() {
        Sort nome = Sort.by("nome").ascending();
        return repository.findAll(nome);
    }

    public void update(Responsavel responsavel) {
        repository.save(responsavel);
    }

    public void delete(Long id) {
        repository.findById(id);
    }

    public Optional<Responsavel> findById(Long responsavelId) {
        return repository.findById(responsavelId);
    }
}
