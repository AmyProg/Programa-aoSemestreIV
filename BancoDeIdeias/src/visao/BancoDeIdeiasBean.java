package visao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.BancoDeIdeias;
import controle.BancoDeIdeiasControle;

@ManagedBean(name = "bancodeideiasBean")
@SessionScoped
public class BancoDeIdeiasBean {

	private BancoDeIdeias bancodeideias;
	private BancoDeIdeiasControle controle;
	private List<BancoDeIdeias> bancodeideia;
	private BancoDeIdeias bancodeideiasSelecionado;

	public BancoDeIdeiasBean() {
		bancodeideias = new BancoDeIdeias();
		controle = new BancoDeIdeiasControle();
	}

	public BancoDeIdeias getBancoDeIdeiasSelecionado() {
		return bancodeideiasSelecionado;
	}

	public void setBancoDeIdeiasSelecionado(BancoDeIdeias bancodeideiasSelecionado) {
		this.bancodeideiasSelecionado = bancodeideiasSelecionado;
	}

	public List<BancoDeIdeias> getBancoDeIdeia() {
		if (bancodeideia == null) {
			bancodeideia = controle.listarTodos();
		}
		return bancodeideia;
	}

	public BancoDeIdeias getBancoDeIdeias() {
		return bancodeideias;
	}

	public void setBancoDeIdeias(BancoDeIdeias bancodeideias) {
		this.bancodeideias = bancodeideias;
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;

		try {
			controle.salvar(bancodeideias);
			bancodeideias = new BancoDeIdeias();
			bancodeideia = null;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Ideia cadastrada com sucesso!", "");
			context.addMessage(null, message);

		} catch (Exception e) {
			e.printStackTrace();
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), "");
			context.addMessage(null, message);

		}
		return null;

	}

	public String novo() {
		bancodeideias = new BancoDeIdeias();
		return "cadastroBancoDeIdeias";
	}

	public String alterar() {
		bancodeideias = bancodeideiasSelecionado;
		bancodeideiasSelecionado = null;

		return "cadastroBancoDeIdeias";
	}

	public String excluir() {
		controle.excluir(bancodeideiasSelecionado);
		bancodeideia.remove(bancodeideiasSelecionado);
		bancodeideiasSelecionado = null;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"A ideia foi removido", "");
		context.addMessage(null, message);
		return null;
	}

	public String voltar() {
		return "listarBancoDeIdeias";
	}
}
