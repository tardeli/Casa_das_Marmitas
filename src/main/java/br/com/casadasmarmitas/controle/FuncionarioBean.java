/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadasmarmitas.controle;

import br.com.casadasmarmitas.dao.FuncionarioDao;
import br.com.casadasmarmitas.modelo.Funcionario;
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
public class FuncionarioBean implements Serializable{
    private Funcionario funcionario = new Funcionario();
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private List<Funcionario> listaObjetos = new ArrayList<>();;
    
    public FuncionarioBean(){
        this.getListaObjetos();
    }
    
    public void novo(){
        this.funcionario = new Funcionario();
    }
    
    public void validarLogin(){
        boolean situacao = funcionarioDao.autenticarLogin(funcionario.getUsuario(), funcionario.getSenha());
        if(situacao){
            Messages.addGlobalInfo("Login efetuado com sucesso");
        }else{
            Messages.addGlobalInfo("Tente novamente!");
        }
        
    }
           
    public String salvar(){
        if(this.funcionario.getCodigo()==null){
            funcionarioDao.salvarOuAtualizarObjeto(this.funcionario);  
            getListaObjetos();
            Messages.addGlobalInfo("Salvo com sucesso!");
            this.funcionario = new Funcionario();
            return "erro";
        }else{
            funcionarioDao.salvarOuAtualizarObjeto(this.funcionario); 
            getListaObjetos();
            Messages.addGlobalInfo("Atualizado com Sucesso!");
            this.funcionario = new Funcionario();
            return "erro.xhtml";
        }
    }
    
    public void excluir(Funcionario c){
        this.funcionario = c;
        Messages.addGlobalInfo("Excluido com Sucesso!");
        funcionarioDao.deletarObjeto(funcionario);  
        getListaObjetos();
        this.funcionario = new Funcionario();
    }
    
    public void carregarDadosEditar(Funcionario c){
        this.funcionario = c;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getListaObjetos() {
        return listaObjetos = funcionarioDao.listarObjetos();
    }

    public void setListaObjetos(List<Funcionario> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    
}
