package controle;


import java.util.List;

import modelo.BancoDeIdeias;
import dao.BancoDeIdeiasDao;
import dao.DAOFactory;

public class BancoDeIdeiasControle {

public void salvar(BancoDeIdeias bancodeideias) throws Exception {
		
		if (bancodeideias.getIdeia()==null||bancodeideias.getIdeia().trim().isEmpty()) {
			throw new Exception(" Informe uma ideia!");
		}
		
		if (bancodeideias.getUtilidade().trim().isEmpty()) {
			throw new Exception(" Informe o como sera util a sua ideia?!");
		}
		if (bancodeideias.getNome().trim().isEmpty()) {
			throw new Exception(" Informe o seu nome!");
		}
		if (bancodeideias.getEmail().trim().isEmpty()) {
			throw new Exception("Informe o seu email!");
		}

		BancoDeIdeiasDao bancodeideiasDao = DAOFactory.getBancoDeIdeiasDao();
		if (bancodeideias.getIdBancoDeIdeias() == 0) {
			bancodeideiasDao.salvar(bancodeideias);
		} else {
			bancodeideiasDao.alterar(bancodeideias);
		}
}

	public List<BancoDeIdeias>listarTodos(){
		BancoDeIdeiasDao bancodeideiasDao= DAOFactory.getBancoDeIdeiasDao();
		return bancodeideiasDao.listarTodos();
	}
	
	public void excluir(BancoDeIdeias bancodeideias){
		BancoDeIdeiasDao bancodeideiasDao = DAOFactory.getBancoDeIdeiasDao();
		bancodeideiasDao.excluir(bancodeideias);
	}
}
