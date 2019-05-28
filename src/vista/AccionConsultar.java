package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccionConsultar implements ActionListener {

	private Consultar cl;

	public AccionConsultar(Consultar cl) {
		this.cl = cl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.cl.getBtnMostrarAprobados().equals(e.getSource())) {

			Aprobados a = new Aprobados();
			a.setVisible(true);
			a.setBounds(350, 50, 586, 360);

			MetodosConsultar.conectar();

			try {

				Object tabla_aprobados[] = new Object[3];

				for (int i = 0; i < tabla_aprobados.length - 1; i++) {
					System.out.println(MetodosConsultar.seleccionarAprobados().get(i).getNombre_apellidos());
				}
				/**/

				try {
					if (MetodosConsultar.seleccionarAprobados().size() > 0) {
						for (int i = 0; i < tabla_aprobados.length; i++) {

							if (MetodosConsultar.seleccionarAprobados().get(i).getMedia() >= 5) {
								tabla_aprobados[0] = MetodosConsultar.seleccionarAprobados().get(i).getExpediente();
								tabla_aprobados[1] = MetodosConsultar.seleccionarAprobados().get(i)
										.getNombre_apellidos();
								tabla_aprobados[2] = MetodosConsultar.seleccionarAprobados().get(i).getMedia();
								((DefaultTableModel) a.getTabla_aprobados().getModel()).addRow(tabla_aprobados);
							}
						}
					} else
						JOptionPane.showMessageDialog(null, "NO HAY NINGUN APROBADO.");
				} catch (Exception f) {
					f.printStackTrace();
				} finally {
					try {
						MetodosConsultar.cerrar();
					} catch (Exception c) {
						c.printStackTrace();
					}
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}

}
