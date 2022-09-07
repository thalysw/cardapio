package cardapio.app.repository;

import cardapio.app.entities.CardapioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardapioRepository extends PagingAndSortingRepository<CardapioEntity, Long> {

    List<CardapioEntity> findAll();
}
