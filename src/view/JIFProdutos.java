/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Entidades;
import models.Produtos;

/**
 *
 * @author wynvern
 */
public class JIFProdutos extends javax.swing.JInternalFrame {
    
    private void atualizarTabela() {
        DataSource dataSource = new DataSource();
        PreparedStatement ps = null;
        try{
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = table.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            
            String SQL = "SELECT * FROM produtos";
            
            try {
                // para mandar como uma instrução, precisa usar o PreparedStatement
                // traduz o comando SQL para execução
                ps = dataSource.getConnection().prepareStatement(SQL);
            } catch (SQLException ex) {
                Logger.getLogger(JIFProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }

            // executa a consulta no banco
            ResultSet rs = null;
            try {
                rs = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(JIFProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // cria a lista de resultados trazidos da tabela
            ArrayList<Entidades> lista = new ArrayList<Entidades>();
            
            // enquanto tiverem registros no ResultSet (rs), 
            // vai adicionando na lista
            while(rs.next()){
                // cria objeto de municipio
                // cada cidade é um objeto
                Entidades user = new Entidades();
               
                // adiciona o objeto (registro) na lista (arraylist)
                lista.add(user);

                model.addRow(new Object[]{rs.getInt("id"), rs.getString("descricao"), rs.getString("valor"), rs.getString("unidade"), rs.getString("estoque"), rs.getString("estoqueMinimo")});
            }
            
            try {
                // fecha o statement e o datasource
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            dataSource.closeDataSource();
    }   catch (SQLException ex) {
            Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setItems() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            if (row < 0) return;
            codigo.setText(String.valueOf(model.getValueAt(row, 0)));
            descricao.setText(String.valueOf(model.getValueAt(row, 1)));
            valor.setText(String.valueOf(model.getValueAt(row, 2)));
            unidade.setSelectedItem(String.valueOf(model.getValueAt(row, 3)));
            estoque.setText(String.valueOf(model.getValueAt(row, 4)));
            estoqueMinimo.setText(String.valueOf(model.getValueAt(row, 5)));
    }
    
    
    /**
     * Creates new form JIFProdutos
     */
    public JIFProdutos() {
        initComponents();
        atualizarTabela();
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            setItems();
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        estoque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estoqueMinimo = new javax.swing.JTextField();
        unidade = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        descricaoPesquisa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        codigoPesquisa = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Produtos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/produto.png"))); // NOI18N

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sair.png"))); // NOI18N
        jToggleButton1.setText("Sair");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cubo.png"))); // NOI18N
        jLabel1.setText("Código:");

        codigo.setEnabled(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nota.png"))); // NOI18N
        jLabel2.setText("Descrição:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/peso.png"))); // NOI18N
        jLabel3.setText("Unidade:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Estoque.png"))); // NOI18N
        jLabel4.setText("Estoque:");

        estoque.setEditable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dinheiro.png"))); // NOI18N
        jLabel5.setText("Valor:");

        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Estoque.png"))); // NOI18N
        jLabel6.setText("Estoque Mín:");

        unidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Peso Kg", "Peso g", "Litros", "Metros" }));
        unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadeActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descricao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidade, 0, 234, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valor, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estoqueMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estoque, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(estoque)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(estoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(valor))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adicionar.png"))); // NOI18N
        jToggleButton2.setText("Adicionar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletar.png"))); // NOI18N
        jToggleButton3.setText("Deletar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar.png"))); // NOI18N
        jToggleButton4.setText("Salvar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fechar.png"))); // NOI18N
        jToggleButton5.setText("Limpar");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recarregar.png"))); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4)
                    .addComponent(jToggleButton5)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor", "Unidade", "Estoque", "Estoque Mín."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Nota.png"))); // NOI18N
        jLabel7.setText("Descrição:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cubo.png"))); // NOI18N
        jLabel8.setText("Código:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naoPesquisa.png"))); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codigoPesquisa)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descricaoPesquisa)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
        JFSistema.produtosOpened = false;
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        codigo.setText("");
        descricao.setText("");
        valor.setText("");
        estoque.setText("");
        estoqueMinimo.setText("");
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        DataSource dataSource = new DataSource();
        Produtos produto = new Produtos();
        
        try {
            Float.parseFloat(valor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor digitado incorreto, digite somente números no campo valor.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            Integer.parseInt(estoqueMinimo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor digitado incorreto, digite somente números no campo Estoque mínimo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (descricao.getText().equals("") || valor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Um ou mais campos estão vazios.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        produto.setDescricao(descricao.getText());
        produto.setValor(Float.parseFloat(valor.getText()));
        produto.setEstoqueMinimo(Integer.parseInt(estoqueMinimo.getText()));
        produto.setUnidade(unidade.getSelectedItem().toString());

        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;
        try{
            String SQL = "INSERT INTO produtos (descricao, valor, estoqueMinimo, unidade) VALUES (?, ?, ?, ?)";
            
            ps = con.prepareStatement(SQL);
            ps.setString(1,produto.getDescricao());
            ps.setFloat(2,produto.getValor());
            ps.setInt(3,produto.getEstoqueMinimo());
            ps.setString(4,produto.getUnidade());

            // executa a inserção no banco
            ps.executeUpdate();
            ps.close();
            
        }
        catch (SQLException ex){
            //System.err.println("Erro ao salvar os dados "+ex.getMessage());
            JOptionPane.showMessageDialog(null,"Erro ao salvar!\n"+ex);
        }
        finally{
            // fecha o statement e o datasource
            //ps.close();
            dataSource.closeDataSource();
        }
        atualizarTabela();
        int lastRow = table.getRowCount() - 1;
        table.setRowSelectionInterval(lastRow, lastRow);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DataSource dataSource = new DataSource();
        PreparedStatement ps = null;

        try{
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = table.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            String SQL = "SELECT * FROM produtos WHERE (id = ? OR ? = '') AND (descricao LIKE ? OR ? LIKE '');";

            try {
                // para mandar como uma instrução, precisa usar o PreparedStatement
                // traduz o comando SQL para execução
                ps = dataSource.getConnection().prepareStatement(SQL);
                ps.setString(1, codigoPesquisa.getText());
                ps.setString(2, codigoPesquisa.getText());
                ps.setString(3, "%" + descricaoPesquisa.getText() + "%");
                ps.setString(4, "%" + descricaoPesquisa.getText() + "%");

            } catch (SQLException ex) {
                Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            // executa a consulta no banco
            ResultSet rs = null;
            try {
                rs = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }

            // cria a lista de resultados trazidos da tabela
            ArrayList<Entidades> lista = new ArrayList<>();

            // enquanto tiverem registros no ResultSet (rs),
            // vai adicionando na lista
            while(rs.next()){
                // cria objeto de municipio
                // cada cidade é um objeto
                Entidades user = new Entidades();

                // adiciona o objeto (registro) na lista (arraylist)
                lista.add(user);

                model.addRow(new Object[]{rs.getInt("id"), rs.getString("descricao"), rs.getString("valor"), rs.getString("unidade"), rs.getString("estoque"), rs.getString("estoqueMinimo")});
            }

            try {
                // fecha o statement e o datasource
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            dataSource.closeDataSource();
        }   catch (SQLException ex) {
            Logger.getLogger(JIFClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        atualizarTabela();
        codigoPesquisa.setText("");
        descricaoPesquisa.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if ((codigo.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhuma coluna selecionada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja realmente excluír o valor com o código " + codigo.getText() + "?","Exclusão",JOptionPane.YES_OPTION);
        if(opcao == JOptionPane.YES_OPTION) {
            DataSource dataSource = new DataSource();
            Connection con = dataSource.getConnection();
            PreparedStatement ps = null;

            try{
                String SQL = "DELETE FROM produtos WHERE (id = ?)";

                // para mandar como uma instrução, precisa usar o PreparedStatement
                // traduz o comando SQL para execução
                ps = con.prepareStatement(SQL);
                ps.setInt(1, Integer.parseInt(codigo.getText()));

                // executa a inserção no banco
                ps.executeUpdate();
                ps.close();

            }
            catch (SQLException ex){
                //System.err.println("Erro ao salvar os dados "+ex.getMessage());
                JOptionPane.showMessageDialog(null,"Erro ao excluir!\n"+ex);
            }
            finally{
                // fecha o statement e o datasource
                dataSource.closeDataSource();
            }
        }
        atualizarTabela();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if ((codigo.getText()).equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhuma coluna selecionada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            Float.parseFloat(valor.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor digitado incorreto, digite somente números no campo valor.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            Integer.parseInt(estoqueMinimo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor digitado incorreto, digite somente números no campo Estoque mínimo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        DataSource dataSource = new DataSource();
        Produtos produto = new Produtos();
        Connection con = dataSource.getConnection();
        PreparedStatement ps = null;

        produto.setDescricao(descricao.getText());
        produto.setValor(Float.parseFloat(valor.getText()));
        produto.setEstoqueMinimo(Integer.parseInt(estoqueMinimo.getText()));
        produto.setUnidade(unidade.getSelectedItem().toString());
        
        try{
            String SQL = "UPDATE produtos SET descricao=?,valor=?,estoqueMinimo=?,unidade=? WHERE id=?";

            ps = con.prepareStatement(SQL);
            ps.setString(1,produto.getDescricao());
            ps.setFloat(2,produto.getValor());
            ps.setInt(3,produto.getEstoqueMinimo());
            ps.setString(4,produto.getUnidade());
            ps.setInt(5, Integer.parseInt(codigo.getText()));

            // executa a inserção no banco
            ps.executeUpdate();
            ps.close();
            
        }
        catch (SQLException ex){
            //System.err.println("Erro ao salvar os dados "+ex.getMessage());
            JOptionPane.showMessageDialog(null,"Erro ao alterar!\n"+ex);
        }
        finally{
            // fecha o statement e o datasource
            dataSource.closeDataSource();
        }
        atualizarTabela();
        codigo.setText("");
        descricao.setText("");
        valor.setText("");
        estoque.setText("");
        estoqueMinimo.setText("");
    }//GEN-LAST:event_jToggleButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoPesquisa;
    private javax.swing.JTextField descricao;
    private javax.swing.JTextField descricaoPesquisa;
    private javax.swing.JTextField estoque;
    private javax.swing.JTextField estoqueMinimo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> unidade;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}