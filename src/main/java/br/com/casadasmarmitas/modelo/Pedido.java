package br.com.casadasmarmitas.modelo;

import br.com.casadasmarmitas.enumeradores.Status;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tardeli
 */
@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable{
    
    private Long codigo;
    private Cliente cliente;
    private Date data;
    private Funcionario funcionario;
    private Status status;
    private Double total;

    public Pedido() {
       
    }
            
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name = "cliente")
    @NotNull(message = "Selecione um cliente")
    public Cliente getCliente() {
        if(cliente==null){
            return cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Temporal(TemporalType.DATE)
    public Date getData() {
        return data = new Date();
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne
    @JoinColumn(name = "funcionario")
    public Funcionario getFuncionario() {
        if(funcionario==null){
            return funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", data=" + data + ", funcionario=" + funcionario + ", status=" + status + ", total=" + total + '}';
    }   
         
}
