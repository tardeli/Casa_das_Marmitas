
package br.com.casadasmarmitas.modelo;

import java.util.Date;

/**
 *
 * @author Tardeli
 */
public class Entrega {
    
    private int codigo; 
    private Pedido pedido;
    private Entregador entregador;
    private double cm_Taxa;
    private Date hora;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public double getCm_Taxa() {
        return cm_Taxa;
    }

    public void setCm_Taxa(double cm_Taxa) {
        this.cm_Taxa = cm_Taxa;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
