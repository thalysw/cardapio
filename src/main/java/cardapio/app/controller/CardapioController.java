package cardapio.app.controller;

import cardapio.app.dtos.CardapioDTO;
import cardapio.app.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<List<CardapioDTO>> listarItens(){
        List<CardapioDTO> itens = cardapioService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    @PostMapping
    public ResponseEntity<CardapioDTO> inserirItem(@RequestBody CardapioDTO body) {
        CardapioDTO cardapioDTO = cardapioService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardapioDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<CardapioDTO> editarItem (@PathVariable Long id, @RequestBody CardapioDTO body){
        CardapioDTO item = cardapioService.putItem(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> excluirItem (@PathVariable Long id) {
        cardapioService.deleteItem(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete success!");
    }
}