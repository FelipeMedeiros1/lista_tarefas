package medeiros.felipe.lista_tarefas.domain.atribuir;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribuirTarefaRepository extends JpaRepository<AtribuirTarefa,Long> {
}
