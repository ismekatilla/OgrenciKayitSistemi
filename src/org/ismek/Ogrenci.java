package org.ismek;

public class Ogrenci {

	private int numara;
	private String isim;
	private Okul okul;

	public int getNumara() {
		return numara;
	}

	public void setNumara(int numara) {
		this.numara = numara;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public Okul getOkul() {
		return okul;
	}

	public void setOkul(Okul okul) {
		this.okul = okul;
	}
	
	@Override
	public String toString() {
		return numara + " " + isim + " " + okul;
	}
}