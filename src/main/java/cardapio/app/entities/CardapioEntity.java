package cardapio.app.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Ocultará os itens que estiverem nulos.
@Table(name = "TB_CARDAPIO")
@Entity
public class CardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "NM_TITULO")
    String titulo;
    @Column(name = "NM_DESCRICAO")
    String descricao;
    @Column(name = "VL_VALOR")
    Double valor;
    @Column(name = "VL_QUANTIDADE")
    Long quantidade;

}
