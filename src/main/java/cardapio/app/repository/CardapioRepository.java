package cardapio.app.repository;

import cardapio.app.entities.CardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Long, CardapioEntity> {
}
