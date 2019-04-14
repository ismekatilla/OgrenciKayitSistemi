package org.ismek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VeriTabaniIslemleri {

	public static void main(String[] args) {
		okulEkle();
		okullariListele();
	}

	private static void okulEkle() {
		
		int okulId = 6;
		String okulAdi = "İSMEK BİLİŞİM OKULLARI";
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java1?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", 
					"root", 
					"1234");
			String sorgu = "insert into okul (id, adi) values (?, ?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setInt(1, okulId);
			prepareStatement.setString(2, okulAdi);
			
			prepareStatement.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		System.out.println("Kayıt eklendi");
	}

	private static void okullariListele() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java1?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", 
					"root", 
					"1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from okul");
			while (rs.next()) {
				int okulId = rs.getInt(1);
				String okulAdi = rs.getString(2);
				System.out.println(okulId + "  " + okulAdi);
			}
				
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
	}
	
//	public static void main(String[] args) {
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver"); 
//		} catch (Exception e) {
//			System.out.println();
//		}
//		
//		try (Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/java1?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", 
//				"root", 
//				"1234")) {
//			
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from okul");
//			while (rs.next()) {
//				int okulId = rs.getInt(1);
//				String okulAdi = rs.getString(2);
//				System.out.println(okulId + "  " + okulAdi);
//			}
//				
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}
