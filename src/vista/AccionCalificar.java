package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionCalificar.
 *
 * @author Rafa & David Clase que reacciona ante las acciones del boton de
 *         calificar.
 * @version 1.0
 */
public class AccionCalificar implements ActionListener {

	/** The c. */
	private Calificar c;

	/**
	 * Instantiates a new accion calificar.
	 *
	 * @param c the c
	 */
	public AccionCalificar(Calificar c) {
		this.c = c;
	}

	/**
	 * Metodo action performed que hace de oyente ante las acciones de los botones.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.c.getBcalificar().equals(e.getSource())) {

			if (this.c.getTexpediente().getText().isEmpty() || this.c.getTasignatura().getText().isEmpty()
					|| this.c.getTcalificacion().getText().isEmpty())
				JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			else {

				String expediente = this.c.getTexpediente().getText();
				String asignatura = this.c.getTasignatura().getText();
				int nota = 0;
				try {
					nota = Integer.parseInt(this.c.getTcalificacion().getText());

					MetodosCalificar.conectar();

					if (nota > 0 && nota <= 10) {
						MetodosCalificar.calificar(expediente, asignatura, nota);
						JOptionPane.showMessageDialog(null, "SE HA CALIFICADO EL ALUMNO SATISFACTORIAMENTE.");
					} else
						JOptionPane.showMessageDialog(null, "El valor de la nota debe ser un número entre 1-10.",
								"Error", JOptionPane.ERROR_MESSAGE);

					MetodosCalificar.cerrar();
				} catch (SQLException ex) {
					ex.printStackTrace();
				} catch (NumberFormatException l) {
					JOptionPane.showMessageDialog(null, "El campo de nota debe ser un número.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		}

	}

}
