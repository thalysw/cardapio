package cardapio.app.service;

import cardapio.app.dtos.CardapioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardapioService {
    CardapioDTO save(CardapioDTO body);

    List<CardapioDTO> getAll();

    CardapioDTO putItem(Long id, CardapioDTO body);

    void deleteItem(Long id);
}
