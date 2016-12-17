/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadasmarmitas.controle;

import br.com.casadasmarmitas.dao.ClienteDao;
import br.com.casadasmarmitas.dao.ProdutoDao;
import br.com.casadasmarmitas.modelo.Cliente;
import br.com.casadasmarmitas.modelo.ItemPedido;
import br.com.casadasmarmitas.modelo.Pedido;
import br.com.casadasmarmitas.modelo.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tardeli
 */
@ManagedBean
@SessionScoped
public class PedidoBean implements Serializable {

    private List<Produto> listaProdutos;
    private ProdutoDao produtoDao = new ProdutoDao();

    private Pedido pedido;
    private List<ItemPedido> listaItens;
    
    private List<Cliente> listaCliente;
    private ClienteDao clienteDao = new ClienteDao();
    private Boolean listaItensVazia;

    public PedidoBean() {
        this.getListaProdutos();
    }
   
    public void limpar(){
        this.listaItens = new ArrayList<>();
    }
    
    public void adicionar(Produto produto) {
        ItemPedido itemPedido = new ItemPedido();
        int produtoAtual = -1;
        for (int posicao = 0; posicao<listaItens.size()&&produtoAtual<0; posicao++) {
            ItemPedido item = listaItens.get(posicao);
            if(item.getProduto().equals(produto)){
                produtoAtual = posicao;
            } 
        }
        itemPedido.setProduto(produto);
        
        if(produtoAtual<0){
            itemPedido.setQuantidade(1);
            itemPedido.getProduto().getPreco();
            itemPedido.setTotal(itemPedido.getProduto().getPreco());
            listaItens.add(itemPedido);
            
        }else{
            ItemPedido item = listaItens.get(produtoAtual);
            itemPedido.setQuantidade(item.getQuantidade()+1);
            itemPedido.setTotal(item.getProduto().getPreco()*itemPedido.getQuantidade());
            listaItens.set(produtoAtual, itemPedido);
        }
        calcular();
       
    }
    
    public void calcular(){
        double valor =0.0;
        for (ItemPedido listaItens : listaItens) {
            valor+= listaItens.getTotal();
        }
        pedido.setTotal(valor);
    
    }

    public void excluir(ItemPedido itemPedido) {
        listaItens.remove(itemPedido);
        calcular();
        if(listaItens.isEmpty()){
            listaItensVazia=false;
        }
    }
       
    public List<Produto> getListaProdutos() {
        return listaProdutos = produtoDao.listarObjetos();
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<ItemPedido> getListaItens() {
        if (listaItens == null) {
            this.listaItens = new ArrayList<>();
        }
        return listaItens;
    }

    public void setListaItens(List<ItemPedido> listaItens) {
        this.listaItens = listaItens;
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public Pedido getPedido() {
        if(pedido == null){
            this.pedido = new Pedido();
        }
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente = clienteDao.listarObjetos();
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Boolean getListaItensVazia() {
        if(listaItensVazia==null){
            return listaItensVazia=false;
        }
        return listaItensVazia = true;
    }

    public void setListaItensVazia(Boolean listaItensVazia) {
        this.listaItensVazia = listaItensVazia;
    }

    

}
