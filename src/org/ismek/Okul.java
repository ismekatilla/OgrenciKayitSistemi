package org.ismek;

public class Okul extends TemelSinif {

	private int id;
	private String adi;
	
	public Okul() {}
	
	public Okul(int id, String adi) {
		this.id = id;
		this.adi = adi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi + " OKULU";
	}
	
	@Override
	public String toString() {
		// 1 - ABCDEF
		return id + " - " + adi;
	}
}