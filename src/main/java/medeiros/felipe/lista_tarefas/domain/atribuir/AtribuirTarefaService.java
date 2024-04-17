package medeiros.felipe.lista_tarefas.domain.atribuir;

import lombok.AllArgsConstructor;
import medeiros.felipe.lista_tarefas.domain.resposavel.Responsavel;
import medeiros.felipe.lista_tarefas.domain.resposavel.ResponsavelRepository;
import medeiros.felipe.lista_tarefas.domain.resposavel.ResponsavelService;
import medeiros.felipe.lista_tarefas.domain.tarefa.Tarefa;
import medeiros.felipe.lista_tarefas.domain.tarefa.TarefaRepository;
import medeiros.felipe.lista_tarefas.domain.tarefa.TarefaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtribuirTarefaService {
    private ResponsavelRepository responsavelRepository;
    private TarefaRepository tarefaRepository;

    private AtribuirTarefaRepository atribuirTarefaRepository;

    public List<AtribuirTarefa> atribuirTarefaParaResponsavel(AtribuirTarefa atribuir) {
        Tarefa tarefa = escolherTarefa(atribuir.getTarefa());
        Responsavel responsavel = escolherResponsavel(atribuir.getResponsavel());

        var novaAtribuicao = new AtribuirTarefa(null, tarefa, responsavel);
        atribuirTarefaRepository.save(novaAtribuicao);

        return atribuirTarefaRepository.findAll();

    }

    public Responsavel escolherResponsavel(Responsavel responsavel) {
        Optional<Responsavel> optionalResponsavel = Optional.of(responsavelRepository.getReferenceById(responsavel.getId()));
        if (optionalResponsavel.isPresent()) {
            Responsavel responsavelEscolhido = optionalResponsavel.get();
            return responsavelEscolhido;
        }
        return null;
    }

    public Tarefa escolherTarefa(Tarefa tarefa) {
        Optional<Tarefa> optionalTarefa = Optional.of(tarefaRepository.getReferenceById(tarefa.getId()));
        if (optionalTarefa.isPresent()) {
            Tarefa tarefaEscolhida = optionalTarefa.get();
            return tarefaEscolhida;
        }
        return null;
    }
}

