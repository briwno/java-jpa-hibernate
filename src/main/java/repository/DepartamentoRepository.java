package repository;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import entity.Departamento;

public class DepartamentoRepository {
    private Session session;

    public DepartamentoRepository() {
        this.session = new Configuration().configure().buildSessionFactory().openSession();
    }

    public void inserir(Departamento departamento) {
        try {
            session.beginTransaction();
            session.persist(departamento);
            session.getTransaction().commit();
            System.out.println("Departamento inserido com sucesso");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao inserir departamento: " + e.getMessage());
        }
    }
}
