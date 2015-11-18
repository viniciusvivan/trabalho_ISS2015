/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.CEstornoPedido;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVEstornoPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form EstornoPedido
     */
    public JVEstornoPedido() {
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

        txtCampo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEstorno = new javax.swing.JTable();
        BotaoConcluir1 = new javax.swing.JButton();
        btmBuscar = new javax.swing.JButton();
        BotaoSair1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxBusca = new javax.swing.JComboBox();
        txtCodigo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Estorno de Pedidos Entregues");

        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });
        txtCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCampoKeyPressed(evt);
            }
        });

        tabelaEstorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Pedido", "Data do Fechamento", "Nome do Cliente", "Valor Total", "Forma de Entrega"
            }
        ));
        tabelaEstorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEstornoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEstorno);

        BotaoConcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Accept.png"))); // NOI18N
        BotaoConcluir1.setText("Concluir");
        BotaoConcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConcluir1ActionPerformed(evt);
            }
        });

        btmBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/viewmag.png"))); // NOI18N
        btmBuscar.setText("Buscar");
        btmBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmBuscarActionPerformed(evt);
            }
        });

        BotaoSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        BotaoSair1.setText("Sair");
        BotaoSair1.setToolTipText("Sair");
        BotaoSair1.setName("cmdSalvar"); // NOI18N
        BotaoSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSair1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Dados do Pedido:");

        cbxBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Códido do Pedido", "Código do Cliente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotaoConcluir1)
                                .addGap(34, 34, 34)
                                .addComponent(BotaoSair1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btmBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmBuscar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSair1)
                    .addComponent(BotaoConcluir1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoActionPerformed

    private void btmBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmBuscarActionPerformed
        // botão BUSCAR (lupa)
        
        if(txtCampo.getText() == null || txtCampo.getText().trim().equals("") ){
            JOptionPane.showMessageDialog(null,"Informe um Valor para a Busca!","",JOptionPane.INFORMATION_MESSAGE);           
        }else{
                ArrayList<String> Parametros = new ArrayList<String>();
                Parametros.add(String.valueOf(cbxBusca.getSelectedIndex()));
                Parametros.add(txtCampo.getText().toUpperCase());//toUpperCase faz a mudança de maiuscula em minuscula

                //criando a estrutura da tabela
                Vector<String> vColunas = new Vector<String>();
                vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela

                //modelo da tabela
                DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são

                //criando o controller da aplicação para efetuar a chamada da consulta
                CEstornoPedido CntrlPedido = new CEstornoPedido();
                objTabela = CntrlPedido.PesquisaObjeto(Parametros,objTabela);
                //atribuindo tabela ao JTable
                tabelaEstorno.setModel(objTabela);
            }
                
    }//GEN-LAST:event_btmBuscarActionPerformed

    private void BotaoSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSair1ActionPerformed
        //botão SAIR
        dispose();
    }//GEN-LAST:event_BotaoSair1ActionPerformed

    private void BotaoConcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConcluir1ActionPerformed
        //botão CONCLUIR
        int podeExcluir = JOptionPane.showConfirmDialog(rootPane,"Tem certeza que deseja estornar este pedido?","Meu Programa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if(podeExcluir == 0 ){
            CEstornoPedido centrega = new CEstornoPedido();
            centrega.Concluir(Integer.parseInt(txtCodigo.getText()));

            JOptionPane.showMessageDialog(null,"Pedido Estornado com Sucesso !","",JOptionPane.INFORMATION_MESSAGE);
            LimpaCampos();
        }
        
        
        
         
    }//GEN-LAST:event_BotaoConcluir1ActionPerformed

    private void tabelaEstornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstornoMouseClicked
        //AO CLICAR O MOUSE
        int linha = tabelaEstorno.getSelectedRow();
        
        if(linha == -1){
            JOptionPane.showMessageDialog(rootPane,"Selecione o Resgisto Desejado !","Erro ao Consultar Cadastro",JOptionPane.INFORMATION_MESSAGE);
        } else{
            txtCodigo.setText(tabelaEstorno.getValueAt(linha, 0).toString()); 
        }
        
    }//GEN-LAST:event_tabelaEstornoMouseClicked

    private void txtCampoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoKeyPressed
        //TRATAMENTO PARA INFORMAR APENAS NUMEROS
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            JOptionPane.showMessageDialog(null,"Este campo só aceita números!","Atenção",JOptionPane.INFORMATION_MESSAGE);
            LimpaCampos();
        }
    }//GEN-LAST:event_txtCampoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoConcluir1;
    private javax.swing.JButton BotaoSair1;
    private javax.swing.JButton btmBuscar;
    private javax.swing.JComboBox cbxBusca;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEstorno;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }  

    private Vector<String> pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Código do Pedido");
        ColunasTabela.add("Data do Fechamento");
        ColunasTabela.add("Nome do Cliente");
        ColunasTabela.add("Valor Total");
        ColunasTabela.add("Forma de Entrega");       
        return ColunasTabela;
    }
public void LimpaCampos(){//seta tudo para limpar os campos
        txtCampo.setText(null);
        txtCodigo.setText(null);        
    }

}
