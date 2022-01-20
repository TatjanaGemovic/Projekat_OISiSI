package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesoriNaPredmetuJTable extends JTable{

	private static final long serialVersionUID = -7746685161794756486L;
	private static JTable tabelaProfesora;
	public static int rowSelectedIndex = -1;
	public static AbstractTableModelProfesori2 profesorModel;
	
	public ProfesoriNaPredmetuJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori2());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		this.profesorModel = new AbstractTableModelProfesori2();
		
		profesorModel = (AbstractTableModelProfesori2) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaProfesora = (ProfesoriNaPredmetuJTable) e.getComponent();
				if(tabelaProfesora.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());
				}

			}
		});
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if(isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public static void azurirajPrikaz() {
		profesorModel.fireTableDataChanged();
	}
	
}

class ProfesoriNaKatedriJTable extends JTable{

	private static final long serialVersionUID = -7746685161794756486L;
	private static JTable tabelaProfesora;
	public static int rowSelectedIndex = -1;
	public static AbstractTableModelProfesori4 profesorModel;
	
	public ProfesoriNaKatedriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesori4());
		this.setShowHorizontalLines(false);
		this.setShowVerticalLines(false);
		this.setGridColor(Color.LIGHT_GRAY);
		
		profesorModel = (AbstractTableModelProfesori4) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaProfesora = (ProfesoriNaPredmetuJTable) e.getComponent();
				if(tabelaProfesora.getSelectedRow()!=-1) {
					rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());
				}

			}
		});
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if(isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public static void azurirajPrikaz() {
		profesorModel.fireTableDataChanged();
	}
	
}
