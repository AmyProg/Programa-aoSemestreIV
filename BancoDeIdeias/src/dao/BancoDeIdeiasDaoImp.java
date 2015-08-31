package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.BancoDeIdeias;
import conexao.ConnectionManager;

public class BancoDeIdeiasDaoImp implements BancoDeIdeiasDao{
	
	private Connection connection;
	private final String INSERT = "INSERT INTO bancodeideias (ideia,utilidade,nome,email) VALUES (?,?,?,?)";
	private final String SELECT = "SELECT* FROM bancodeideias";
	private final String UPDATE = "UPDATE bancodeideias set ideia=?,utilidade=?,nome=?,email=? Where idBancoDeIdeias=?";
	private final String DELETE = "DELETE FROM bancodeideias WHERE idbancodeideias=?";
	private final String SELECT_ID = "SELECT* FROM bancodeideias WHERE idbancodeideias=?";

	@Override
	public void salvar(BancoDeIdeias bancodeideias) {
		try {
			PreparedStatement ps = null;
			openConnection();

			ps = connection.prepareStatement(INSERT);
			ps.setString(1, bancodeideias.getIdeia());
			ps.setString(2, bancodeideias.getUtilidade());
			ps.setString(3, bancodeideias.getNome());
			ps.setString(4, bancodeideias.getEmail());
			

			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o insert" + ex);
		} finally {
			closeConnection();
		}
	}

	@Override
	public void alterar(BancoDeIdeias bancodeideias) {
		try {
			PreparedStatement ps = null;
			openConnection();

			ps = connection.prepareStatement(UPDATE);
			
			ps.setString(1, bancodeideias.getIdeia());
			ps.setString(2, bancodeideias.getUtilidade());
			ps.setString(3, bancodeideias.getNome());
			ps.setString(4, bancodeideias.getEmail());
			ps.setLong(5,bancodeideias.getIdBancoDeIdeias());
			

			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o update" + ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public void excluir(BancoDeIdeias bancodeideias) {
		try {
			PreparedStatement ps = null;
			openConnection();

			ps = connection.prepareStatement(DELETE);

			ps.setLong(1, bancodeideias.getIdBancoDeIdeias());

			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Erro ao executar o delete" + ex);
		} finally {
			closeConnection();
		}

	}

	@Override
	public List<BancoDeIdeias> listarTodos() {
		List<BancoDeIdeias> bancodeideia = new ArrayList<BancoDeIdeias>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			openConnection();

			ps = connection.prepareStatement(SELECT);
			rs = ps.executeQuery();

			while (rs.next()) {
				BancoDeIdeias bancodeideias = new BancoDeIdeias();
				bancodeideias.setIdBancoDeIdeias(rs.getLong("idBancoDeIdeias"));
				bancodeideias.setIdeia(rs.getString("ideia"));
				bancodeideias.setUtilidade(rs.getString("utilidade"));
				bancodeideias.setNome(rs.getString("nome"));
				bancodeideias.setEmail(rs.getString("email"));
				bancodeideia.add(bancodeideias);
								
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o select" + e);
		} finally {
			closeConnection();
		}
		return bancodeideia;
	}

	@Override
	public void openConnection() {
		connection = ConnectionManager.getInstance().getConnection();
	}

	@Override
	public void closeConnection() {
		if (!isConnectionClosed()) {
			ConnectionManager.getInstance().closeConnection(connection);
		}

	}
 
	@Override
	public boolean isConnectionClosed() {
		try {
			if (connection.isClosed()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Conexão com problema!");
		}
		return false;
	}

	public BancoDeIdeias buscarPorId(long id){
		BancoDeIdeias bancodeideias=null;
		try{
			PreparedStatement ps=null;
			ResultSet rs= null;
			openConnection();
			ps=connection.prepareStatement(SELECT_ID);
			ps.setLong(1,id);
			rs=ps.executeQuery();
			if(rs.next()){
				bancodeideias = new BancoDeIdeias();
				bancodeideias.setIdBancoDeIdeias(rs.getLong("idBancoDeIdeias"));
				bancodeideias.setIdeia(rs.getString("ideia"));
				bancodeideias.setUtilidade(rs.getString("utilidade"));
				bancodeideias.setNome(rs.getString("nome"));
				bancodeideias.setEmail(rs.getString("email"));
				
			}
		}catch(SQLException ex){
			System.out.println("Erro ao executar o select por ID: "+ ex);
		}finally{
			closeConnection();
		}
		return bancodeideias;
				 		 
			}
}
