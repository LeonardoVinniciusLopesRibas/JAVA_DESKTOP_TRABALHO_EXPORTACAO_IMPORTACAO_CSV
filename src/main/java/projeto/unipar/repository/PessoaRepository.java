package projeto.unipar.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projeto.unipar.model.PessoaColumn;
import projeto.unipar.util.EntityManagerUtil;

public class PessoaRepository {

    public void enviaArquivosRepository(ArrayList<PessoaColumn> pessoas) {

        EntityManager em = EntityManagerUtil.getManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            for (PessoaColumn pessoa : pessoas) {

                em.persist(pessoa);

            }

            JOptionPane.showMessageDialog(null, "DADOS IMPORTADOS COM SUCESSO");
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

    }

    public void deletarTudo(JTable jtbDadosCliente) {
        EntityManager em = EntityManagerUtil.getManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.createQuery("DELETE FROM PessoaColumn").executeUpdate();
            transaction.commit();
            JOptionPane.showMessageDialog(null, "DADOS DELETADOS COM SUCESSO");
            DefaultTableModel model = (DefaultTableModel) jtbDadosCliente.getModel();
            model.setRowCount(0);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<PessoaColumn> buscarTodos() {
        EntityManager em = EntityManagerUtil.getManager();
        try {
            Query query = em.createQuery("SELECT p FROM PessoaColumn p");
            System.out.println(query);
            return query.getResultList();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

}
