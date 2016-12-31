/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadasmarmitas.controle;

import br.com.casadasmarmitas.util.HibernateUtil;
import java.sql.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;
import org.omnifaces.util.Messages;

/**
 *
 * @author Tardeli
 */
public class Teste {

    public void imprimir() {

        String src = "C:/Users/Tardeli/OneDrive/ProjetoWeb_Inicio/CasadasMarmitasMavem/src/main/webapp/relatorio/cliente.jasper";

        Connection conexao = HibernateUtil.getConnection();

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(src, null, conexao);
            JasperViewer viewer = new JasperViewer(jasperPrint, true);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
