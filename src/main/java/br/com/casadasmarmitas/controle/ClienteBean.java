/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadasmarmitas.controle;

import br.com.casadasmarmitas.dao.ClienteDao;
import br.com.casadasmarmitas.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Messages;

/**
 *
 * @author Tardeli
 */
@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private List<Cliente> listaObjetos;
    private ClienteDao clienteDao = new ClienteDao();

    public ClienteBean() {
        listaObjetos = new ArrayList<>();
        getListaObjetos();
    }

    public void novo() {
        this.cliente = new Cliente();
    }

    public String salvar() {
        if (this.cliente.getCodigo() == null) {
            if (clienteDao.pesquisarCpf(this.cliente.getCpf()) == true) {
                Messages.addGlobalError("Cpf já está cadastrado!");
            }else{
                clienteDao.salvarOuAtualizarObjeto(this.cliente);
                getListaObjetos();
                Messages.addGlobalInfo("Salvo com sucesso!");
                this.cliente = new Cliente();
            }
            return "erro";
        } else {
            clienteDao.salvarOuAtualizarObjeto(cliente);
            getListaObjetos();
            Messages.addGlobalInfo("Atualizado com Sucesso!");
            this.cliente = new Cliente();
            return "erro.xhtml";
        }
    }

    public void excluir(Cliente c) {
        this.cliente = c;
        Messages.addGlobalInfo("Excluido com Sucesso!");
        clienteDao.deletarObjeto(cliente);
        getListaObjetos();
        this.cliente = new Cliente();
    }

    public void carregarDadosEditar(Cliente c) {
        this.cliente = c;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaObjetos() {
        return listaObjetos = clienteDao.listarObjetos();
    }

    public void setListaObjetos(List<Cliente> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
}
