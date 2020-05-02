package br.com.cadastro.dao;

import java.sql.ResultSet;
import br.com.cadastro.model.Leitor;
import br.com.cadastro.util.ConnectionFactory;

public class LeitorDAO {
	
		
		private Leitor leitor;
		private java.sql.Connection conn;		//conect ao banco de dados 
		private java.sql.PreparedStatement ps;	//permite execultar querys
		private ResultSet rs;			//tabela

	 	 public LeitorDAO() throws Exception {
	 		 try {
	 			conn = ConnectionFactory.getConection();
	 		 }catch(Exception e) {
	 			 throw new Exception("Erro ao conectar ao BD!! "+ e.getMessage());
	 		 }
	 		 
	 	 }
	 	 
	 	 public void salvarDadosPessoal(Leitor leitor) throws Exception {
	 		 try {
	  			String sql = "INSERT INTO DADOS_PESSOAL(rgm, nome, "
	  					+ "data_Nacimento, cpf, email, endereco, municipil, "
	  					+ "uf, celular)"
	  					+"values(?,?,?,?,?,?,?,?,?)";
	  			ps = conn.prepareStatement(sql);
	  			ps.setInt(1, leitor.getRgmLeitor());
	  			ps.setString(2, leitor.getNomeLeitor());
	  			ps.setString(3, leitor.getDataNacimentoLeitor());
	  			ps.setInt(4, leitor.getCpfLeitor());
	  			ps.setString(5, leitor.getEmalLeitor());
	  			ps.setString(6, leitor.getEnderecoLeitor());
	  			ps.setString(7, leitor.getMunicipilLeitor());
	  			ps.setString(8, leitor.getUfLeitor());
	  			ps.setString(9, leitor.getCelularLeitor());
	  			ps.executeUpdate();
	  					
	  		 }catch(Exception e) {
	  			 throw new Exception("Erro ao Salvar Dados Pessoal!!! "+ e.getMessage());
	  			
	  		 }
	 	 }
	 	 
	 	 public void salvarDados(Leitor leitor) throws Exception {
	 		 try {
	  			String sql = "INSERT INTO DADOS(rgm, curco, "
	  					+ "campo, perildo)"
	  					+"values(?,?,?,?)";
	  			ps = conn.prepareStatement(sql);
	  			ps.setInt(1, leitor.getRgmLeitor());
	  			ps.setString(2, leitor.getCurcoLeitor());
	  			ps.setString(3, leitor.getCampoLeitor());
	  			ps.setString(4, leitor.getPerildoLeitor());
	  			ps.executeUpdate();
	  					
	  		 }catch(Exception e) {
	  			 throw new Exception("Erro ao Salvar Dados!!! "+ e.getMessage());
	  			
	  		 }
	 	 }
	 	 
	 	 public void salvarNotaFalta(Leitor leitor) throws Exception {
	 		 try {
	  			String sql = "INSERT INTO NOTAS_FALTAS(rgm ,diciplina, semestre, "
	  					+ "NOTA, fALTA)"
	  					+"values(?,?,?,?,?)";
	  			ps = conn.prepareStatement(sql);
	  			ps.setInt(1, leitor.getRgmLeitor());
	  			ps.setString(2, leitor.getDiciplinaLeitor());
	  			ps.setString(3, leitor.getSemestreLeitor());
	  			ps.setString(4, leitor.getNotaLeitor());
	  			ps.setInt(5, leitor.getFaltaLeitor());
	  			ps.executeUpdate();
	  					
	  		 }catch(Exception e) {
	  			 throw new Exception("Erro ao Salvar Nota e Falta!!! "+ e.getMessage());
	  			
	  		 }
	 	 }
	 	
	 	 
	 	
	 	 
	 	 public Leitor consultarDadosPessoal (int rgmLeitor) throws Exception {
	  		 try {
	  			 ps = conn.prepareStatement("SELECT * FROM DADOS_PESSOAL WHERE rgm=?");
	  			 ps.setInt(1, rgmLeitor);
	  			 rs = ps.executeQuery();
	  			 if(rs.next()) {
	  				 String nomeLeitor = rs.getString("nome");
	  				 String dataNacimentLeitor = rs.getString("DATA_NACIMENTO");
	  				 int cpfLeitor = rs.getInt("cpf");
	  				 String emalLeitor = rs.getString("email");
	  				 String enderecoLeitor = rs.getString("endereco");
	  				 String municipilLeitor = rs.getString("municipil");
	  				 String ufLeitor = rs.getString("uf");
	  				String celularLeitor = rs.getString("celular");
	  				 
	  				 leitor = new Leitor(rgmLeitor, nomeLeitor, dataNacimentLeitor, cpfLeitor, emalLeitor, enderecoLeitor, municipilLeitor,ufLeitor, celularLeitor);
	  			 }
	  		 return leitor;
	  		 }catch(Exception e) {
	   			 throw new Exception("Erro ao Consultar Dados Pessoal "+ e.getMessage());
	   		 }
	  	 }
	 	 
