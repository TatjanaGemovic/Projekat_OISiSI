package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorKontroler;
import controller.StudentKontroler;
import model.Adresa;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.Status_Studenta;
import model.Student;

public class DijalogDodavanjaProfesora extends JDialog{

	public DijalogDodavanjaProfesora(Frame parent, String title, boolean modal) {
		super(parent, "Dodavanje Profesora", modal);
		
		Dimension parentSize = parent.getSize();
		int diaWidth = parentSize.width;
		int diaHeight = parentSize.height;
		setSize(diaWidth*3/5, diaHeight*15/20);
		setLocationRelativeTo(parent);
		
		JButton potvrda=new JButton("Potvrdi");
		GridBagConstraints gbcPotvrda = new GridBagConstraints();
		gbcPotvrda.fill = GridBagConstraints.HORIZONTAL;
		gbcPotvrda.gridx = 0;
		gbcPotvrda.gridy = 10;
		gbcPotvrda.insets = new Insets(30, 190, 0,0);
		
		JButton odustanak=new JButton("Odustani");
		GridBagConstraints gbcOdustanak = new GridBagConstraints();
		gbcOdustanak.fill = GridBagConstraints.HORIZONTAL;
		gbcOdustanak.gridx = 1;
		gbcOdustanak.gridy = 10;
		gbcOdustanak.insets = new Insets(30,30, 0,230);
		odustanak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			int dialogButton = JOptionPane.YES_NO_OPTION;
			           int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			           if (dialogResult == JOptionPane.YES_OPTION) {
			        	   dispose();
			           }
			             
				}
			});
		
	    JPanel panelCenter = new JPanel();
	    panelCenter.setLayout(new GridBagLayout());
	    this.add(panelCenter, BorderLayout.CENTER);
	    
	    panelCenter.add(potvrda, gbcPotvrda);
	    panelCenter.add(odustanak, gbcOdustanak);
	    
	    JLabel lblIme = new JLabel("Ime:");
	    JLabel lblPrezime = new JLabel("Prezime:");
	    JLabel lblDatumRodjenja = new JLabel("Datum rodjenja:");
	    JLabel lblAdresa = new JLabel("Adresa stanovanja:");
	    JLabel lblTelefon = new JLabel("Broj telefona:");
	    JLabel lblEmailAdresa = new JLabel("Email adresa:");
	    JLabel lblAdresaKancelarije= new JLabel("Adresa kancelarije:");
	    JLabel lblBrLicneKarte = new JLabel("Broj Licne Karte:");
	    JLabel lblZvanje = new JLabel("Zvanje:");
	    JLabel lblGodineStaza = new JLabel("Godine staza:");
	    
	    final JTextField txtIme = new JTextField();
	    final JTextField txtPrezime = new JTextField();
	    final JTextField txtDatumRodjenja = new JTextField();
	    final JTextField txtAdresa = new JTextField();
	    final JTextField txtTelefon = new JTextField();
	    final JTextField txtEmailAdresa = new JTextField();
	    final JTextField txtAdresaKancelarije = new JTextField();
	    final JTextField txtBrLicneKarte = new JTextField();
	    final JTextField txtZvanje = new JTextField();
	    final JTextField txtGodineStaza = new JTextField();

	    
	    GridBagConstraints gbcLblIme = new GridBagConstraints();
	    gbcLblIme.gridx = 0;
	    gbcLblIme.gridy = 0;
	    gbcLblIme.insets = new Insets(10, 30, 0,64);
	    panelCenter.add(lblIme, gbcLblIme);


	    GridBagConstraints gbcLblPrezime = new GridBagConstraints();
	    gbcLblPrezime.gridx = 0;
	    gbcLblPrezime.gridy = 1;
	    gbcLblPrezime.insets = new Insets(10, 30, 0,40);
	    panelCenter.add(lblPrezime, gbcLblPrezime);


	    GridBagConstraints gbcLbDatumRodjennja = new GridBagConstraints();
	    gbcLbDatumRodjennja.gridx = 0;
	    gbcLbDatumRodjennja.gridy = 2;
	    gbcLbDatumRodjennja.insets = new Insets(10, 40, 0,2);
	    panelCenter.add(lblDatumRodjenja, gbcLbDatumRodjennja);


	    GridBagConstraints gbcLbAdresa = new GridBagConstraints();
	    gbcLbAdresa.gridx = 0;
	    gbcLbAdresa.gridy = 3;
	    gbcLbAdresa.insets = new Insets(10, 56, 0,0);
	    panelCenter.add(lblAdresa, gbcLbAdresa);


	    GridBagConstraints gbcLbTelefon = new GridBagConstraints();
	    gbcLbTelefon.gridx = 0;
	    gbcLbTelefon.gridy = 4;
	    gbcLbTelefon.insets = new Insets(10, 40, 0,20);
	    panelCenter.add(lblTelefon, gbcLbTelefon);
	    
	    GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
	    gbcLblEmailAdresa.gridx = 0;
	    gbcLblEmailAdresa.gridy = 5;
	    gbcLblEmailAdresa.insets = new Insets(10, 40, 0,20);
	    panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);
	    
	    GridBagConstraints gbcLblAdresaKancelarije = new GridBagConstraints();
	    gbcLblAdresaKancelarije.gridx = 0;
	    gbcLblAdresaKancelarije.gridy = 6;
	    gbcLblAdresaKancelarije.insets = new Insets(10, 56, 0,0);
	    panelCenter.add(lblAdresaKancelarije, gbcLblAdresaKancelarije);
	    
	    GridBagConstraints gbcLblBrLicneKarte = new GridBagConstraints();
	    gbcLblBrLicneKarte.gridx = 0;
	    gbcLblBrLicneKarte.gridy = 7;
	    gbcLblBrLicneKarte.insets = new Insets(10, 38, 0,0);
	    panelCenter.add(lblBrLicneKarte, gbcLblBrLicneKarte);
	    
	    GridBagConstraints gbcLblZvanje = new GridBagConstraints();
	    gbcLblZvanje.gridx = 0;
	    gbcLblZvanje.gridy = 8;
	    gbcLblZvanje.insets = new Insets(10, 20, 0,40);
	    panelCenter.add(lblZvanje, gbcLblZvanje);
	    
	    GridBagConstraints gbcLblGodineStaza = new GridBagConstraints();
	    gbcLblGodineStaza.gridx = 0;
	    gbcLblGodineStaza.gridy = 9;
	    gbcLblGodineStaza.insets = new Insets(10, 45, 0,25);
	    panelCenter.add(lblGodineStaza, gbcLblGodineStaza);
	    
	    
	    
	    
	    GridBagConstraints gbcTxtIme = new GridBagConstraints();
	    gbcTxtIme .gridx = 1;
	    gbcTxtIme .gridy = 0;
	    gbcTxtIme .weightx = 100;
	    gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtIme .insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtIme, gbcTxtIme );

	    GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
	    gbcTxtPrezime .gridx = 1;
	    gbcTxtPrezime .gridy = 1;
	    gbcTxtPrezime .weightx = 100;
	    gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtPrezime .insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtPrezime, gbcTxtPrezime );

	    GridBagConstraints gbcTxtDatum = new GridBagConstraints();
	    gbcTxtDatum .gridx = 1;
	    gbcTxtDatum .gridy = 2;
	    gbcTxtDatum .weightx = 100;
	    gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtDatum.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
	    
	    GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
	    gbcTxtAdresa .gridx = 1;
	    gbcTxtAdresa .gridy = 3;
	    gbcTxtAdresa .weightx = 100;
	    gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresa.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtAdresa, gbcTxtAdresa );
	    
	    GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
	    gbcTxtTelefon .gridx = 1;
	    gbcTxtTelefon .gridy = 4;
	    gbcTxtTelefon .weightx = 100;
	    gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtTelefon.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtTelefon, gbcTxtTelefon );
	    
	    GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
	    gbcTxtEmailAdresa .gridx = 1;
	    gbcTxtEmailAdresa .gridy = 5;
	    gbcTxtEmailAdresa .weightx = 100;
	    gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtEmailAdresa .insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
	    
	    GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
	    gbcTxtAdresaKancelarije .gridx = 1;
	    gbcTxtAdresaKancelarije .gridy = 6;
	    gbcTxtAdresaKancelarije .weightx = 100;
	    gbcTxtAdresaKancelarije.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtAdresaKancelarije.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije );
	    
	    GridBagConstraints gbcTxtBrLicneKarte = new GridBagConstraints();
	    gbcTxtBrLicneKarte .gridx = 1;
	    gbcTxtBrLicneKarte .gridy = 7;
	    gbcTxtBrLicneKarte .weightx = 100;
	    gbcTxtBrLicneKarte.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtBrLicneKarte.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtBrLicneKarte, gbcTxtBrLicneKarte );
	    
	    GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
	    gbcTxtZvanje .gridx = 1;
	    gbcTxtZvanje .gridy = 8;
	    gbcTxtZvanje .weightx = 100;
	    gbcTxtZvanje.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtZvanje.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtZvanje, gbcTxtZvanje );
	    
	    GridBagConstraints gbcTxtGodineStaza = new GridBagConstraints();
	    gbcTxtGodineStaza .gridx = 1;
	    gbcTxtGodineStaza .gridy = 9;
	    gbcTxtGodineStaza .weightx = 100;
	    gbcTxtGodineStaza.fill = GridBagConstraints.HORIZONTAL;
	    gbcTxtGodineStaza.insets = new Insets(10, 120, 0, 70);
	    panelCenter.add(txtGodineStaza, gbcTxtGodineStaza);
	    
	    potvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
			    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da u bazu dodajete profesora sa unetim podacima?", "Potvrda unosa", dialogButton);
			    	
			    if (dialogResult == JOptionPane.YES_OPTION) {
			    	if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmailAdresa.getText().isEmpty() || txtAdresaKancelarije.getText().isEmpty() || txtBrLicneKarte.getText().isEmpty() || txtZvanje.getText().isEmpty() || txtGodineStaza.getText().isEmpty()) {
			    		
			    		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Sva polja moraju biti popunjena", "Greska", JOptionPane.ERROR_MESSAGE);
			    		return;
			    	}
			    	
			    	String brojLicneKarte = txtBrLicneKarte.getText();
			    	for(Profesor i : BazaProfesora.getInstance().getProfesori()) {
			    		if(i.getBroj_licne_karte().equals(brojLicneKarte)) {
			    			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Vec postoji profesor sa datim brojem licne karte: " + brojLicneKarte);
			    			return;
			    		}
			    	}
			    	String ime = txtIme.getText();
			    	String prezime = txtPrezime.getText();
			    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			    	Date datumRodjenja = new Date();
			    	try {
						datumRodjenja =  formatter.parse(txtDatumRodjenja.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
			    	String adresaStr = txtAdresa.getText();
			    	String[] adresa_split = adresaStr.split(",");
			    	Adresa adresa = new Adresa(adresa_split[0], adresa_split[1], adresa_split[2], adresa_split[3]);
			    	String telefon = txtTelefon.getText();
			    	String mail = txtEmailAdresa.getText();
			    	adresaStr = txtAdresaKancelarije.getText();
			    	adresa_split = adresaStr.split(",");
			    	Adresa adresa2 = new Adresa(adresa_split[0], adresa_split[1], adresa_split[2], adresa_split[3]);
			    	String brLicneKarte = txtBrLicneKarte.getText();
			    	String zvanje = txtZvanje.getText();
			    	int god_staza = Integer.parseInt(txtGodineStaza.getText());
			    	ProfesorKontroler.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresa, telefon, mail, adresa2, brLicneKarte, zvanje, god_staza);
			    	dispose();
			    }	
			}
			
		});
	}
	
	
}
