package vista;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class Aprobados extends JFrame {

	private JTable tabla_aprobados;

	public Aprobados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setTitle("ALUMNOS APROBADOS.");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 61, 495, 247);
		this.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tabla_aprobados = new JTable();
		tabla_aprobados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA Expediente", "Nombre y Apellidos", "Media"
			}
		));
		scrollPane.setViewportView(tabla_aprobados);
		
		JLabel baprobados = new JLabel("ALUMNOS APROBADOS");
		baprobados.setFont(new Font("Tahoma", Font.BOLD, 16));
		baprobados.setBounds(175, 16, 255, 43);
		panel.add(baprobados);
	}

	public JTable getTabla_aprobados() {
		return tabla_aprobados;
	}

	public void setTabla_aprobados(JTable tabla_aprobados) {
		this.tabla_aprobados = tabla_aprobados;
	}
	
	

}
