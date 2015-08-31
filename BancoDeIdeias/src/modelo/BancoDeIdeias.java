package modelo;

public class BancoDeIdeias {

	private long idBancoDeIdeias;
	private String ideia;
	private String utilidade;
	private String nome;
	private String email;
	
	public BancoDeIdeias(){
		
	}
	
	public BancoDeIdeias(long idBancoDeIdeias, String ideia, String utilidade,
			String nome,String email){
		super();
		this.idBancoDeIdeias=idBancoDeIdeias;
		this.ideia=ideia;
		this.utilidade= utilidade;
		this.nome= nome;
		this.email=email;
	}
	public long getIdBancoDeIdeias() {
		return idBancoDeIdeias;
	}
	public void setIdBancoDeIdeias(long idBancoDeIdeias) {
		this.idBancoDeIdeias = idBancoDeIdeias;
	}
	public String getIdeia() {
		return ideia;
	}
	public void setIdeia(String ideia) {
		this.ideia = ideia;
	}
	public String getUtilidade() {
		return utilidade;
	}
	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
