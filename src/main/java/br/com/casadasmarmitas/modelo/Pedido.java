package br.com.casadasmarmitas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    private Long codigo;
    private Cliente cliente;
    private Date data;
    private Funcionario funcionario;
    private Status status;
    private List<Produto> produtos = new ArrayList<>();
        
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name = "cliente",  nullable = true)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Temporal(TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne
    @JoinColumn(name = "funcionario")
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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "itens_pedido")
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
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
        texto+= "Status: "+this.getStatus()+"\n";
        for (Produto produto : this.getProdutos()) {
            texto+= " Codigo: "+produto.getCodigo().toString();
            texto+= " Nome: "+produto.getNome();
            texto+= " Descrição: "+produto.getDescricao();
            texto+= " Tamanho: "+produto.getTamanho();
            texto+= " Preço: "+produto.getPreco()+" | ";
        }
        return texto;
    } 
    
         
}
