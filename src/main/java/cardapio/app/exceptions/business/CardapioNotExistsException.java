package cardapio.app.exceptions.business;

public class CardapioNotExistsException extends RuntimeException {
    public CardapioNotExistsException(String msg) {
        super(msg);
    }
}
