package br.com.casadasmarmitas.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tardeli
 */
@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codigo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    @Temporal(TemporalType.DATE)
    private Date data;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Funcionario funcionario;
    private Status status;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
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
    
    @Override
    public String toString(){
        String texto = "";
        texto+= "CodigoPedido: "+this.getCodigo()+"\n";
        texto+= "CodigoCliente: "+this.getCliente().getCodigo()+"\n";
        texto+= "NomeCliente: "+this.getCliente().getNome()+"\n";
        texto+= "Data: "+this.getData()+"\n";
        texto+= "CodigoFuncionario: "+this.getFuncionario().getCodigo()+"\n";
        texto+= "NomeFuncionario: "+this.getFuncionario().getNome()+"\n";
        texto+= "Status: "+this.getStatus();
        return texto;
    } 
    
         
}
