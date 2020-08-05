package br.com.pablo.desafio.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.pablo.desafio.dto.PessoaDTO;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email")
	@Email(message = "Formato de e-mail inválido.")
	private String email;
	
	@Column(name = "data_nascimento")
	@NotNull(message = "Data de Nascimento não informada.")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "naturalidade")
	private String naturalidade;
	
	@Column(name = "nacionalidade")
	private String nacionalidade;
	
	@Column(name = "cpf", unique = true)
	@NotNull
	@CPF(message = "Formato de CPF inválido.")
	private String cpf;
	
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
	
	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@Column(name = "endereco")
	@NotNull
	private String endereco;
	
	@Transient
	private Boolean editando;
	
	
	public Pessoa(PessoaDTO pessoaDTO) {
		this.id = pessoaDTO.getId();
		this.nome = pessoaDTO.getNome();
		this.sexo = pessoaDTO.getSexo();
		this.email = pessoaDTO.getEmail();
		this.dataNascimento = pessoaDTO.getDataNascimento();
		this.naturalidade = pessoaDTO.getNaturalidade();
		this.nacionalidade = pessoaDTO.getNacionalidade();
		this.cpf = pessoaDTO.getCpf();
		this.dataCadastro = pessoaDTO.getDataCadastro();
		this.editando = pessoaDTO.getEditando();
	}
	
	
	public Pessoa() {
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Boolean getEditando() {
		return editando;
	}
	public void setEditando(Boolean editando) {
		this.editando = editando;
	}


	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
