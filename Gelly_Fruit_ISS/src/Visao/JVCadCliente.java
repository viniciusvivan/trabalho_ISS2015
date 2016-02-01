/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

//bibliotecas usadas no formulário
import Controle.CCliente;
import Modelo.Clientes;
import Modelo.Valida;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Larissa-PC
 */
public class JVCadCliente extends javax.swing.JInternalFrame {
    BuscaCliente busca = new BuscaCliente(this);
    Clientes cliente = new Clientes();//cria o objeto cliente da classe Clientes
    //cria o objeto ccliente da classe CCliente
    ResultSet rs;//recebe a consulta do banco de dado, podendo ser varias linhas
    Valida valida = new Valida();
    Boolean validar;
    
    public void RetornoConsulta(int codigo){
        txtcodigo.setText(String.valueOf(codigo));
        txtnome.requestFocus();
        PreencheCampos(codigo);       
    }
    
    public JVCadCliente() {
        initComponents(); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lblCodigo1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        cbmStatus = new javax.swing.JComboBox();
        lblStatus1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbRG1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEnd = new javax.swing.JTextField();
        txtComp = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtFrete = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        CboCFPCNPJ = new javax.swing.JComboBox();
        txtCPF = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtCEP = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        btmNovo = new javax.swing.JButton();
        btmExcluir = new javax.swing.JButton();
        btmAlterar = new javax.swing.JButton();
        btmLimpar = new javax.swing.JButton();
        btmSair = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Cliente");

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        lblCodigo1.setText("Código");

        txtcodigo.setEnabled(false);
        txtcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcodigoFocusLost(evt);
            }
        });
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel13.setText("Nome*: ");

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        txtnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnomeKeyPressed(evt);
            }
        });

        cbmStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));

        lblStatus1.setText("Status: ");

        jLabel16.setText("CPF/CNPJ*:");

        lbRG1.setText("RG:");

        jLabel17.setText("Endereço*: ");

        jLabel18.setText("Complemento:");

        txtEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndActionPerformed(evt);
            }
        });

        txtComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompActionPerformed(evt);
            }
        });

        jLabel19.setText("Bairro*:");

        txtMunicipio.setName(""); // NOI18N
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        jLabel20.setText("Município*:");

        jLabel21.setText("País:");

        jLabel22.setText("Estado*:");

        jLabel23.setText("CEP*:");

        jLabel24.setText("Telefone*:");

        jLabel25.setText("Celular:");

        jLabel26.setText("Frete*: ");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel27.setText("E-mail:");

        CboCFPCNPJ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPF", "CNPJ" }));

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        txtRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCodigo1)
                        .addGap(4, 4, 4)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lblStatus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbmStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel18))
                                            .addGap(21, 21, 21)
                                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(370, 370, 370))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbRG1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel17))
                                            .addGap(21, 21, 21)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(262, 262, 262)
                                                    .addComponent(jLabel16))))
                                        .addComponent(jLabel19)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(94, 94, 94)
                                            .addComponent(jLabel21))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addGap(20, 20, 20)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(79, 79, 79)
                                            .addComponent(jLabel26))
                                        .addComponent(jLabel20))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(266, 266, 266)
                                .addComponent(jLabel25)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(CboCFPCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro)
                            .addComponent(txtMunicipio)
                            .addComponent(txtPais))))
                .addGap(19, 34, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblCodigo1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbmStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblStatus1))
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbRG1))
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CboCFPCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        btmNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/V Card.png"))); // NOI18N
        btmNovo.setText("Novo");
        btmNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmNovoActionPerformed(evt);
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

        btmAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/edit.png"))); // NOI18N
        btmAlterar.setText("Alterar");
        btmAlterar.setName("cmdSalvar"); // NOI18N
        btmAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAlterarActionPerformed(evt);
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

        btmSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/Exit.png"))); // NOI18N
        btmSair.setText("Sair");
        btmSair.setToolTipText("Sair");
        btmSair.setName("cmdSalvar"); // NOI18N
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Png 32 x 32/viewmag.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btmNovo)
                .addGap(34, 34, 34)
                .addComponent(btmAlterar)
                .addGap(36, 36, 36)
                .addComponent(btmExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(74, 74, 74)
                .addComponent(btmLimpar)
                .addGap(31, 31, 31)
                .addComponent(btmSair, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmNovo)
                    .addComponent(btmAlterar)
                    .addComponent(btmExcluir)
                    .addComponent(btmLimpar)
                    .addComponent(btmSair)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setBounds(270, 100, 909, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txtnomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VPrincipal.jDesktopPane.add(busca);        
        busca.setVisible(true);   
        busca.setPosicao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void btmNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmNovoActionPerformed
        //BOTÃO NOVO
        ArrayList<String> Registro = new ArrayList<>();
        
        if(validaCampos() == true){
            if (CboCFPCNPJ.getSelectedIndex() == 0){
                validar = valida.validaCPF(txtCPF.getText());
            }
            else
            {
                validar = valida.validaCNPJ(txtCPF.getText());
            }

            if (validar == true){
                // Registro.add(txtcodigo.getText());
                Registro.add(txtnome.getText());
                Registro.add(txtRG.getText());
                Registro.add(txtCPF.getText());
                Registro.add(txtEnd.getText());
                Registro.add(txtBairro.getText());
                Registro.add(txtComp.getText());
                Registro.add(txtMunicipio.getText());
                Registro.add(txtCEP.getText());
                Registro.add(txtPais.getText());
                Registro.add(txtTel.getText());
                Registro.add(txtCel.getText());
                Registro.add(txtEmail.getText());
                Registro.add(txtFrete.getText());
                Registro.add(txtEstado.getText());
                Registro.add(String.valueOf(cbmStatus.getSelectedIndex()));

                CCliente ccliente = new CCliente();
                ccliente.Salvar(Registro);

                JOptionPane.showMessageDialog(null,"Cliente salvo com sucesso !","Salvar",JOptionPane.INFORMATION_MESSAGE);
                LimpaCampos();
            }
            else
            {
                if (CboCFPCNPJ.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"CPF invalido !","Atenção",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"CNPJ invalido !","Atenção",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }

    }//GEN-LAST:event_btmNovoActionPerformed

    private void btmExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExcluirActionPerformed
        //BOTÃO EXCLUIR
        int podeExcluir = JOptionPane.showConfirmDialog(rootPane,"Tem certeza que deseja excluir o cliente?","Meu Programa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if(podeExcluir == 0 ){
            CCliente ccliente = new CCliente();
            ccliente.Excluir(Integer.parseInt(txtcodigo.getText()));

            JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso !","Excluir",JOptionPane.INFORMATION_MESSAGE);
        
            LimpaCampos();
        }       
    }//GEN-LAST:event_btmExcluirActionPerformed

    private void btmAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAlterarActionPerformed
        //BOTÃO ALTERAR

        ArrayList<String> Registro = new ArrayList<>();
        
        if(validaCampos() == true){
            if (CboCFPCNPJ.getSelectedIndex() == 0){
                validar = valida.validaCPF(txtCPF.getText());
            }
            else
            {
                validar = valida.validaCNPJ(txtCPF.getText());
            }

            if (validar == true){
                Registro.add(txtcodigo.getText());
                Registro.add(txtnome.getText());
                Registro.add(txtRG.getText());
                Registro.add(txtCPF.getText());
                Registro.add(txtEnd.getText());
                Registro.add(txtBairro.getText());
                Registro.add(txtComp.getText());
                Registro.add(txtMunicipio.getText());
                Registro.add(txtCEP.getText());
                Registro.add(txtPais.getText());
                Registro.add(txtTel.getText());
                Registro.add(txtCel.getText());
                Registro.add(txtEmail.getText());
                Registro.add(txtFrete.getText());
                Registro.add(txtEstado.getText());
                Registro.add(String.valueOf(cbmStatus.getSelectedIndex()));

                CCliente ccliente = new CCliente();
                ccliente.Alterar(Registro);

                JOptionPane.showMessageDialog(null,"Cliente alterado com sucesso !","Alterar",JOptionPane.INFORMATION_MESSAGE);
                LimpaCampos();
            }
            else
            {
                if (CboCFPCNPJ.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"CPF invalido !","Atenção",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"CNPJ invalido !","Atenção",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btmAlterarActionPerformed

    private void btmLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimparActionPerformed
        LimpaCampos();
    }//GEN-LAST:event_btmLimparActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        this.dispose();//fecha a tela
    }//GEN-LAST:event_btmSairActionPerformed

    private void txtcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcodigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoFocusLost

    private void txtRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRGActionPerformed

    private void txtCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    public void LimpaCampos(){//seta tudo para limpar os campos
        txtcodigo.setText(null);
        txtnome.setText(null);
        txtRG.setText(null);
        txtCPF.setText(null);
        txtEnd.setText(null);
        txtBairro.setText(null);
        txtMunicipio.setText(null);
        txtCEP.setText(null);
        txtPais.setText(null);
        txtComp.setText(null);
        txtTel.setText(null);
        txtCel.setText(null);
        txtEmail.setText(null);
        txtEstado.setText(null);
        txtFrete.setText(null);
    }
    
    public void PreencheCampos(int codigo) {
        ArrayList<Clientes> cli = new ArrayList<Clientes>();   
        cli = CCliente.BuscaCadastro(codigo);
        
        Clientes objClientesBuffer;     
        objClientesBuffer = cli.get(0);
        
        txtcodigo.setText(String.valueOf(objClientesBuffer.getId_Cliente()));
        txtnome.setText(objClientesBuffer.getNome());
        cbmStatus.setSelectedIndex(objClientesBuffer.getStatus());
        txtRG.setText(objClientesBuffer.getRg());
        txtCPF.setText(objClientesBuffer.getCpf());
        txtEnd.setText(objClientesBuffer.getRua());
        txtBairro.setText(objClientesBuffer.getBairro());
        txtComp.setText(objClientesBuffer.getComplemento());
        txtCEP.setText(objClientesBuffer.getCep());
        txtMunicipio.setText(objClientesBuffer.getCidade());
        txtEstado.setText(objClientesBuffer.getEstado());
        txtPais.setText(objClientesBuffer.getPais());
        txtTel.setText(objClientesBuffer.getTelefone());
        txtCel.setText(objClientesBuffer.getCelular());
        txtEmail.setText(objClientesBuffer.getEmail());
        txtFrete.setText(String.valueOf(objClientesBuffer.getFrete()));
        
        if (txtCPF.getText().length() <= 11){
            CboCFPCNPJ.setSelectedIndex(0);
        }
        else
        {
            CboCFPCNPJ.setSelectedIndex(1);
        }
         
    }

        public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }  
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CboCFPCNPJ;
    private javax.swing.JButton btmAlterar;
    private javax.swing.JButton btmExcluir;
    private javax.swing.JButton btmLimpar;
    private javax.swing.JButton btmNovo;
    private javax.swing.JButton btmSair;
    private javax.swing.JComboBox cbmStatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbRG1;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtComp;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JFormattedTextField txtFrete;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

    public boolean validaCampos() {
        boolean ret = true;
        if (txtnome.getText().equals("") || txtnome.getText() == null){
            JOptionPane.showMessageDialog(null,"Campo nome obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtnome.requestFocus();
            ret=false;
        }else if(txtEnd .getText() == null || txtEnd.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo endereço obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtEnd.requestFocus();
            ret=false;
        }
        else if(txtBairro.getText() == null || txtBairro.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo bairro obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtBairro.requestFocus();
            ret=false;
        }else if(txtMunicipio.getText() == null || txtMunicipio.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo município obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtMunicipio.requestFocus();
            ret=false;
        }else if(txtCEP.getText() == null || txtCEP.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo CEP obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtCEP.requestFocus();
            ret=false;
        }else if(txtEstado.getText() == null || txtEstado.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo estado obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtEstado.requestFocus();
            ret=false;
        } else if(txtTel.getText() == null || txtTel.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo telefone obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtTel.requestFocus();
            ret=false;
        }
        else if(txtFrete.getText() == null || txtFrete.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Campo frete obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            txtFrete.requestFocus();
            ret=false;
        }
        return ret;
    }
       
    
    public boolean validaCamposTeste(String nome, String end, String bairro, String municipio, String cep, String estado, String tel, String frete) {
        boolean ret = true;
        if (nome.equals("") || nome == null){
            JOptionPane.showMessageDialog(null,"Campo nome obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            ret=false;
        }else if(end == null || end.equals("")){
            JOptionPane.showMessageDialog(null,"Campo endereço obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtEnd.requestFocus();
            ret=false;
        }
        else if(bairro == null || bairro.equals("")){
            JOptionPane.showMessageDialog(null,"Campo bairro obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtBairro.requestFocus();
            ret=false;
        }else if(municipio == null || municipio.equals("")){
            JOptionPane.showMessageDialog(null,"Campo município obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtMunicipio.requestFocus();
            ret=false;
        }else if(cep == null || cep.equals("")){
            JOptionPane.showMessageDialog(null,"Campo CEP obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtCEP.requestFocus();
            ret=false;
        }else if(estado == null || estado.equals("")){
            JOptionPane.showMessageDialog(null,"Campo estado obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtEstado.requestFocus();
            ret=false;
        } else if(tel == null || tel.equals("")){
            JOptionPane.showMessageDialog(null,"Campo telefone obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtTel.requestFocus();
            ret=false;
        }
        else if(frete == null || frete.equals("")){
            JOptionPane.showMessageDialog(null,"Campo frete obrigatório !","Alerta",JOptionPane.INFORMATION_MESSAGE);
            //txtFrete.requestFocus();
            ret=false;
        }
        return ret;
    }

}
