package cardapio.app.exceptions.business;

public class CardapioExistsException extends RuntimeException {
    public CardapioExistsException(String msg) {
        super(msg);
    }
}
