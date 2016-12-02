/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.casadasmarmitas.dao.ClienteDao;
import br.com.casadasmarmitas.dao.FuncionarioDao;
import br.com.casadasmarmitas.dao.PedidoDao;
import br.com.casadasmarmitas.modelo.Cliente;
import br.com.casadasmarmitas.modelo.Funcionario;
import br.com.casadasmarmitas.modelo.Pedido;
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
        
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.buscarObjeto(1L);
        objeto.setCliente(cliente);
        objeto.setData(new Date());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.buscarObjeto(4L);
        objeto.setFuncionario(funcionario);
        
        objeto.setStatus(Status.Entregue);

        pedidoDao.salvarOuAtualizarObjeto(objeto);
    }
    
    @Test
    public void listar(){
        PedidoDao dao = new PedidoDao();
        List<Pedido> pedidos = dao.listarObjetos();
        System.out.println("-------------------------------------------");
        for (Pedido pedido : pedidos) {
            System.out.println(pedidos.toString());
            System.out.println("-------------------------------------------");
        }
    }
}
