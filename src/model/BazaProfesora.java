package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BazaProfesora extends AbstractTableModel{

	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	public List<String> kolone;
	
	public BazaProfesora() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Zvanje");
		
		initProfesori();
	}
	
	private void initProfesori() {
		this.profesori = new ArrayList<Profesor>();
		@SuppressWarnings("deprecation")
		Date datum = new Date(1970, 25, 04);
		Adresa adresa1 = new Adresa("Futoska", "9", "Novi Sad", "Srbija");
		Adresa adresa2 = new Adresa("NTP", "kabinet 3", "Novi Sad", "Srbija");
		profesori.add(new Profesor("Milan", "Rapaic", datum, adresa1, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15));
	}
	
	
	@Override
	public int getColumnCount() {
		 return 3;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}
	
	private List<Profesor> getProfesori() {
		return profesori;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	@Override
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
			case 0:
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return profesor.getZvanje();
			default:
				return null;
		}
	}
	
	public void dodajProfesora(String ime, String prezime, Date datum_rodjenja, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String broj_licne_karte, String zvanje, int godine_staza) {
		
		this.profesori.add(new Profesor(ime,prezime,datum_rodjenja,adresa,kontakt_tel,email,adresa_kancelarije,broj_licne_karte,zvanje,godine_staza));
	}
	
	public void izmeniProfesora(String licna_karta, Adresa adresa, String kontakt_tel, String email,
			Adresa adresa_kancelarije, String zvanje, int godine_staza) {
		
		for (Profesor i : profesori) {
			if(i.getBroj_licne_karte().equals(licna_karta)) {
				int index = profesori.indexOf(i);
				i.setAdresa(adresa);
				i.setKontakt_tel(kontakt_tel);
				i.setEmail(email);
				i.setAdresa_kancelarije(adresa_kancelarije);
				i.setZvanje(zvanje);
				i.setGodine_staza(godine_staza);
				profesori.set(index, i);
				break;
			}
		}
	}
	
	public void izbrisiProfesora(String licna_karta) {
		for (Profesor i : profesori) {
			if (i.getBroj_licne_karte().equals(licna_karta)) {
				profesori.remove(i);
				break;
			}
		}
	}

}
