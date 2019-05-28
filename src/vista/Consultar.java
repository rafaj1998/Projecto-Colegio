package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Consultar.
 */
public class Consultar extends JFrame {

	/** The table. */
	private JTable tabla_datos;
	private JButton btnMostrarAprobados;

	/**
	 * Instantiates a new consultar.
	 */
	public Consultar() {
		initialize();
	}

	/**
	 * Initialize.
	 */
	private void initialize() {

		this.setTitle("INFORMACION GENERAL.");
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 90, 639, 333);
		panel.add(scrollPane);

		tabla_datos = new JTable();
		tabla_datos.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Alumno", "Nota", "Asignatura", "Profesor" }));
		scrollPane.setViewportView(tabla_datos);

		JLabel datos = new JLabel("DATOS GENERALES");
		datos.setFont(new Font("Tahoma", Font.BOLD, 25));
		datos.setBounds(175, 31, 255, 43);
		panel.add(datos);

		btnMostrarAprobados = new JButton("Mostrar Aprobados");
		btnMostrarAprobados.setToolTipText("Mostrar a los alumnos aprobados");
		btnMostrarAprobados.addActionListener(new AccionConsultar(this));
		btnMostrarAprobados.setBounds(253, 426, 177, 37);
		panel.add(btnMostrarAprobados);
	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */

	public JTable getTabla_datos() {
		return tabla_datos;
	}

	public void setTabla_datos(JTable tabla_datos) {
		this.tabla_datos = tabla_datos;
	}

	public JButton getBtnMostrarAprobados() {
		return btnMostrarAprobados;
	}

	public void setBtnMostrarAprobados(JButton btnMostrarAprobados) {
		this.btnMostrarAprobados = btnMostrarAprobados;
	}

}
