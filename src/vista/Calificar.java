package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class Calificar.
 */
public class Calificar extends JFrame {
	
	/** The expediente. */
	private JLabel expediente;
	
	/** The asignatura. */
	private JLabel asignatura;
	
	/** The calificacion. */
	private JLabel calificacion;

	/** The texpediente. */
	private JTextField texpediente;
	
	/** The tasignatura. */
	private JTextField tasignatura;
	
	/** The tcalificacion. */
	private JTextField tcalificacion;

	/** The bcalificar. */
	private JButton bcalificar;

	/**
	 * Instantiates a new calificar.
	 */
	public Calificar() {
		initialize();
	}

	/**
	 * Initialize.
	 */
	private void initialize() {
		this.setTitle("HOJA DE CALIFICACIONES.");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		expediente = new JLabel("N\u00BA Expediente:");
		expediente.setFont(new Font("Tahoma", Font.BOLD, 16));
		expediente.setBounds(28, 27, 129, 20);
		panel.add(expediente);

		asignatura = new JLabel("Asignatura:");
		asignatura.setFont(new Font("Tahoma", Font.BOLD, 16));
		asignatura.setBounds(53, 86, 104, 20);
		panel.add(asignatura);

		calificacion = new JLabel("Calificacion:");
		calificacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		calificacion.setBounds(53, 143, 104, 20);
		panel.add(calificacion);

		texpediente = new JTextField();
		texpediente.setToolTipText("Introduzca el expediente del alumno");
		texpediente.setBounds(172, 24, 146, 26);
		panel.add(texpediente);
		texpediente.setColumns(10);

		tasignatura = new JTextField();
		tasignatura.setToolTipText("Introduzca la asignatura a calificar");
		tasignatura.setColumns(10);
		tasignatura.setBounds(172, 83, 146, 26);
		panel.add(tasignatura);

		tcalificacion = new JTextField();
		tcalificacion.setToolTipText("Introduzca la calificacion obtenida");
		tcalificacion.setColumns(10);
		tcalificacion.setBounds(172, 140, 146, 26);
		panel.add(tcalificacion);

		bcalificar = new JButton("Calificar");
		bcalificar.addActionListener(new AccionCalificar(this));
		bcalificar.setBounds(127, 193, 115, 45);
		panel.add(bcalificar);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(Calificar.class.getResource("/imagenes/barajas.png")));
		icono.setBounds(326, 86, 199, 136);
		panel.add(icono);

		/*
		 * frame = new JFrame(); frame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); public static void
		 * main(String[] args) { EventQueue.invokeLater(new Runnable() { public void
		 * run() { try { Calificar window = new Calificar();
		 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
		 * } }); }
		 */
	}

	/**
	 * Gets the expediente.
	 *
	 * @return the expediente
	 */
	public JLabel getExpediente() {
		return expediente;
	}

	/**
	 * Gets the asignatura.
	 *
	 * @return the asignatura
	 */
	public JLabel getAsignatura() {
		return asignatura;
	}

	/**
	 * Gets the calificacion.
	 *
	 * @return the calificacion
	 */
	public JLabel getCalificacion() {
		return calificacion;
	}

	/**
	 * Gets the texpediente.
	 *
	 * @return the texpediente
	 */
	public JTextField getTexpediente() {
		return texpediente;
	}

	/**
	 * Gets the tasignatura.
	 *
	 * @return the tasignatura
	 */
	public JTextField getTasignatura() {
		return tasignatura;
	}

	/**
	 * Gets the tcalificacion.
	 *
	 * @return the tcalificacion
	 */
	public JTextField getTcalificacion() {
		return tcalificacion;
	}

	/**
	 * Gets the bcalificar.
	 *
	 * @return the bcalificar
	 */
	public JButton getBcalificar() {
		return bcalificar;
	}

}
