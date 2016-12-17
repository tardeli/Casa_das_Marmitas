/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadasmarmitas.dao;

import br.com.casadasmarmitas.modelo.Pedido;
import br.com.casadasmarmitas.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tardeli
 */
public class PedidoDao extends Generic_Dao<Pedido>{
    private Session sessao;
    private Transaction transacao;
    
    public Long salvar(Pedido pedido){
        Long codigo = null;
        try {
            sessao = (Session) HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            codigo = (Long) sessao.save(pedido);
            transacao.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return 1L;
    }
}
