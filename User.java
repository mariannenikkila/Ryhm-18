package jspservletlopputyo.model;

public class User {
	private int EHDOKAS_ID;
	private String SUKUNIMI;
	private String ETUNIMI;
	private String PUOLUE;
	private String KOTIPAIKKAKUNTA;
	private int IKA;
	private String MIKSI_EDUSKUNTAAN;
	private String MITA_ASIOITA_HALUAISIT_EDISTAA;
	private String AMMATTI;
	
	
	public User(String sUKUNIMI, String eTUNIMI, String pUOLUE, String kOTIPAIKKAKUNTA, int iKA,
			String mIKSI_EDUSKUNTAAN, String mITA_ASIOITA_HALUAISIT_EDISTAA, String aMMATTI) {
		super();
		SUKUNIMI = sUKUNIMI;
		ETUNIMI = eTUNIMI;
		PUOLUE = pUOLUE;
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
		IKA = iKA;
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
		MITA_ASIOITA_HALUAISIT_EDISTAA = mITA_ASIOITA_HALUAISIT_EDISTAA;
		AMMATTI = aMMATTI;
	}
	public User(int eHDOKAS_ID, String sUKUNIMI, String eTUNIMI, String pUOLUE, String kOTIPAIKKAKUNTA, int iKA,
			String mIKSI_EDUSKUNTAAN, String mITA_ASIOITA_HALUAISIT_EDISTAA, String aMMATTI) {
		super();
		EHDOKAS_ID = eHDOKAS_ID;
		SUKUNIMI = sUKUNIMI;
		ETUNIMI = eTUNIMI;
		PUOLUE = pUOLUE;
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
		IKA = iKA;
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
		MITA_ASIOITA_HALUAISIT_EDISTAA = mITA_ASIOITA_HALUAISIT_EDISTAA;
		AMMATTI = aMMATTI;
	}
	public int getEHDOKAS_ID() {
		return EHDOKAS_ID;
	}
	public void setEHDOKAS_ID(int eHDOKAS_ID) {
		EHDOKAS_ID = eHDOKAS_ID;
	}
	public String getSUKUNIMI() {
		return SUKUNIMI;
	}
	public void setSUKUNIMI(String sUKUNIMI) {
		SUKUNIMI = sUKUNIMI;
	}
	public String getETUNIMI() {
		return ETUNIMI;
	}
	public void setETUNIMI(String eTUNIMI) {
		ETUNIMI = eTUNIMI;
	}
	public String getPUOLUE() {
		return PUOLUE;
	}
	public void setPUOLUE(String pUOLUE) {
		PUOLUE = pUOLUE;
	}
	public String getKOTIPAIKKAKUNTA() {
		return KOTIPAIKKAKUNTA;
	}
	public void setKOTIPAIKKAKUNTA(String kOTIPAIKKAKUNTA) {
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
	}
	public int getIKA() {
		return IKA;
	}
	public void setIKA(int iKA) {
		IKA = iKA;
	}
	public String getMIKSI_EDUSKUNTAAN() {
		return MIKSI_EDUSKUNTAAN;
	}
	public void setMIKSI_EDUSKUNTAAN(String mIKSI_EDUSKUNTAAN) {
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
	}
	public String getMITA_ASIOITA_HALUAISIT_EDISTAA() {
		return MITA_ASIOITA_HALUAISIT_EDISTAA;
	}
	public void setMITA_ASIOITA_HALUAISIT_EDISTAA(String mITA_ASIOITA_HALUAISIT_EDISTAA) {
		MITA_ASIOITA_HALUAISIT_EDISTAA = mITA_ASIOITA_HALUAISIT_EDISTAA;
	}
	public String getAMMATTI() {
		return AMMATTI;
	}
	public void setAMMATTI(String aMMATTI) {
		AMMATTI = aMMATTI;
	}
	
}
