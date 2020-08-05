package br.com.pablo.desafio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.pablo.desafio.model.Pessoa;
import br.com.pablo.desafio.utils.JPAUtil;

public class PessoaDAO {

	private EntityManager entityManager = JPAUtil.getEntityManager();

	public Pessoa getById(Long id) {
		return entityManager.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() {
		return entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
	}

	public void persist(Pessoa Pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(Pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Pessoa Pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Pessoa Pessoa) {
		try {
			entityManager.getTransaction().begin();
			Pessoa = entityManager.find(Pessoa.class, Pessoa.getId());
			entityManager.remove(Pessoa);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(Long id) {
		try {
			Pessoa Pessoa = getById(id);
			remove(Pessoa);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Pessoa> pesquisar(Pessoa pessoa) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
		Root<Pessoa> from = cq.from(Pessoa.class);

		Predicate predicate = cb.and();

		if (pessoa.getNome() != null && !pessoa.getNome().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("nome"), pessoa.getNome()));
		}

		if (pessoa.getEmail() != null && !pessoa.getEmail().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("email"), pessoa.getEmail()));
		}

		if (pessoa.getCpf() != null && !pessoa.getCpf().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("cpf"), pessoa.getCpf()));
		}
		
		if (pessoa.getDataNascimento() != null) {
			predicate = cb.and(predicate, cb.equal(from.get("dataNascimento"), pessoa.getDataNascimento()));
		}
		
		if (pessoa.getSexo() != null && !pessoa.getSexo().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("sexo"), pessoa.getSexo()));
		}
		
		if (pessoa.getNaturalidade() != null && !pessoa.getNaturalidade().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("naturalidade"), pessoa.getNaturalidade()));
		}
		
		if (pessoa.getNacionalidade() != null && !pessoa.getNacionalidade().isEmpty()) {
			predicate = cb.and(predicate, cb.equal(from.get("nacionalidade"), pessoa.getNacionalidade()));
		}

		cq.select(from).where(predicate);
		TypedQuery<Pessoa> query = entityManager.createQuery(cq);

		return query.getResultList();
	}

	public Pessoa consultarPorCPF(Pessoa pessoa) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
		Root<Pessoa> from = cq.from(Pessoa.class);

		Predicate predicate = cb.and();

		if (pessoa.getCpf() != null) {
			predicate = cb.and(predicate, cb.equal(from.get("cpf"), pessoa.getCpf()));
		}

		cq.select(from).where(predicate);
		TypedQuery<Pessoa> query = entityManager.createQuery(cq);

		try {
			return query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		}
	}

}
