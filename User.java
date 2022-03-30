package model;

public class User {
	
	private int id;
	
	
	
	public User() {
		
	}
	
	
	
	
	public User(int id, String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksiEk,
			String mitaAsioita, String ammatti) {
		super();
		this.id = id;
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotipaikkakunta = kotipaikkakunta;
		this.ika = ika;
		this.miksiEk = miksiEk;
		this.mitaAsioita = mitaAsioita;
		this.ammatti = ammatti;
	}
	
	
	
	
	public User(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksiEk,
			String mitaAsioita, String ammatti) {
		super();
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotipaikkakunta = kotipaikkakunta;
		this.ika = ika;
		this.miksiEk = miksiEk;
		this.mitaAsioita = mitaAsioita;
		this.ammatti = ammatti;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	public int getIka() {
		return ika;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	public String getMiksiEk() {
		return miksiEk;
	}
	public void setMiksiEk(String miksiEk) {
		this.miksiEk = miksiEk;
	}
	public String getMitaAsioita() {
		return mitaAsioita;
	}
	public void setMitaAsioita(String mitaAsioita) {
		this.mitaAsioita = mitaAsioita;
	}
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksiEk;
	private String mitaAsioita;
	private String ammatti;
}
