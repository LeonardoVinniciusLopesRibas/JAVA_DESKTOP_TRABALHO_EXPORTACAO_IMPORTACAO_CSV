package projeto.unipar.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExportarCSV {

    public void exportarDadosParaCSV(JFrame selectFrame, JTable jtbDadosCliente) {
        String homeDirectory = System.getProperty("user.home");
        String destinationDirectoryPath = homeDirectory + "/.manipulacaoArquivo";
        File destinationDirectory = new File(destinationDirectoryPath);
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdirs();
        }
        String fileName = "dados_exportados.csv";
        String filePath = destinationDirectoryPath + "/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            DefaultTableModel model = (DefaultTableModel) jtbDadosCliente.getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();

            if (rowCount == 0) {
                JOptionPane.showMessageDialog(selectFrame, "Não há dados para exportar.", "Sem Dados", JOptionPane.WARNING_MESSAGE);
                return;
            }
            for (int i = 0; i < columnCount; i++) {
                writer.append(model.getColumnName(i));
                if (i < columnCount - 1) {
                    writer.append(',');
                } else {
                    writer.append('\n');
                }
            }

            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    writer.append(model.getValueAt(row, col).toString());
                    if (col < columnCount - 1) {
                        writer.append(';');
                    } else {
                        writer.append('\n');
                    }
                }
            }

            JOptionPane.showMessageDialog(selectFrame, "Dados exportados com sucesso para: " + filePath, "Exportação Concluída", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(selectFrame, "Erro ao exportar dados para CSV: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
