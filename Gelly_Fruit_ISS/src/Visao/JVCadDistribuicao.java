/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import Controle.CDistribuicao;
import Modelo.Distribuicoes;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class JVCadDistribuicao extends javax.swing.JInternalFrame {
    private int RetornoConsulta;

    public JVCadDistribuicao() {
        initComponents();
        Carrega_Tabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btmNovo = new javax.swing.JButton();
        tbmAlterar = new javax.swing.JButton();
        btmExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDis = new javax.swing.JTable();
        cbmStatus = new javax.swing.JComboBox();
        lblStatus1 = new javax.swing.JLabel();
        btmLimpar = new javax.swing.JButton();
        btmSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Distribuição");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        txtcodigo.setEnabled(false);
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel5.setText("Código: ");

        jLabel6.setText("Nome: ");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btmNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/V Card.png"))); // NOI18N
        btmNovo.setText("Novo");
        btmNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNovoActionPerformed(evt);
            }
        });

        tbmAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/edit.png"))); // NOI18N
        tbmAlterar.setText("Alterar");
        tbmAlterar.setName("cmdSalvar"); // NOI18N
        tbmAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbmAlterarActionPerformed(evt);
            }
        });

        btmExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Recycle Bin.png"))); // NOI18N
        btmExcluir.setText("Excluir");
        btmExcluir.setName("cmdSalvar"); // NOI18N
        btmExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmExcluirActionPerformed(evt);
            }
        });

        TabelaDis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Status"
            }
        ));
        TabelaDis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDis);
        if (TabelaDis.getColumnModel().getColumnCount() > 0) {
            TabelaDis.getColumnModel().getColumn(0).setMinWidth(50);
            TabelaDis.getColumnModel().getColumn(0).setPreferredWidth(50);
            TabelaDis.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        cbmStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        cbmStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmStatusActionPerformed(evt);
            }
        });

        lblStatus1.setText("Status: ");

        btmLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Delete.png"))); // NOI18N
        btmLimpar.setText("Limpar");
        btmLimpar.setToolTipText("Limpar Campos");
        btmLimpar.setName("cmdSalvar"); // NOI18N
        btmLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btmNovo)
                        .addGap(43, 43, 43)
                        .addComponent(tbmAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btmExcluir)
                        .addGap(44, 44, 44)
                        .addComponent(btmLimpar)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lblStatus1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbmStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus1)
                    .addComponent(cbmStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbmAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 290));

        btmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        btmSair.setText("Sair");
        btmSair.setToolTipText("Sair");
        btmSair.setName("cmdSalvar"); // NOI18N
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });
        getContentPane().add(btmSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 98, 44));

        setBounds(400, 100, 636, 381);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btmNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNovoActionPerformed
        //botão NOVO
        if (txtnome.getText() == null || txtnome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Informe o Nome da Distribuição !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtnome.requestFocus();
        }
        else
        {
            ArrayList<String> Registro = new ArrayList<String>();

            Registro.add(txtnome.getText());
            Registro.add(String.valueOf(cbmStatus.getSelectedIndex()));
            
            CDistribuicao cdistribuicao = new CDistribuicao();
            cdistribuicao.Novo(Registro);

            JOptionPane.showMessageDialog(null,"Distribuição salva com sucesso !","Salvar",JOptionPane.INFORMATION_MESSAGE);
            LimpaCampos();
            Carrega_Tabela();
        }
    }//GEN-LAST:event_btmNovoActionPerformed

    private void tbmAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbmAlterarActionPerformed
        //BOTÃO ALTERAR         
        if (txtnome.getText() == null || txtnome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Selecione um Tipo de Distribuição !","Alerta",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            ArrayList<String> Registro = new ArrayList<String>();

            Registro.add(txtcodigo.getText());
            Registro.add(txtnome.getText());
            Registro.add(String.valueOf(cbmStatus.getSelectedIndex()));


            CDistribuicao cdistribuicao = new CDistribuicao();
            cdistribuicao.Alterar(Registro);

            JOptionPane.showMessageDialog(null,"Distribuição alterada com sucesso !","Alterar",JOptionPane.INFORMATION_MESSAGE);
            Carrega_Tabela();
            LimpaCampos();        
        }
    }//GEN-LAST:event_tbmAlterarActionPerformed

    private void btmExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExcluirActionPerformed
        //BOTÃO EXCLUIR
        if (txtnome.getText() == null || txtnome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Selecione um Tipo de Distribuição !","Alerta",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {        
            int podeExcluir = JOptionPane.showConfirmDialog(rootPane,"Tem certeza que deseja excluir a distribuição?","Meu Programa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

            if(podeExcluir == 0 ){
                CDistribuicao cdistribuicao = new CDistribuicao();
                cdistribuicao.Excluir(Integer.parseInt(txtcodigo.getText()));

                JOptionPane.showMessageDialog(null,"Distribuição excluida com sucesso !","Excluir",JOptionPane.INFORMATION_MESSAGE);
            }
            Carrega_Tabela();
            LimpaCampos(); 
        }
    }//GEN-LAST:event_btmExcluirActionPerformed

    private void btmLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimparActionPerformed
        //botão LIMPAR
        LimpaCampos();
    }//GEN-LAST:event_btmLimparActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        //botão SAIR
        this.dispose();//fecha a tela
    }//GEN-LAST:event_btmSairActionPerformed

    private void TabelaDisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDisMouseClicked
         //CLICAR DO MOUSE
        int linha = TabelaDis.getSelectedRow();        
        if(linha == -1){
            JOptionPane.showMessageDialog(rootPane,"Selecione o Resgisto Desejado !","Erro ao Consultar Cadastro",JOptionPane.INFORMATION_MESSAGE);
        } else{
            txtcodigo.setText(TabelaDis.getValueAt(linha, 0).toString());
            txtnome.setText(TabelaDis.getValueAt(linha,1).toString());               
            cbmStatus.setSelectedIndex(Integer.parseInt(TabelaDis.getValueAt(linha,2).toString()));
            
            if (TabelaDis.getValueAt(linha,2).toString().equals("Ativo")){
                cbmStatus.setSelectedIndex(0);
            }
            else{
                cbmStatus.setSelectedIndex(1);
           }
        }
    }//GEN-LAST:event_TabelaDisMouseClicked

    private void cbmStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmStatusActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaDis;
    private javax.swing.JButton btmExcluir;
    private javax.swing.JButton btmLimpar;
    private javax.swing.JButton btmNovo;
    private javax.swing.JButton btmSair;
    private javax.swing.JComboBox cbmStatus;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JButton tbmAlterar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables
   
    public void LimpaCampos(){//seta tudo para limpar os campos
        txtcodigo.setText(null);
        txtnome.setText(null);        
    }
   
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }  
        
    private Vector pegaColunasDaGrade() {
        //Adicionar colunas na tabela
        Vector<String> ColunasTabela = new Vector<String>();
        ColunasTabela.add("Código");
        ColunasTabela.add("Nome");
        ColunasTabela.add("Status");
        
        return ColunasTabela;
    }

    private void Carrega_Tabela() {
        //criando a estrutura da tabela
        Vector<String> vColunas = new Vector<String>();
        vColunas = pegaColunasDaGrade();//função que reotrnar quais são as colunas da tabela
        
        //modelo da tabela
        DefaultTableModel objTabela = new DefaultTableModel(vColunas,0);//passando quais sãoa as colunas e qntas linhas são
        
        //criando o controller da aplicação para efetuar a chamada da consulta
        CDistribuicao CntrlDistribuicao = new CDistribuicao();
        objTabela = CntrlDistribuicao.PesquisaObjeto(objTabela);
        
        //atribuindo tabela ao JTable
        TabelaDis.setModel(objTabela);    
    }

    private void setRetornoConsulta(int iRetornoConsulta) {
        this.RetornoConsulta = iRetornoConsulta;
        this.txtcodigo.setText(String.valueOf(iRetornoConsulta));
        this.txtnome.requestFocus();   
        
        PreencheCampos(iRetornoConsulta);
        tfCodigoFocusLost(null);    
    }

    private void PreencheCampos(int codigo) {
        //FAZ UM SELECT PARA RETORNAR OS VALORES AOS CAMPOS
        ArrayList<Distribuicoes> dis = new ArrayList<Distribuicoes>();   
        dis = CDistribuicao.BuscaCadastro(codigo);
        
        Distribuicoes objDistribuicaoBuffer;      
        objDistribuicaoBuffer = dis.get(0);
        
        txtnome.setText(objDistribuicaoBuffer.getNome());  
        cbmStatus.setSelectedIndex(objDistribuicaoBuffer.getStatus());
    }

    private void tfCodigoFocusLost(Object object) {
        int CodAtual = 0;
        try{
            CodAtual = Integer.parseInt(txtcodigo.getText());
        } catch(Exception e){
                CodAtual = 0;
          }
        
        if(CodAtual > 0 ){
            PreencherTelaComObjRecuperado(CodAtual);
        }    
    }

    private void PreencherTelaComObjRecuperado(int CodAtual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
