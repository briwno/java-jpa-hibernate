package repository;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import entity.Endereco;

public class EnderecoRepository {
    private Session session;

    public EnderecoRepository() {
        this.session = new Configuration().configure().buildSessionFactory().openSession();
    }

    public void inserir(Endereco endereco) {
        try {
            session.beginTransaction();
            session.persist(endereco);
            session.getTransaction().commit();
            System.out.println("Endereço inserido com sucesso");
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao inserir endereço: " + e.getMessage());
        }
    }
}
