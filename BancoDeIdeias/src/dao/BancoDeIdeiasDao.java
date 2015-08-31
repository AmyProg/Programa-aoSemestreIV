package dao;

import modelo.BancoDeIdeias;

public interface BancoDeIdeiasDao extends DAO<BancoDeIdeias> {

	public BancoDeIdeias buscarPorId(long id);
}
