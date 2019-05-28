package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Interfaz.
 *
 * @author Rafa & David
 * @version 1.0
 */
public class Interfaz extends JFrame {

	/** The panel. */
	private JPanel panel;

	/** The centro. */
	private JLabel centro;

	/** The icono. */
	private JLabel icono;

	/** The fondo. */
	private JLabel fondo;

	/** The bconsultar. */
	private JButton bconsultar;

	/** The balta. */
	private JButton balta;

	/** The bcalificar. */
	private JButton bcalificar;

	/**
	 * Constructor de la interfaz grafica principal.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Metodo del constructor que incluye los componentes de la interfaz.
	 */
	private void initialize() {
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		centro = new JLabel("I.E.S BARAJAS.");
		centro.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 60));
		centro.setBounds(40, 16, 531, 95);
		panel.add(centro);

		icono = new JLabel("");
		icono.addMouseListener(new AccionInterfaz(this));
		icono.setIcon(new ImageIcon(Interfaz.class.getResource("/imagenes/barajas.png")));
		icono.setToolTipText("https://aulavirtual32.educa.madrid.org/ies.barajas.madrid/login/index.php");
		icono.setBounds(191, 127, 207, 235);
		panel.add(icono);

		bconsultar = new JButton("Consultar");
		bconsultar.setToolTipText("Consultar información del alumno\r\n");
		bconsultar.addActionListener(new AccionInterfaz(this));
		bconsultar.setBounds(486, 409, 115, 42);
		panel.add(bconsultar);

		bcalificar = new JButton("Calificaciones");
		bcalificar.setToolTipText("Calificar al alumno\r\n");
		bcalificar.addActionListener(new AccionInterfaz(this));
		bcalificar.setBounds(243, 409, 127, 42);
		panel.add(bcalificar);

		balta = new JButton("Dar de Alta");
		balta.setToolTipText("Dar de alta a un alumno\r\n");
		balta.addActionListener(new AccionInterfaz(this));
		balta.setBounds(26, 409, 115, 42);
		panel.add(balta);

		fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Interfaz.class.getResource("/imagenes/fondo3.jpg")));
		fondo.setBounds(0, 0, 685, 494);
		panel.add(fondo);
	}

	/**
	 * Gets the bconsultar.
	 *
	 * @return the bconsultar
	 */
	public JButton getBconsultar() {
		return bconsultar;
	}

	/**
	 * Gets the balta.
	 *
	 * @return the balta
	 */
	public JButton getBalta() {
		return balta;
	}

	/**
	 * Gets the bcalificar.
	 *
	 * @return the bcalificar
	 */
	public JButton getBcalificar() {
		return bcalificar;
	}

	public JLabel getIcono() {
		return icono;
	}
	

}
