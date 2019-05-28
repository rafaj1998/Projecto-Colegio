package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionAlta.
 */
public class AccionAlta implements ActionListener {

	/** The a. */
	private Alta a;

	/**
	 * Instantiates a new accion alta.
	 *
	 * @param a the a
	 */
	public AccionAlta(Alta a) {
		this.a = a;
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.a.getBanadir().equals(e.getSource())) {

			if (this.a.getTnombre().getText().isEmpty() || this.a.getTapellido().getText().isEmpty()
					|| this.a.getTdni().getText().isEmpty() || this.a.getTexpediente().getText().isEmpty()
					|| this.a.getTnacimiento().getText().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String nombre = this.a.getTnombre().getText();
				String apellidos = this.a.getTapellido().getText();

				String direccion = this.a.getTdireccion().getText();
				String localidad = this.a.getTlocalidad().getText();
				String expediente = this.a.getTexpediente().getText();
				Date fecha_nacimiento = null;
				// Recordar que el DATE de SQL espera un formato de fecha "yyyy-MM-dd" o lanzara
				// una exception IllegalArgumentException

				try {
					String dni = this.a.getTdni().getText();
					Pattern patronDNI = Pattern.compile("([0-9]{8}[A-Za-z])");
					Matcher pruebaDNI = patronDNI.matcher(dni);
					fecha_nacimiento = Date.valueOf(this.a.getTnacimiento().getText());
					MetodosAlta.conectar();
					if (pruebaDNI.matches())
						MetodosAlta.insertar(nombre, apellidos, dni, direccion, localidad, expediente,
								fecha_nacimiento);
					else {
						JOptionPane.showMessageDialog(null,
								"El campo del DNI debe tener un formato válido.(8 Numeros, 1 Letra)", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (ParseException fecha) {
					JOptionPane.showMessageDialog(null, "El campo de fecha debe tener un formato válido. YYYY-MM-DD",
							"Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					
				}

			}

		} else if (this.a.getBlimpiar().equals(e.getSource())) {
			this.a.getTnombre().setText("");
			this.a.getTapellido().setText("");
			this.a.getTdni().setText("");
			this.a.getTdireccion().setText("");
			this.a.getTlocalidad().setText("");
			this.a.getTnacimiento().setText("");
			this.a.getTexpediente().setText("");
		}
	}

}
