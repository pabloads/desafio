package br.com.pablo.desafio.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.pablo.desafio.dto.PessoaDTO;
import br.com.pablo.desafio.model.Pessoa;
import br.com.pablo.desafio.service.PessoaService;

@ManagedBean
@ViewScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private PessoaDTO pessoaDTO;
	private List<Pessoa> lista;
	private PessoaService pessoaService = new PessoaService();

	@PostConstruct
	public void init() {
		this.pessoa = new Pessoa();
		this.pessoaDTO = new PessoaDTO();
		listarTodos();
	}

	public String cadastrar() {
		Pessoa pessoaCPF = pessoaService.consultarPorCPF(this.pessoa);
		if (pessoaCPF == null) {
			pessoaService.cadastrar(this.pessoa);
			this.pessoa = null;
			listarTodos();
		} else {
			gerarMensagemCPFExistente();
		}
		return "index";
	}

	public void listarTodos() {
		this.lista = pessoaService.listarTodos();
		if (lista.isEmpty()) {
			gerarMensagemNenhumRegistroEncontrado("Não existe dados cadastrados.");
		}
	}

	public String pesquisar() {
		this.lista = pessoaService.pesquisar(new Pessoa(pessoaDTO));
		if (lista.isEmpty()) {
			gerarMensagemNenhumRegistroEncontrado("Nenhum registro encontrado.");
		}
		return "";
	}

	public void editar(Pessoa pessoa) {
		pessoa.setEditando(Boolean.TRUE);
		this.pessoa = pessoa;
	}

	public String salvarEdicao(Pessoa pessoa) {

		Pessoa pessoaCPF = pessoaService.consultarPorCPF(pessoa);
		if (pessoaCPF != null && pessoaCPF.getId() != pessoa.getId()) {
			gerarMensagemCPFExistente();
		} else {
			pessoa.setEditando(Boolean.FALSE);
			pessoaService.editar(pessoa);
			listarTodos();
		}

		return "";
	}

	public void limpar() {
		this.pessoa = null;
		this.lista = null;
	}

	public String cancelar(Pessoa pessoa) {
		pessoa.setEditando(Boolean.FALSE);
		this.pessoa = pessoa;
		return "";
	}

	public String excluir(Pessoa pessoa) {
		pessoaService.excluir(pessoa);
		listarTodos();
		return "";
	}

	private void gerarMensagemCPFExistente() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "CPF já cadastrado.", "");
		FacesContext.getCurrentInstance().addMessage("status", message);
	}
	
	private void gerarMensagemNenhumRegistroEncontrado(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
		FacesContext.getCurrentInstance().addMessage("notFound", message);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}
}
