/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.CRel_ReajusteFrete;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVRel_ReajusteFrete extends javax.swing.JInternalFrame {

    public JVRel_ReajusteFrete() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbmOK = new javax.swing.JButton();
        btmLimpar = new javax.swing.JButton();
        btmImprimir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaRelAjust = new javax.swing.JTable();
        btmSair = new javax.swing.JButton();
        txtDataIni = new javax.swing.JFormattedTextField();
        txtDataFim = new javax.swing.JFormattedTextField();

        setTitle("Relatório de Reauste de Frete");

        jLabel1.setText("Data Inicial:");

        jLabel2.setText("Data Final:");

        tbmOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/button_ok.png"))); // NOI18N
        tbmOK.setText("Pesquisar Reajuste");
        tbmOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbmOKActionPerformed(evt);
            }
        });

        btmLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Delete.png"))); // NOI18N
        btmLimpar.setText("Limpar");
        btmLimpar.setToolTipText("Limpar Campos");
        btmLimpar.setName("cmdSalvar"); // NOI18N
        btmLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimparActionPerformed(evt);
            }
        });

        btmImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/klpq.png"))); // NOI18N
        btmImprimir.setText("Gerar PDF / Imprimir");
        btmImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmImprimirActionPerformed(evt);
            }
        });

        tabelaRelAjust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Percentual"
            }
        ));
        jScrollPane2.setViewportView(tabelaRelAjust);

        btmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        btmSair.setText("Sair");
        btmSair.setToolTipText("Sair");
        btmSair.setName("cmdSalvar"); // NOI18N
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });

        try {
            txtDataIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataIniActionPerformed(evt);
            }
        });

        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btmSair))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btmImprimir)
                                .addGap(59, 59, 59)
                                .addComponent(btmLimpar)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(tbmOK)
                    .addContainerGap(386, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmImprimir)
                    .addComponent(btmLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btmSair)
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(tbmOK)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimparActionPerformed
        //botão Limpa_campos()
        LimpaCampos();
    }//GEN-LAST:event_btmLimparActionPerformed

    private void btmImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmImprimirActionPerformed
        //BOTÃO IMPRIMIR
        Controle.CReajusteFrete.ireport();   
    }//GEN-LAST:event_btmImprimirActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        this.dispose();//fecha a tela
    }//GEN-LAST:event_btmSairActionPerformed

    private void tbmOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbmOKActionPerformed
        //Botão PESQUISA REAJUSTE
        ArrayList<String> Parametros = new ArrayList<String>();
        Parametros.add(txtDataIni.getText());
        Parametros.add(txtDataFim.getText()); 
        
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CRel_ReajusteFrete CntrlPedido = new CRel_ReajusteFrete();
        objTabela = CntrlPedido.PesquisaObjeto(Parametros,objTabela);
        
        //atribuindo tabela ao JTable
        tabelaRelAjust.setModel(objTabela);
    }//GEN-LAST:event_tbmOKActionPerformed

    private void txtDataIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataIniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmImprimir;
    private javax.swing.JButton btmLimpar;
    private javax.swing.JButton btmSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaRelAjust;
    private javax.swing.JButton tbmOK;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataIni;
    // End of variables declaration//GEN-END:variables

    void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private Vector<String> pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Data");
        ColunasTabela.add("Percentual");    
        return ColunasTabela;
    }

    private void LimpaCampos() {
        txtDataFim.setText(null);
        txtDataIni.setText(null);
    }   
}