	 	public Leitor consultarDados (int rgmLeitor) throws Exception {
	  		 try {
	  			 ps = conn.prepareStatement("SELECT * FROM DADOS WHERE rgm=?");
	  			 ps.setInt(1, rgmLeitor);
	  			 rs = ps.executeQuery();
	  			 if(rs.next()) {
	  				 String curcoLeitor = rs.getString("curco");
	  				 String campoLeitor = rs.getString("campo");
	  				 String perildoLeitor = rs.getString("perildo");
	  				 leitor = new Leitor(rgmLeitor, curcoLeitor, campoLeitor, perildoLeitor);
	  			 }
	  		 return leitor;
	  		 }catch(Exception e) {
	   			 throw new Exception("Erro ao Consultar Dados "+ e.getMessage());
	   		 }
	  	 }
	 	 
	 	public Leitor consultarNotaFalta (int rgmLeitor) throws Exception {
	  		 try {
	  			 ps = conn.prepareStatement("SELECT DAD.CURCO, DAP.NOME, "
	  			 		+ "NTF.* FROM DADOS DAD JOIN DADOS_PESSOAL DAP ON DAD.RGM = "
	  			 		+ "DAP.RGM JOIN NOTAS_FALTAS NTF ON DAP.RGM = NTF.RGM WHERE NTF.RGM=?");
	  			 ps.setInt(1, rgmLeitor);
	  			 rs = ps.executeQuery();
	  			 if(rs.next()) {
	  				 String nomeLeitor = rs.getString("DAP.NOME");
	  				 String curcoLeitor = rs.getString("DAD.CURCO");
	  				 String diciplinaLeitor = rs.getString("NTF.DICIPLINA");
	  				 String semestreLeitor = rs.getString("NTF.SEMESTRE");
	  				 String notaLeitor = rs.getString("NTF.NOTA");
	  				 int faltaLeitor = rs.getInt("FALTA");
	  				 leitor = new Leitor(rgmLeitor,nomeLeitor, curcoLeitor, diciplinaLeitor, semestreLeitor, notaLeitor, faltaLeitor);
	  			 }
	  		 return leitor;
	  		 }catch(Exception e) {
	   			 throw new Exception("Erro ao Consultar Nota e Falta "+ e.getMessage());
	   		 }
	  	 }
	 	
	 	public Leitor consultarBoletim (int rgmLeitor) throws Exception {
	  		 try {
	  			 ps = conn.prepareStatement("SELECT DAD.CURCO, DAP.NOME, "
	  			 		+ "NTF.* FROM DADOS DAD JOIN DADOS_PESSOAL DAP ON DAD.RGM = "
	  			 		+ "DAP.RGM JOIN NOTAS_FALTAS NTF ON DAP.RGM = NTF.RGM WHERE NTF.RGM=?");
	  			 ps.setInt(1, rgmLeitor);
	  			 rs = ps.executeQuery();
	  			 if(rs.next()) {
	  				 String nomeLeitor = rs.getString("DAP.NOME");
	  				 String curcoLeitor = rs.getString("DAD.CURCO");
	  				 String diciplinaLeitor = rs.getString("NTF.DICIPLINA");
	  				 String semestreLeitor = rs.getString("NTF.SEMESTRE");
	  				 String notaLeitor = rs.getString("NTF.NOTA");
	  				 int faltaLeitor = rs.getInt("FALTA");
	  				 leitor = new Leitor(rgmLeitor,nomeLeitor, curcoLeitor, diciplinaLeitor, semestreLeitor, notaLeitor, faltaLeitor);
	  			 }
	  		 return leitor;
	  		 }catch(Exception e) {
	   			 throw new Exception("Erro ao Consultar Nota e Falta "+ e.getMessage());
	   		 }
	  	 }
	 	 
