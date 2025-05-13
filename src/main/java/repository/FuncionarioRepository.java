package repository;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import entity.Funcionario;

public class FuncionarioRepository {
    private Session session;

    public FuncionarioRepository() {
        this.session = new Configuration().configure().buildSessionFactory().openSession();
    }

    public void inserir(Funcionario funcionario) {
        try {
            session.beginTransaction();
            session.persist(funcionario);
            session.getTransaction().commit();
            System.out.println("Funcionário inserido com sucesso");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }
}
