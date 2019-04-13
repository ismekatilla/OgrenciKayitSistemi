package org.ismek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

	static ArrayList<Okul> okulList = new ArrayList<Okul>();
	static ArrayList<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean donguDevamEdiyor = true;
		do {
			
			MenuUtils.menuYazdir();
			System.out.print("Seçiminiz=");
			int secim = scanner.nextInt();
			switch (secim) {
			case 1:
				System.out.println("Okul tanımı yapılacak");
				
				System.out.print("Okul Id =");
				int okulId = scanner.nextInt();
				System.out.print("Okul Adı = ");
				String okulAdi = scanner.next();
				
				Okul okul = new Okul();
				okul.setId(okulId);
				okul.setAdi(okulAdi);
				okulList.add(okul);
				okulListele();
				break;
			case 2:
				System.out.println("Okul listele yapılacak");
				okulListele();
				break;
			case 3:
				System.out.println("Öğrenci tanımı yapılacak");
				
				okulListele();
				
				System.out.println("Öğrenci Numarası = ");
				int ogrenciNo = scanner.nextInt();
				
				System.out.println("Öğrenci Adı = ");
				String ogrenciAdi = scanner.next();
				
				
				System.out.println("Okul Id = ");
				int ogrenciOkulId = scanner.nextInt();
				Okul ogrencininOkulu = findOkulById(ogrenciOkulId);

				Ogrenci ogrenci = new Ogrenci();
				ogrenci.setNumara(ogrenciNo);
				ogrenci.setIsim(ogrenciAdi);
				ogrenci.setOkul(ogrencininOkulu);
				ogrenciList.add(ogrenci);
				
				break;
			case 4:
				System.out.println("Öğrenci listele yapılacak");
				for (Ogrenci ogrenciNesnesi : ogrenciList) {
					System.out.println(ogrenciNesnesi);
				}
				break;
			case 5:
				// Hangi okulda hangi öğrenciler var.
				HashMap<Okul,ArrayList<Ogrenci>> map = okuldaGoreOgrenciGrupla();
				for (Okul okulKey : map.keySet()) {
					ArrayList<Ogrenci> okuldakiOgrenciler = map.get(okulKey);
					System.out.println(okulKey.getAdi() + " ndaki öğrenci sayısı " + okuldakiOgrenciler.size());
				}
				break;
			case 6:
				System.out.println("Çıkış yapılacak");
				donguDevamEdiyor = false;
				break;
			default:
				break;
			}
		} while (donguDevamEdiyor);
	}
	
	private static HashMap<Okul, ArrayList<Ogrenci>> okuldaGoreOgrenciGrupla() {
		
		HashMap<Okul, ArrayList<Ogrenci>> map = new HashMap<Okul, ArrayList<Ogrenci>>();
		
		for (Okul okul : okulList) {
			
			ArrayList<Ogrenci> gruplanacakOgrenciList = new ArrayList<Ogrenci>();
			for (Ogrenci ogrenci : ogrenciList) {
				if (ogrenci.getOkul().getId() == okul.getId()) {
					gruplanacakOgrenciList.add(ogrenci);
				}
			}
		
			map.put(okul, gruplanacakOgrenciList);
		}
		return map;
	}

	private static void okulListele() {
		for (Okul okulNesnesi : okulList) {
			System.out.println(okulNesnesi);
		}
	}

	private static Okul findOkulById(int id) {
		for (Okul okul : okulList) {
			if (id == okul.getId()) {
				return okul;
			}
		}
		return null;
	}
}
