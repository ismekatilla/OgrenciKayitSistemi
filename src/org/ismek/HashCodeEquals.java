package org.ismek;

import java.util.ArrayList;
import java.util.HashSet;

public class HashCodeEquals {

	public static void main(String[] args) {
		
		Okul okul1 = new Okul(1, "ABC");
		Okul okul2 = new Okul(1, "ABC");
		
		HashSet<Okul> okulSet = new HashSet<Okul>();
		okulSet.add(okul1);
		okulSet.add(okul2);
		
		System.out.println("HashSet boyutu = " + okulSet.size());
		
		Okul aranacakOkul = new Okul(1, "ABC");
		boolean contains = okulSet.contains(aranacakOkul);
		System.out.println(contains);
		
		ArrayList<Okul> okulList = new ArrayList<Okul>();
		okulList.add(okul1);
		okulList.add(okul2);
		boolean okulVar = okulList.contains(aranacakOkul);
		System.out.println("Okul Liste içerisinde " + okulVar);
	}
}
