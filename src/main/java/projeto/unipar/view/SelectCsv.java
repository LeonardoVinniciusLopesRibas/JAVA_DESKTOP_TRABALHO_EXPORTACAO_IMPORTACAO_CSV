package projeto.unipar.view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import projeto.unipar.model.PessoaColumn;
import projeto.unipar.repository.PessoaRepository;
import projeto.unipar.util.EntityManagerUtil;
import projeto.unipar.util.ExportarCSV;

public class SelectCsv extends javax.swing.JFrame {

    private FileChooser fileChooser;
    private boolean isFileChooserOpen;
    private ArrayList<PessoaColumn> pessoas;

    public SelectCsv() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fileChooser = new FileChooser();
        isFileChooserOpen = false;
        pessoas = new ArrayList<>();
        resize();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDadosCliente = new javax.swing.JTable();
        jbBuscarPlanilha = new javax.swing.JButton();
        jbDeletarRegistros = new javax.swing.JButton();
        jbExportar = new javax.swing.JButton();
        jbRecarregar = new javax.swing.JButton();
        jbImportar = new javax.swing.JButton();
        jbLimparTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jtbDadosCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "IDADE", "CPF", "RG", "DATA NASC", "SEXO", "SIGNO", "MAE", "PAI", "EMAIL", "SENHA", "CEP", "ENDEREÇO", "NÚMERO", "BAIRRO", "CIDADE", "ESTADO", "TELEFONE", "CELULAR", "ALTURA", "PESO", "TIPO SANGUINEO", "COR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDadosCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtbDadosCliente);

