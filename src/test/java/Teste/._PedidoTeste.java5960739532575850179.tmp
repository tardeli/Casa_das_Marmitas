/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.casadasmarmitas.dao.ClienteDao;
import br.com.casadasmarmitas.dao.FuncionarioDao;
import br.com.casadasmarmitas.dao.PedidoDao;
import br.com.casadasmarmitas.dao.ProdutoDao;
import br.com.casadasmarmitas.modelo.Cliente;
import br.com.casadasmarmitas.modelo.Funcionario;
import br.com.casadasmarmitas.modelo.Pedido;
import br.com.casadasmarmitas.modelo.Produto;
import br.com.casadasmarmitas.modelo.Status;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Tardeli
 */
public class PedidoTeste {

    @Test
    @Ignore
    public void cadastrar() {
        Pedido objeto = new Pedido();
        PedidoDao pedidoDao = new PedidoDao();
        
        //objeto.setCodigo(1l); //atualizar o campo 1
        
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.buscarObjeto(1L);
        
        objeto.setCliente(cliente);
        objeto.setData(new Date());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.buscarObjeto(6L);
        
        objeto.setFuncionario(funcionario);
        
        objeto.setStatus(Status.Cancelado);
        
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.buscarObjeto(1L);
        
        objeto.getProdutos().add(produto);
        
        //produto = produtoDao.buscarObjeto(2L);
        //objeto.getProdutos().add(produto);
        
        //produto = produtoDao.buscarObjeto(3L);
        //objeto.getProdutos().add(produto);
        
        produto = produtoDao.buscarObjeto(4L);
        objeto.getProdutos().add(produto);
        

        pedidoDao.salvarOuAtualizarObjeto(objeto);
    }
    
    @Test
    @Ignore
    public void buscarEntregadores(){
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.buscarObjeto(1L);
        System.out.println("-------------------------------------------");
        System.out.println(produto.toString());
        System.out.println("-------------------------------------------");     
    }
    
    @Test
    public void listar(){
        PedidoDao dao = new PedidoDao();
        List<Pedido> pedidos = dao.listarObjetos();
        System.out.println("-------------------------------------------");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
            System.out.println("-------------------------------------------");
        }
    }
    
}
