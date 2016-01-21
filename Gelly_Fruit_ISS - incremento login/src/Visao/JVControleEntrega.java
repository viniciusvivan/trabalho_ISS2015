/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.CCliente;
import Controle.CControleEntrega;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVControleEntrega extends javax.swing.JInternalFrame {

    /**
     * Creates new form ControleEntrega
     */
    public JVControleEntrega() {
        initComponents();
        Carrega_Tabela_Pedidos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedidos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        BotaoSair = new javax.swing.JButton();
        BotaoAtualizar = new javax.swing.JButton();
        BotaoConcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Entrega");

        tabelaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Pedido", "Código do Cliente", "Nome do Cliente", "Valor Total", "Forma de Entrega", "Forma de Pagamento"
            }
        ));
        tabelaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPedidos);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Endereço de Entrega");

        jLabel2.setText("Bairro:");

        jLabel3.setText("Cidade:");

        jLabel5.setText("Rua:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("Dados dos Produtos");

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Produto", "Nome do Produto", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ));
        jScrollPane2.setViewportView(tabelaProduto);

        jLabel8.setText("Código do Pedido:");

        jLabel9.setText("Nome do Cliente:");

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRua)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        BotaoSair.setText("Sair");
        BotaoSair.setToolTipText("Sair");
        BotaoSair.setName("cmdSalvar"); // NOI18N
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

        BotaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Reload.png"))); // NOI18N
        BotaoAtualizar.setText("Atualizar");
        BotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarActionPerformed(evt);
            }
        });

        BotaoConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Accept.png"))); // NOI18N
        BotaoConcluir.setText("Concluir");
        BotaoConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConcluirActionPerformed(evt);
            }
        });

        jLabel4.setText("Dados do Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoConcluir)
                .addGap(37, 37, 37)
                .addComponent(BotaoSair)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoAtualizar)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoAtualizar)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSair)
                    .addComponent(BotaoConcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed
        //botão ATUALIZAR
        Carrega_Tabela_Pedidos();
       // JOptionPane.showMessageDialog(null,"Lista Atualizada com Sucesso !","",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
       dispose();
    }//GEN-LAST:event_BotaoSairActionPerformed

    private void tabelaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPedidosMouseClicked
        // clicar do mause
        int linha = tabelaPedidos.getSelectedRow();
        
        if(linha == -1){
            JOptionPane.showMessageDialog(rootPane,"Selecione o Resgisto Desejado !","Erro ao Consultar Cadastro",JOptionPane.INFORMATION_MESSAGE);
        } else{
            txtCod.setText(tabelaPedidos.getValueAt(linha, 0).toString());
            txtNome.setText(tabelaPedidos.getValueAt(linha,2).toString());
            
            //PRECISA DA TABELA
            ConsultaItens();           
                        
            CCliente ccliente = new CCliente();
            ArrayList<String> clie = new ArrayList<String>();
            
            clie = ccliente.BuscaCliente(Integer.parseInt(tabelaPedidos.getValueAt(linha, 1).toString()));
            txtRua.setText(clie.get(0));
            txtBairro.setText(clie.get(1));
            txtCidade.setText(clie.get(2));
            txtTelefone.setText(clie.get(3));                

        }
    }//GEN-LAST:event_tabelaPedidosMouseClicked

    private void BotaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConcluirActionPerformed
        //botão Concluir        
        if (txtCod.getText().equals("") || txtCod.getText() == null){
            JOptionPane.showMessageDialog(null,"Selecione um Pedido !!!","Alerta",JOptionPane.INFORMATION_MESSAGE);
        }else{
            CControleEntrega centrega = new CControleEntrega();
            centrega.Atualiza(Integer.parseInt(txtCod.getText()));
            centrega.Insere_PedidoEntregue(Integer.parseInt(txtCod.getText()));
            JOptionPane.showMessageDialog(null,"Pedido Dado Baixa !","",JOptionPane.INFORMATION_MESSAGE);
            Carrega_Tabela_Pedidos();
            LimpaCampos();
        }
    }//GEN-LAST:event_BotaoConcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoConcluir;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaPedidos;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void Carrega_Tabela_Pedidos() {
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CControleEntrega CntrlDistribuicao = new CControleEntrega();
        objTabela = CntrlDistribuicao.PesquisaObjeto(objTabela);
        
        //atribuindo tabela ao JTable
        tabelaPedidos.setModel(objTabela);
    }

    private Vector<String> pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Código do Pedido");
        ColunasTabela.add("Código do Cliente");
        ColunasTabela.add("Nome do Cliente");
        ColunasTabela.add("Valor Total");
        ColunasTabela.add("Forma de Entrega");
        ColunasTabela.add("Forma de Pagamento");
        
        return ColunasTabela;   
    }

    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }  

    private void ConsultaItens() {
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade2();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CControleEntrega CntrlDistribuicao = new CControleEntrega();
        objTabela = CntrlDistribuicao.PesquisaObjetoProduto(objTabela, Integer.parseInt(txtCod.getText()));
        
        //atribuindo tabela ao JTable
        tabelaProduto.setModel(objTabela);
    }

    private Vector<String> pegaColunasDaGrade2() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Código do Produto");
        ColunasTabela.add("Nome do Produto");
        ColunasTabela.add("Quantidade");
        ColunasTabela.add("Valor Unitário");
        ColunasTabela.add("Valor Total");
        
        return ColunasTabela; 
    }
    
    
    public void LimpaCampos(){//seta tudo para limpar os campos
        txtBairro.setText(null);
        txtCidade.setText(null);
        txtCod.setText(null);
        txtNome.setText(null);
        txtRua.setText(null);
        txtTelefone.setText(null);
        tabelaProduto.clearSelection();
        
    }
}
