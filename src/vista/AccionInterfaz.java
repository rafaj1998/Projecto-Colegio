package vista;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionInterfaz.
 *
 * @author Rafa & David
 * @version 1.0 Clase que recoje las acciones de los componentes de la interfaz
 *          principal.
 */

public class AccionInterfaz implements ActionListener, MouseListener {

	/** The v. */
	private Interfaz v;

	/**
	 * Instantiates a new accion interfaz.
	 *
	 * @param v Constructor que recibe un objeto interfaz para recojer los datos del
	 *          mismo mediante setters y getters.
	 */
	public AccionInterfaz(Interfaz v) {
		this.v = v;
	}
	
	

	/**
	 * Metodo unico de la interface ActionPerformed que hace de oyente ante las
	 * acciones de los componentes de la interfaz.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.v.getBalta().equals(e.getSource())) {
			Alta a = new Alta();
			a.setVisible(true);
			a.setBounds(400, 100, 700, 400);

		} else if (this.v.getBcalificar().equals(e.getSource())) {
			Calificar c = new Calificar();
			c.setVisible(true);
			c.setBounds(100, 100, 550, 300);

		} else if (this.v.getBconsultar().equals(e.getSource())) {

			Consultar cl = new Consultar();
			cl.setVisible(true);
			cl.setBounds(350, 50, 685, 520);

			try {
				MetodosConsultar.conectar();

				Object insertar_tabla[] = new Object[MetodosConsultar.seleccionar().size()];

				for (int i = 0; i < insertar_tabla.length; i++) {

					insertar_tabla[0] = MetodosConsultar.seleccionar().get(i).getNombre();

					insertar_tabla[1] = MetodosConsultar.seleccionar().get(i).getNota();

					insertar_tabla[2] = MetodosConsultar.seleccionar().get(i).getAsignatura();

					insertar_tabla[3] = MetodosConsultar.seleccionar().get(i).getProfesor();

					((DefaultTableModel) cl.getTabla_datos().getModel()).addRow(insertar_tabla);
				}

				MetodosConsultar.cerrar();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Desktop.getDesktop().browse(new URI("https://aulavirtual32.educa.madrid.org/ies.barajas.madrid/"));
		} catch (IOException e1) {
			Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, this.v.getIcono());

		} catch (URISyntaxException e1) {
			Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, this.v.getIcono());
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.v.getIcono().setCursor((Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		//this.v.getIcono().setCursor((Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//this.v.getIcono().setCursor((Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//this.v.getIcono().setCursor((Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)));
	}

}
