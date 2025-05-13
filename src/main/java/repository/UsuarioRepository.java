package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import entity.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

/**
 * Classe responsável por realizar operações no banco de dados referente a
 * entidade Pedido: - Inserir - Atualizar - Deletar - Consultar
 */
public class UsuarioRepository {

	private Session session;
	
	public UsuarioRepository() {
        this.session =new Configuration()
        		.configure()
        		.buildSessionFactory()
        		.openSession();
	}

	/**
	 * Método responsável por inserir um usuário no banco de dados.
	 * 
	 * @param usuario dados do usuário
	 */
	public void inserir(Usuario usuario) {
		try {
			session.beginTransaction();
				session.persist(usuario);	
			session.getTransaction().commit();
			System.out.println("Usuário inserido com sucesso");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Ocorreu um problema ao inserir o usuário: " + e.getMessage());
		}
	}

	/**
	 * Método responsável por atualizar os dados do usuário no banco de dados.
	 * 
	 * @param usuario dados do usuário
	 */
	public void atualizar(Usuario usuario) {
		try {
			session.beginTransaction();
				session.merge(usuario);	
			session.getTransaction().commit();
			System.out.println("Usuário atualizado com sucesso");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Ocorreu um problema ao atualizar o usuário: " + e.getMessage());
		}
	}

	/**
	 * Método responsável por remover um usuário no banco de dados com base no seu id.
	 * 
	 * @param id identificação do usuário
	 */
	public void remover(long id) {
		try {
			session.beginTransaction();
				session.remove(id);	
			session.getTransaction().commit();
			System.out.println("Usuário removido com sucesso");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Ocorreu um problema ao remover o usuário: " + e.getMessage());
		}
	}

	/**
	 * Método responsável por consultar todos os usuários
	 * 
	 * @return lista de usuários
	 */
	public List<Usuario> pesquisarTodos() {
		List<Usuario> registros = new ArrayList<>();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
			criteria.from(Usuario.class);
			registros = session.createQuery(criteria).getResultList();			
		} catch (Exception e) {
			System.out.println("Ocorreu um problema ao consultar todos os usuários: " + e.getMessage());
		}
        return registros;
	}

	// TODO: implementar
	public Usuario pesquisaPeloCpf(String cpf) {
		return null;
	}

	public Usuario pesquisaPeloId(long id) {
		Usuario usuario = null;
		try {
			usuario = session.find(Usuario.class, id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Ocorreu um problema ao consultar o usuário pelo Id: " + e.getMessage());
		}
		return usuario;
	}
	
	// TODO: implementar
	public List<Usuario> pesquisaPelaInicialDoNome(String inicial) {
		return null;
	}

}
