package cardapio.app.controller;

import cardapio.app.dtos.CardapioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class CardapioController {
    public ResponseEntity<CardapioDTO> listarItens(){
        return null;
    }

    public ResponseEntity<CardapioDTO> inserirItem(CardapioDTO body) {
        return null;
    }

    public ResponseEntity<CardapioDTO> editarItem (Long id, CardapioDTO body){
        return null;
    }

    public ResponseEntity<CardapioDTO> excluirItem (Long id) {
        return null;
    }
}