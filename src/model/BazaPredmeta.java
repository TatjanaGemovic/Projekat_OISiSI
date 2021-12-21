package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import gui.PredmetiJTable;

public class BazaPredmeta{

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	public List<String> kolone;
	
	public BazaPredmeta() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		
		initPredmeti();
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
		Semestar semestar = Semestar.zimski;
		Date datum = new Date(1970, 25, 04);
		Adresa adresa1 = new Adresa("Futoska", "9", "Novi Sad", "Srbija");
		Adresa adresa2 = new Adresa("NTP", "kabinet 3", "Novi Sad", "Srbija");
		Profesor p = new Profesor("Milan", "Rapaic", datum, adresa1, "0693792839", "rapaicmilan@gmail.com", adresa2, "00081525", "Doktor", 15);
		predmeti.add(new Predmet("E2 105", "Analiza1", semestar, 1, p, 9));
	}
	
	
	public int getColumnCount() {
		 return 5;
	}

	public int getRowCount() {
		return 40;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if(row < predmeti.size()) {
			Predmet predmet = this.predmeti.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra_predmeta();
			case 1:
				return predmet.getNaziv();
			case 2:
				return Integer.toString(predmet.getEspb());
			case 3:
				return Integer.toString(predmet.getGodina_izvodjenja());
			case 4:
				return predmet.getSemestar().toString();
			default:
				return null;
			}
		} else {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			default:
				return null;
		}
		}
	}
	
	public void dodajPredmet(String sifra_predmeta, String naziv, Semestar semestar, int godina_izvodjenja, Profesor profesor, int espb) {
			this.predmeti.add(new Predmet(sifra_predmeta,naziv,semestar,godina_izvodjenja,profesor,espb));
	}
	public void izmeniPredmet(String sifra_predmeta, String naziv, int espb, int godina, Semestar semestar, Profesor profesor) {
		for (Predmet i : predmeti) {
			if (i.getSifra_predmeta().equals(sifra_predmeta)) {
				int index = predmeti.indexOf(i);
				i.setNaziv(naziv);
				i.setEspb(espb);
				i.setGodina_izvodjenja(godina);
				i.setSemestar(semestar);
				i.setPredmetni_profesor(profesor);
				predmeti.set(index, i);
				break;
			}
		}
	}
	public void izbrisiPredmet(String sifra_predmeta) {
		for (Predmet i : predmeti) {
			if (i.getSifra_predmeta().equals(sifra_predmeta)) {
				predmeti.remove(i);
				break;
			}
		}
	}

}