package br.com.cadastro.model;

public class Leitor {
	
	private int rgmLeitor;
	private String nomeLeitor;
	private String dataNacimentoLeitor;
	private int cpfLeitor;
	private String emalLeitor;
	private String EnderecoLeitor;
	private String municipilLeitor;
	private String ufLeitor;
	private String celularLeitor;
	private String curcoLeitor;
	private String campoLeitor;
	private String perildoLeitor;
	private String diciplinaLeitor;
	private String semestreLeitor;
	private String notaLeitor;
	private int faltaLeitor;
	
	public Leitor() {
		
	}

	

	public Leitor(int rgmLeitor, String nomeLeitor, String dataNacimentoLeitor, int cpfLeitor, String emalLeitor,
			String enderecoLeitor, String municipilLeitor, String ufLeitor, String celularLeitor) {
		super();
		this.rgmLeitor = rgmLeitor;
		this.nomeLeitor = nomeLeitor;
		this.dataNacimentoLeitor = dataNacimentoLeitor;
		this.cpfLeitor = cpfLeitor;
		this.emalLeitor = emalLeitor;
		this.EnderecoLeitor = enderecoLeitor;
		this.municipilLeitor = municipilLeitor;
		this.ufLeitor = ufLeitor;
		this.celularLeitor = celularLeitor;
	}



	public Leitor(int rgmLeitor, String curcoLeitor, String campoLeitor, String perildoLeitor) {
		super();
		this.rgmLeitor = rgmLeitor;
		this.curcoLeitor = curcoLeitor;
		this.campoLeitor = campoLeitor;
		this.perildoLeitor = perildoLeitor;
	}

	



	public Leitor(int rgmLeitor, String diciplinaLeitor, String semestreLeitor, String notaLeitor, int faltaLeitor) {
		super();
		this.rgmLeitor = rgmLeitor;
		this.diciplinaLeitor = diciplinaLeitor;
		this.semestreLeitor = semestreLeitor;
		this.notaLeitor = notaLeitor;
		this.faltaLeitor = faltaLeitor;
	}



	public Leitor(int rgmLeitor, String nomeLeitor, String curcoLeitor, String diciplinaLeitor, String semestreLeitor,
			String notaLeitor, int faltaLeitor) {
		super();
		this.rgmLeitor = rgmLeitor;
		this.nomeLeitor = nomeLeitor;
		this.curcoLeitor = curcoLeitor;
		this.diciplinaLeitor = diciplinaLeitor;
		this.semestreLeitor = semestreLeitor;
		this.notaLeitor = notaLeitor;
		this.faltaLeitor = faltaLeitor;
	}



	public int getRgmLeitor() {
		return rgmLeitor;
	}



	public void setRgmLeitor(int rgmLeitor) {
		this.rgmLeitor = rgmLeitor;
	}



	public String getNomeLeitor() {
		return nomeLeitor;
	}



	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}



	public String getDataNacimentoLeitor() {
		return dataNacimentoLeitor;
	}



	public void setDataNacimentoLeitor(String dataNacimentoLeitor) {
		this.dataNacimentoLeitor = dataNacimentoLeitor;
	}



	public int getCpfLeitor() {
		return cpfLeitor;
	}



	public void setCpfLeitor(int cpfLeitor) {
		this.cpfLeitor = cpfLeitor;
	}



	public String getEmalLeitor() {
		return emalLeitor;
	}



	public void setEmalLeitor(String emalLeitor) {
		this.emalLeitor = emalLeitor;
	}



	public String getEnderecoLeitor() {
		return EnderecoLeitor;
	}



	public void setEnderecoLeitor(String enderecoLeitor) {
		EnderecoLeitor = enderecoLeitor;
	}



	public String getMunicipilLeitor() {
		return municipilLeitor;
	}



	public void setMunicipilLeitor(String municipilLeitor) {
		this.municipilLeitor = municipilLeitor;
	}



	public String getUfLeitor() {
		return ufLeitor;
	}



	public void setUfLeitor(String ufLeitor) {
		this.ufLeitor = ufLeitor;
	}



	public String getCelularLeitor() {
		return celularLeitor;
	}



	public void setCelularLeitor(String celularLeitor) {
		this.celularLeitor = celularLeitor;
	}



	public String getCurcoLeitor() {
		return curcoLeitor;
	}



	public void setCurcoLeitor(String curcoLeitor) {
		this.curcoLeitor = curcoLeitor;
	}



	public String getCampoLeitor() {
		return campoLeitor;
	}



	public void setCampoLeitor(String campoLeitor) {
		this.campoLeitor = campoLeitor;
	}



	public String getPerildoLeitor() {
		return perildoLeitor;
	}



	public void setPerildoLeitor(String perildoLeitor) {
		this.perildoLeitor = perildoLeitor;
	}



	public String getDiciplinaLeitor() {
		return diciplinaLeitor;
	}



	public void setDiciplinaLeitor(String diciplinaLeitor) {
		this.diciplinaLeitor = diciplinaLeitor;
	}



	public String getSemestreLeitor() {
		return semestreLeitor;
	}



	public void setSemestreLeitor(String semestreLeitor) {
		this.semestreLeitor = semestreLeitor;
	}



	public String getNotaLeitor() {
		return notaLeitor;
	}



	public void setNotaLeitor(String notaLeitor) {
		this.notaLeitor = notaLeitor;
	}



	public int getFaltaLeitor() {
		return faltaLeitor;
	}



	public void setFaltaLeitor(int faltaLeitor) {
		this.faltaLeitor = faltaLeitor;
	}

	

}