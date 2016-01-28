/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Banco.Conexao;
import Controle.CRel_PedEndDistr;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVRel_PedEndDistr extends javax.swing.JInternalFrame {

    /**
     * Creates new form JVRel_PedEndDistr
     */
    public JVRel_PedEndDistr() {
        initComponents();
        Carrega_Combo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxDistr = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setTitle("Relatório de Pedidos Entregues por Distribuição");

        jLabel1.setText("Forma de Distribuição: ");

        cbxDistr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDistrActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/klpq.png"))); // NOI18N
        jButton2.setText("Gerar PDF / Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Search File.png"))); // NOI18N
        jButton1.setText("Pesquisar Pedidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Pedido", "Nome do Cliente", "Cidade", "Valor Total"
            }
        ));
        jScrollPane2.setViewportView(tabela);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        jButton6.setText("Sair");
        jButton6.setToolTipText("Sair");
        jButton6.setName("cmdSalvar"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbxDistr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jButton2)))
                    .addContainerGap(365, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbxDistr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(412, 412, 412)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //BOTÃO IMPRIMIR
        JOptionPane.showMessageDialog(null,"ERRO ao Conectar com a Impressora!","ERRO",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //BOTÃO PESQUISA PEDIDOS
        ArrayList<String> Parametros = new ArrayList<String>();
        Parametros.add(String.valueOf(cbxDistr.getSelectedIndex()));
        //Parametros.add(txtCampo.getText().toUpperCase());//toUpperCase faz a mudança de maiuscula em minuscula
        
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CRel_PedEndDistr CntrlCliente = new CRel_PedEndDistr();
        objTabela = CntrlCliente.PesquisaObjeto(Parametros,objTabela);
        
        //atribuindo tabela ao JTable
        tabela.setModel(objTabela);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();//fecha a tela
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbxDistrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDistrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDistrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxDistr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private Vector<String> pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("N°. da Venda");
        ColunasTabela.add("Nome do Cliente");
        ColunasTabela.add("Cidade");
        ColunasTabela.add("Valor Total");        
        return ColunasTabela;
    }
    
    public void Carrega_Combo() {
        Conexao conecta = new Conexao();
        conecta.conexao();  
        //Distribuicoes distribuicao = new Distribuicoes();
        conecta.executaSQL("select NOME_DISTRIBUICAO from DISTRIBUICAO");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                cbxDistr.addItem(conecta.rs.getString("NOME_DISTRIBUICAO"));
                //distribuicao.setId_Produto(Integer.parseInt(conecta.rs.getString("cod_Produto")));                
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(JVRel_PedEndDistr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
}
