package projeto.unipar.view;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends javax.swing.JFrame {

    private JFileChooser fileChooser;
    public FileChooser() {
        initComponents();
        fileChooser = new JFileChooser();
        configurarFiltrosArquivo();
    }
    
    private void configurarFiltrosArquivo() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos CSV e XLS", "csv", "xls");
        jfcFileChooser.setFileFilter(filtro);
        jfcFileChooser.setAcceptAllFileFilterUsed(false);
    }
    
    public int showOpenDialog(Component parent) {
        return fileChooser.showOpenDialog(parent);
    }

    public File getSelectedFile() {
        return fileChooser.getSelectedFile();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcFileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jfcFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfcFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jfcFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jfcFileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jfcFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfcFileChooserActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jfcFileChooserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jfcFileChooser;
    // End of variables declaration//GEN-END:variables

    
}
