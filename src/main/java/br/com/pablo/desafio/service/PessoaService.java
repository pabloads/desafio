package br.com.pablo.desafio.service;

import java.time.LocalDate;
import java.util.List;

import br.com.pablo.desafio.dao.PessoaDAO;
import br.com.pablo.desafio.model.Pessoa;

public class PessoaService {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	public void cadastrar(Pessoa pessoa) {
		pessoa.setDataCadastro(LocalDate.now());
		pessoaDAO.persist(pessoa);
		
	}

	public void editar(Pessoa pessoa) {
		pessoa.setDataAtualizacao(LocalDate.now());
		pessoaDAO.merge(pessoa);
	}
	
	public List<Pessoa> pesquisar(Pessoa pessoa) {
		return pessoaDAO.pesquisar(pessoa);
	}

	public Pessoa consultarPorCPF(Pessoa pessoa) {
		return pessoaDAO.consultarPorCPF(pessoa);
	}

	public List<Pessoa> listarTodos() {
		return pessoaDAO.findAll();
	}

	public void excluir(Pessoa pessoa) {
		pessoaDAO.remove(pessoa);
		
	}
}