	 		 public void alterarDadoPessoal(Leitor leitor) throws Exception {
	 	 		 try {
	 	  			String sql = "UPDATE DADOS_PESSOAL SET nome=?,"
	 	  					+ " DATA_NACIMENTO=?, cpf=?, email=?, endereco=?, "
	 	  					+ "municipil=?, uf=?, celular=?"
	 	  					+"WHERE rgm=?";
	 	  			ps = conn.prepareStatement(sql);
	 	  			ps.setString(1, leitor.getNomeLeitor());
	 	  			ps.setString(2, leitor.getDataNacimentoLeitor());
	 	  			ps.setInt(3, leitor.getCpfLeitor());
	 	  			ps.setString(4, leitor.getEmalLeitor());
	 	  			ps.setString(5, leitor.getEnderecoLeitor());
	 	  			ps.setString(6, leitor.getMunicipilLeitor());
	 	  			ps.setString(7, leitor.getUfLeitor());
	 	  			ps.setString(8, leitor.getCelularLeitor());
	 	  			ps.setInt(9, leitor.getRgmLeitor());
	 	  			ps.executeUpdate();		
	 	  		 }catch(Exception e) {
	 	  		 throw new Exception("Erro ao altera "+ e.getMessage());
	 	 	 }
	 	 }
	 		 
	 		public void alterarDados(Leitor leitor) throws Exception {
	 		 try {
	 	  			String sql = "UPDATE DADOS SET  curco=?, campo=?, perildo=?"
	 	  					+"WHERE rgm=?";
	 	  			ps = conn.prepareStatement(sql);
	 	  			ps.setString(1, leitor.getCurcoLeitor());
	 	  			ps.setString(2, leitor.getCampoLeitor());
	 	  			ps.setString(3, leitor.getPerildoLeitor());
	 	  			ps.setInt(4, leitor.getRgmLeitor());
	 	  			ps.executeUpdate();		
	 	  		 }catch(Exception e) {
	 	  		 throw new Exception("Erro ao altera "+ e.getMessage());
	 	 	 }
	 	 } 
	 		
	 		public void alterarNotaFalta(Leitor leitor) throws Exception {
		 		 try {
		 	  			String sql ="UPDATE NOTAS_FALTAS SET DICIPLINA=?, SEMESTRE=?, NOTA=?, FALTA=? WHERE RGM=?";
		 	  			ps = conn.prepareStatement(sql);
		 	  			ps.setString(1, leitor.getDiciplinaLeitor());
		 	  			ps.setString(2, leitor.getSemestreLeitor());
		 	  			ps.setString(3, leitor.getNotaLeitor());
		 	  			ps.setInt(4, leitor.getFaltaLeitor());
		 	  			ps.setInt(5, leitor.getRgmLeitor());
		 	  			ps.executeUpdate();		
		 	  		 }catch(Exception e) {
		 	  		 throw new Exception("Erro ao altera "+ e.getMessage());
		 	 	 }
		 	 } 
	 		

	 		public void excluirDadoPessoal(int rgmLeitor) throws Exception {
		 		 try {
		  			String sql = "DELETE FROM DADOS_PESSOAL "
		  					+"WHERE rgm=?";
		  			ps = conn.prepareStatement(sql);
		  			ps.setInt(1, rgmLeitor);
		  			ps.executeUpdate();	
		  		 }catch(Exception e) {
		  		throw new Exception("Erro ao excluir "+ e.getMessage());
		  	}
		 }
	
	 		public void excluirDado(int rgmLeitor) throws Exception {
		 		 try {
		  			String sql = "DELETE FROM DADOS "
		  					+"WHERE rgm=?";
		  			ps = conn.prepareStatement(sql);
		  			ps.setInt(1, rgmLeitor);
		  			ps.executeUpdate();	
		  		 }catch(Exception e) {
		  		throw new Exception("Erro ao excluir "+ e.getMessage());
		  	}
		 }
	 	
	 		public void excluirNotaFalta(int rgmLeitor) throws Exception {
		 		 try {
		  			String sql = "DELETE FROM NOTAS_FALTAS "
		  					+"WHERE rgm=?";
		  			ps = conn.prepareStatement(sql);
		  			ps.setInt(1, rgmLeitor);
		  			ps.executeUpdate();	
		  		 }catch(Exception e) {
		  		throw new Exception("Erro ao excluir "+ e.getMessage());
		  	}
		 }
}
