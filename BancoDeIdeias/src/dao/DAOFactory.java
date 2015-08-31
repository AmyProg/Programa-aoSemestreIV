package dao;

public class DAOFactory {
	
	private static BancoDeIdeiasDao bancodeideiasDao;
	
	public static BancoDeIdeiasDao getBancoDeIdeiasDao(){
		if(bancodeideiasDao == null){
			bancodeideiasDao = new BancoDeIdeiasDaoImp();
		}
		return bancodeideiasDao;
	}
}
