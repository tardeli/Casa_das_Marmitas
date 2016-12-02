package br.com.casadasmarmitas.modelo;

/**
 *
 * @author Tardeli
 */
public class ItensPedido {
   
    private int cm_IdItemm;
    private Pedido pedido;
    private Produto produto;
    private int cm_Quantidade;

    public int getCm_IdItem() {
        return cm_IdItem;
    }

    public void setCm_IdItem(int cm_IdItem) {
        this.cm_IdItem = cm_IdItem;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCm_Quantidade() {
        return cm_Quantidade;
    }

    public void setCm_Quantidade(int cm_Quantidade) {
        this.cm_Quantidade = cm_Quantidade;
    }
}
