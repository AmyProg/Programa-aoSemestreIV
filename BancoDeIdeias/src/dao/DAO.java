package dao;

import java.util.List;

public interface DAO<T> {

	public void salvar(T t);
	public void alterar(T t);
	public void excluir(T t);
	public List<T> listarTodos();
	public void openConnection();
	public void closeConnection();
	public boolean isConnectionClosed();
}
