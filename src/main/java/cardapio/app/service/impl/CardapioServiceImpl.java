package cardapio.app.service.impl;

import cardapio.app.dtos.CardapioDTO;
import cardapio.app.entities.CardapioEntity;
import cardapio.app.exceptions.business.CardapioNotExistsException;
import cardapio.app.repository.CardapioRepository;
import cardapio.app.service.CardapioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CardapioServiceImpl implements CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    @Override
    public CardapioDTO save(CardapioDTO body) {

        CardapioEntity cardapioEntity = new CardapioEntity();
        BeanUtils.copyProperties(body, cardapioEntity);
        cardapioEntity.setTitulo(body.getTitulo());
        cardapioEntity.setDescricao(body.getDescricao());
        cardapioEntity.setValor(body.getValor());
        cardapioEntity.setQuantidade(body.getQuantidade());
        cardapioRepository.save(cardapioEntity);

        CardapioDTO cardapioDTO = new CardapioDTO();
        BeanUtils.copyProperties(cardapioDTO, cardapioEntity);

        return cardapioDTO;
    }

    @Override
    public List<CardapioDTO> getAll() {
        List<CardapioEntity> itens = cardapioRepository.findAll();
        if(itens.isEmpty()) {
            throw new CardapioNotExistsException("Nenhum item foi encontrado!");
        }
        List<CardapioDTO> itensCardapio = new ArrayList<>();
        BeanUtils.copyProperties(itensCardapio, itens);

        return itensCardapio;
    }

    @Override
    public CardapioDTO putItem(Long id, CardapioDTO body) {
        CardapioEntity item = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNotExistsException("Item não encontrado!"));

        CardapioEntity cardapioEntity = new CardapioEntity();

        cardapioEntity.setId(item.getId());
        cardapioEntity.setTitulo(item.getTitulo());
        cardapioEntity.setDescricao(item.getDescricao());
        cardapioEntity.setValor(item.getValor());
        cardapioEntity.setQuantidade(item.getQuantidade());

        cardapioRepository.save(cardapioEntity);

        CardapioDTO cardapio = new CardapioDTO();
        BeanUtils.copyProperties(cardapio, cardapioEntity);

        return cardapio;
    }

    @Override
    public void deleteItem(Long id) {
        CardapioEntity item = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNotExistsException("Item não existe no cardápio!"));

        cardapioRepository.delete(item);
    }

}
