/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.CRel_Cliente;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVRel_Cliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form JVRel_Cliente
     */
    public JVRel_Cliente() {
        initComponents();
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
        CmbtipoRel = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtCampo = new javax.swing.JTextField();
        btmPesquisar = new javax.swing.JButton();
        btmImprimir = new javax.swing.JButton();
        btmLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btmSair = new javax.swing.JButton();

        setTitle("Relatório de Clientes");

        jLabel1.setText("Nome / Cidade / Status:");

        CmbtipoRel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Cidade", "Status" }));
        CmbtipoRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbtipoRelActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição: ");

        btmPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Search File.png"))); // NOI18N
        btmPesquisar.setText("Pesquisar Clientes");
        btmPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmPesquisarActionPerformed(evt);
            }
        });

        btmImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/klpq.png"))); // NOI18N
        btmImprimir.setText("Gerar PDF / Imprimir");
        btmImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmImprimirActionPerformed(evt);
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

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Cliente", "Nome do Cliente", "CPF/CNPJ", "Status", "Telefone", "Valor do Frete"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        btmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        btmSair.setText("Sair");
        btmSair.setToolTipText("Sair");
        btmSair.setName("cmdSalvar"); // NOI18N
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btmSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(CmbtipoRel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btmPesquisar)
                                .addGap(58, 58, 58)
                                .addComponent(btmImprimir)
                                .addGap(47, 47, 47)
                                .addComponent(btmLimpar)))
                        .addGap(0, 290, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbtipoRel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btmSair)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmPesquisarActionPerformed
        //BOTÃO PESQUISA PEDIDOS
        ArrayList<String> Parametros = new ArrayList<String>();
        Parametros.add(String.valueOf(CmbtipoRel.getSelectedIndex()));
        Parametros.add(txtCampo.getText().toUpperCase());//toUpperCase faz a mudança de maiuscula em minuscula
        
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CRel_Cliente CntrlCliente = new CRel_Cliente();
        objTabela = CntrlCliente.PesquisaObjeto(Parametros,objTabela);
        
        //atribuindo tabela ao JTable
        tabela.setModel(objTabela);
    }//GEN-LAST:event_btmPesquisarActionPerformed

    private void btmImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmImprimirActionPerformed
        //BOTÃO GERAR PDF/IMPRIMIR
        Controle.CRel_Cliente.ireport();       
    }//GEN-LAST:event_btmImprimirActionPerformed

    private void btmLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimparActionPerformed
        LimpaCampos();
    }//GEN-LAST:event_btmLimparActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        this.dispose();//fecha a tela
    }//GEN-LAST:event_btmSairActionPerformed

    private void CmbtipoRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbtipoRelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbtipoRelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CmbtipoRel;
    private javax.swing.JButton btmImprimir;
    private javax.swing.JButton btmLimpar;
    private javax.swing.JButton btmPesquisar;
    private javax.swing.JButton btmSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCampo;
    // End of variables declaration//GEN-END:variables

    void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private Vector<String> pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Código do Cliente");
        ColunasTabela.add("Nome do Cliente");
        ColunasTabela.add("CPF/CNPJ");
        ColunasTabela.add("Status");
        ColunasTabela.add("Telefone");
        ColunasTabela.add("Valor do Frete");        
        return ColunasTabela;
    }

    private void LimpaCampos() {
        txtCampo.setText(null);
    }
}
