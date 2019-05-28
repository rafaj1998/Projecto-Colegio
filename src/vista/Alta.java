package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Alta.
 */
public class Alta extends JFrame {
	
	/** The panel. */
	private JPanel panel;
	
	/** The tnombre. */
	private JTextField tnombre;
	
	/** The tapellido. */
	private JTextField tapellido;
	
	/** The tdni. */
	private JTextField tdni;
	
	/** The texpediente. */
	private JTextField texpediente;
	
	/** The tnacimiento. */
	private JTextField tnacimiento;
	
	/** The tdireccion. */
	private JTextField tdireccion;
	
	/** The tlocalidad. */
	private JTextField tlocalidad;

	/** The nombre. */
	private JLabel nombre;
	
	/** The apellido. */
	private JLabel apellido;
	
	/** The dni. */
	private JLabel dni;
	
	/** The expediente. */
	private JLabel expediente;
	
	/** The f nacimiento. */
	private JLabel f_nacimiento;
	
	/** The direccion. */
	private JLabel direccion;
	
	/** The localidad. */
	private JLabel localidad;

	/** The banadir. */
	private JButton banadir;
	
	/** The blimpiar. */
	private JButton blimpiar;

	/**
	 * Instantiates a new alta.
	 */
	public Alta() {
		initialize();
	}

	/**
	 * Initialize.
	 */
	private void initialize() {
		this.setTitle("ALTA ALUMNO.");
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(Alta.class.getResource("/imagenes/barajas.png")));
		icono.setBounds(15, 201, 206, 128);
		panel.add(icono);

		nombre = new JLabel("Nombre:");
		nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		nombre.setBounds(51, 37, 83, 20);
		panel.add(nombre);

		apellido = new JLabel("Apellidos:");
		apellido.setFont(new Font("Tahoma", Font.BOLD, 16));
		apellido.setBounds(39, 89, 83, 20);
		panel.add(apellido);

		dni = new JLabel("DNI:");
		dni.setFont(new Font("Tahoma", Font.BOLD, 16));
		dni.setBounds(88, 143, 46, 20);
		panel.add(dni);

		expediente = new JLabel("N\u00BA Expediente:");
		expediente.setFont(new Font("Tahoma", Font.BOLD, 16));
		expediente.setBounds(312, 143, 137, 20);
		panel.add(expediente);

		f_nacimiento = new JLabel("Fecha Nacimiento:");
		f_nacimiento.setFont(new Font("Tahoma", Font.BOLD, 16));
		f_nacimiento.setBounds(287, 201, 162, 20);
		panel.add(f_nacimiento);

		direccion = new JLabel("Direccion:");
		direccion.setFont(new Font("Tahoma", Font.BOLD, 16));
		direccion.setBounds(355, 37, 94, 20);
		panel.add(direccion);

		localidad = new JLabel("Localidad:");
		localidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		localidad.setBounds(355, 89, 94, 20);
		panel.add(localidad);

		tnombre = new JTextField();
		tnombre.setBounds(149, 34, 146, 26);
		panel.add(tnombre);
		tnombre.setColumns(10);

		tapellido = new JTextField();
		tapellido.setToolTipText("Apellidos del alumno");
		tapellido.setBounds(149, 86, 146, 26);
		panel.add(tapellido);
		tapellido.setColumns(10);

		tdni = new JTextField();
		tdni.setToolTipText("DNI (8 números - 1 Letra)");
		tdni.setColumns(10);
		tdni.setBounds(149, 140, 146, 26);
		panel.add(tdni);

		texpediente = new JTextField();
		texpediente.setToolTipText("Expediente del alumno");
		texpediente.setColumns(10);
		texpediente.setBounds(464, 140, 146, 26);
		panel.add(texpediente);

		tnacimiento = new JTextField();
		tnacimiento.setToolTipText("fecha de nacimiento 'YYYY-MM-DD'");
		tnacimiento.setColumns(10);
		tnacimiento.setBounds(464, 198, 146, 26);
		panel.add(tnacimiento);

		tdireccion = new JTextField();
		tdireccion.setToolTipText("Direccion y domicilio");
		tdireccion.setColumns(10);
		tdireccion.setBounds(464, 34, 146, 26);
		panel.add(tdireccion);

		tlocalidad = new JTextField();
		tlocalidad.setToolTipText("Localidad");
		tlocalidad.setColumns(10);
		tlocalidad.setBounds(464, 86, 146, 26);
		panel.add(tlocalidad);

		banadir = new JButton("A\u00F1adir");
		banadir.addActionListener(new AccionAlta(this));
		banadir.setBounds(287, 285, 137, 44);
		panel.add(banadir);

		blimpiar = new JButton("Limpiar");
		blimpiar.addActionListener(new AccionAlta(this));
		blimpiar.setBounds(484, 285, 137, 44);
		panel.add(blimpiar);

	}

	/**
	 * Gets the tnombre.
	 *
	 * @return the tnombre
	 */
	public JTextField getTnombre() {
		return tnombre;
	}

	/**
	 * Gets the tapellido.
	 *
	 * @return the tapellido
	 */
	public JTextField getTapellido() {
		return tapellido;
	}

	/**
	 * Gets the tdni.
	 *
	 * @return the tdni
	 */
	public JTextField getTdni() {
		return tdni;
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
	 * Gets the tnacimiento.
	 *
	 * @return the tnacimiento
	 */
	public JTextField getTnacimiento() {
		return tnacimiento;
	}

	/**
	 * Gets the tdireccion.
	 *
	 * @return the tdireccion
	 */
	public JTextField getTdireccion() {
		return tdireccion;
	}

	/**
	 * Gets the tlocalidad.
	 *
	 * @return the tlocalidad
	 */
	public JTextField getTlocalidad() {
		return tlocalidad;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public JLabel getNombre() {
		return nombre;
	}

	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public JLabel getApellido() {
		return apellido;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public JLabel getDni() {
		return dni;
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
	 * Gets the f nacimiento.
	 *
	 * @return the f nacimiento
	 */
	public JLabel getF_nacimiento() {
		return f_nacimiento;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public JLabel getDireccion() {
		return direccion;
	}

	/**
	 * Gets the localidad.
	 *
	 * @return the localidad
	 */
	public JLabel getLocalidad() {
		return localidad;
	}

	/**
	 * Gets the banadir.
	 *
	 * @return the banadir
	 */
	public JButton getBanadir() {
		return banadir;
	}

	/**
	 * Gets the blimpiar.
	 *
	 * @return the blimpiar
	 */
	public JButton getBlimpiar() {
		return blimpiar;
	}

}
