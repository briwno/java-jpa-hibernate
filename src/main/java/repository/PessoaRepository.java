package repository;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import entity.Pessoa;

public class PessoaRepository {
    private Session session;

    public PessoaRepository() {
        this.session = new Configuration().configure().buildSessionFactory().openSession();
    }

    public void inserir(Pessoa pessoa) {
        try {
            session.beginTransaction();
            session.persist(pessoa);
            session.getTransaction().commit();
            System.out.println("Pessoa inserida com sucesso");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }
}
