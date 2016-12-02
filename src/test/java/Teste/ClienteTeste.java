/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.casadasmarmitas.dao.ClienteDao;
import br.com.casadasmarmitas.modelo.Cliente;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Tardeli
 */
public class ClienteTeste {
    @Test
    public void listar() {
        ClienteDao cliente = new ClienteDao();
        List<Cliente> objetos = cliente.listarObjetos();
        System.out.println("-------------------------------------");
        for (Cliente objeto : objetos) {
            System.out.println(objeto.toString());
            System.out.println("-------------------------------------");
        }
        
    }
    
    @Test
    public void pesquisarCpf() {
        ClienteDao c = new ClienteDao();
        Boolean b = c.pesquisarCpf("111.111.111-12");
        if(b==null){
            System.out.println("Cpf não escontrado");
        }else{
            System.out.println("Cpf já está cadastrado");
        }
    }
    
    @Test
    @Ignore
    public void cadastrar(){
        Cliente objeto = new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        objeto.setNome("Tardeli da Rocha");
        objeto.setCpf("046.323.323-43");
        objeto.setEmail("tardeli@gmail.com");
        objeto.setTelefone("49-1233-1212");
        objeto.setLogradouro("Rua a");
        objeto.setBairro("Vila Real");
        objeto.setPontoReferencia("123e");
        clienteDao.salvarOuAtualizarObjeto(objeto);    
   }
}