        jbBuscarPlanilha.setText("Buscar Planilha");
        jbBuscarPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarPlanilhaActionPerformed(evt);
            }
        });

        jbDeletarRegistros.setText("Deletar os Registros");
        jbDeletarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarRegistrosActionPerformed(evt);
            }
        });

        jbExportar.setText("Exportar");
        jbExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExportarActionPerformed(evt);
            }
        });

        jbRecarregar.setText("Recarregar");
        jbRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecarregarActionPerformed(evt);
            }
        });

        jbImportar.setText("Importar");
        jbImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImportarActionPerformed(evt);
            }
        });

        jbLimparTabela.setText("Limpar Tabela");
        jbLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBuscarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbDeletarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRecarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimparTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(354, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscarPlanilha)
                    .addComponent(jbDeletarRegistros)
                    .addComponent(jbExportar)
                    .addComponent(jbRecarregar)
                    .addComponent(jbImportar)
                    .addComponent(jbLimparTabela))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarPlanilhaActionPerformed
        // TODO add your handling code here:
        if (!isFileChooserOpen) {
            isFileChooserOpen = true;
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                isFileChooserOpen = false;
                String filePath = fileChooser.getSelectedFile().getPath();
                importarDadosDoArquivo(filePath);
            } else if (returnValue == JFileChooser.CANCEL_OPTION) {
                isFileChooserOpen = false;
            }
        }
    }//GEN-LAST:event_jbBuscarPlanilhaActionPerformed

    private void jbImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImportarActionPerformed
        // TODO add your handling code here:
        receberArquivos(pessoas);
    }//GEN-LAST:event_jbImportarActionPerformed

    private void jbDeletarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarRegistrosActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar todos os registros?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            PessoaRepository pr = new PessoaRepository();
            pr.deletarTudo(jtbDadosCliente);
        } else {
        }
    }//GEN-LAST:event_jbDeletarRegistrosActionPerformed

    private void jbRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecarregarActionPerformed
        // TODO add your handling code here:
        recarregarDadosTabela();
    }//GEN-LAST:event_jbRecarregarActionPerformed

    private void jbLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTabelaActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo limpar a tabela?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) jtbDadosCliente.getModel();
            model.setRowCount(0);
            JOptionPane.showMessageDialog(null, "DADOS LIMPOS COM SUCESSO!");
        } else {
        }

    }//GEN-LAST:event_jbLimparTabelaActionPerformed

    private void jbExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExportarActionPerformed
        // TODO add your handling code here:
        ExportarCSV ecsv = new ExportarCSV();
        ecsv.exportarDadosParaCSV(this, jtbDadosCliente);
    }//GEN-LAST:event_jbExportarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectCsv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectCsv().setVisible(true);
                EntityManagerUtil.getEntityManagerFactory();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarPlanilha;
    private javax.swing.JButton jbDeletarRegistros;
    private javax.swing.JButton jbExportar;
    private javax.swing.JButton jbImportar;
    private javax.swing.JButton jbLimparTabela;
    private javax.swing.JButton jbRecarregar;
    private javax.swing.JTable jtbDadosCliente;
    // End of variables declaration//GEN-END:variables

    private void importarDadosDoArquivo(String filePath) {
        DefaultTableModel model = (DefaultTableModel) jtbDadosCliente.getModel();
        model.setRowCount(0);
        pessoas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length > 0) {
                    Object[] row = new Object[values.length + 1];
                    row[0] = model.getRowCount() + 1;
                    System.arraycopy(values, 0, row, 1, values.length);
                    model.addRow(row);

                    PessoaColumn pessoa = new PessoaColumn();
                    pessoa.setName(values[0]);
                    pessoa.setIdade(Integer.parseInt(values[1]));
                    pessoa.setCpf(values[2]);
                    pessoa.setRg(values[3]);
                    try {
                        pessoa.setData_nasc(new SimpleDateFormat("dd/MM/yyyy").parse(values[4]));
                    } catch (ParseException ex) {
                        ex.getMessage();
                    }
                    pessoa.setSexo(values[5]);
                    pessoa.setSigno(values[6]);
                    pessoa.setMae(values[7]);
                    pessoa.setPai(values[8]);
                    pessoa.setEmail(values[9]);
                    pessoa.setSenha(values[10]);
                    pessoa.setCep(values[11]);
                    pessoa.setEndereco(values[12]);
                    pessoa.setNumero(values[13]);
                    pessoa.setBairro(values[14]);
                    pessoa.setCidade(values[15]);
                    pessoa.setEstado(values[16]);
                    pessoa.setTelefone_fixo(values[17]);
                    pessoa.setCelular(values[18]);
                    pessoa.setAltura(Double.parseDouble(values[19]));
                    pessoa.setPeso(Double.parseDouble(values[20]));
                    pessoa.setTipo_sanguineo(values[21]);
                    pessoa.setCor(values[22]);

                    pessoas.add(pessoa);
                }
            }
            JOptionPane.showMessageDialog(null, "CONTEÚDO IMPORTADO COM SUCESSO");
            ajustarLarguraDasColunas();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao importar dados do arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ajustarLarguraDasColunas() {
        for (int column = 0; column < jtbDadosCliente.getColumnCount(); column++) {
            TableColumn tableColumn = jtbDadosCliente.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < jtbDadosCliente.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jtbDadosCliente.getCellRenderer(row, column);
                Component c = jtbDadosCliente.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + jtbDadosCliente.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    private void receberArquivos(ArrayList<PessoaColumn> pessoas) {

        PessoaRepository pr = new PessoaRepository();
        pr.enviaArquivosRepository(pessoas);

    }

    private void recarregarDadosTabela() {
        PessoaRepository pr = new PessoaRepository();
        List<PessoaColumn> pessoas = pr.buscarTodos();
        DefaultTableModel model = (DefaultTableModel) jtbDadosCliente.getModel();
        model.setRowCount(0);
        if (!pessoas.isEmpty()) {

            for (PessoaColumn pessoa : pessoas) {
                Object[] row = new Object[24];
                row[0] = pessoa.getId();
                row[1] = pessoa.getName();
                row[2] = pessoa.getIdade();
                row[3] = pessoa.getCpf();
                row[4] = pessoa.getRg();
                row[5] = new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getData_nasc());
                row[6] = pessoa.getSexo();
                row[7] = pessoa.getSigno();
                row[8] = pessoa.getMae();
                row[9] = pessoa.getPai();
                row[10] = pessoa.getEmail();
                row[11] = pessoa.getSenha();
                row[12] = pessoa.getCep();
                row[13] = pessoa.getEndereco();
                row[14] = pessoa.getNumero();
                row[15] = pessoa.getBairro();
                row[16] = pessoa.getCidade();
                row[17] = pessoa.getEstado();
                row[18] = pessoa.getTelefone_fixo();
                row[19] = pessoa.getCelular();
                row[20] = pessoa.getAltura();
                row[21] = pessoa.getPeso();
                row[22] = pessoa.getTipo_sanguineo();
                row[23] = pessoa.getCor();
                model.addRow(row);
                ajustarLarguraDasColunas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FORAM ENCONTRADOS REGISTROS");
            ajustarLarguraDasColunasPorTitulo();
        }

    }

    private void resize() {
        jtbDadosCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && jtbDadosCliente.columnAtPoint(e.getPoint()) != -1) {
                    for (int column = 0; column < jtbDadosCliente.getColumnCount(); column++) {
                        TableColumn tableColumn = jtbDadosCliente.getColumnModel().getColumn(column);
                        tableColumn.setPreferredWidth(0);
                    }
                    jtbDadosCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                }
            }
        });
    }

    private void ajustarLarguraDasColunasPorTitulo() {
        TableColumnModel columnModel = jtbDadosCliente.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            TableColumn tableColumn = columnModel.getColumn(column);
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = jtbDadosCliente.getTableHeader().getDefaultRenderer();
            }
            Component headerComponent = headerRenderer.getTableCellRendererComponent(jtbDadosCliente, tableColumn.getHeaderValue(), false, false, 0, column);
            int preferredWidth = headerComponent.getPreferredSize().width + jtbDadosCliente.getIntercellSpacing().width;
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

}
