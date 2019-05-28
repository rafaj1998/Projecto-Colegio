package vista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.concurrent.locks.StampedLock;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MetodosAlta.
 */
public class MetodosAlta {

	/** The st. */
	private static PreparedStatement ps = null;
	private static Statement st = null;

	/** The rs. */
	private static ResultSet rs = null;

	/** The login. */
	private static String login = "java";// poner el nombre de la tabla.

	/** The pass. */
	private static String pass = "java";// poner la contraseña de la tabla.

	/** The bd. */
	private static String bd = "XE";

	/** The url. */
	private static String url = "jdbc:oracle:thin:@localhost:1521:" + bd;

	/** The conexion. */
	static Connection conexion;

	/**
	 * Conectar.
	 */
	public static void conectar() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, login, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (conexion != null)
			System.out.format("%s\n", "Se ha establecido la conexión con éxito.");
	}

	/**
	 * Insertar.
	 *
	 * @param nombre           the nombre
	 * @param apellidos        the apellidos
	 * @param dni              the dni
	 * @param direccion        the direccion
	 * @param localidad        the localidad
	 * @param expediente       the expediente
	 * @param fecha_nacimiento the fecha nacimiento
	 * @throws SQLException   the SQL exception
	 * @throws ParseException the parse exception
	 */

	public static boolean comprobarDNI(String dni) throws SQLException {
		String dniIgual = null;
		String selectDNI = "select dni from alumnos where dni = '" + dni + "'";
		st = conexion.createStatement();
		rs = st.executeQuery(selectDNI);
		while (rs.next()) {
			dniIgual = rs.getString("dni");
		}
		System.out.println(dniIgual);
		if (dniIgual.equalsIgnoreCase(dni))
			return true;
		else
			return false;
	}

	public static void insertar(String nombre, String apellidos, String dni, String direccion, String localidad,
			String expediente, Date fecha_nacimiento) throws SQLException, ParseException {

		if (!comprobarDNI(dni)) {
			ps = conexion.prepareStatement(
					"insert into alumnos (nombre, apellidos, dni, n_expediente ,fecha_nacimiento ,direccion,localidad) values('"
							+ nombre + "','" + apellidos + "','" + dni + "', '" + expediente + "',to_date('"
							+ fecha_nacimiento + "','yyyy-mm-dd'),'" + direccion + "','" + localidad + "' )");
		} else
			JOptionPane.showMessageDialog(null, "El DNI introducido ya existe.", "Error", JOptionPane.ERROR_MESSAGE);

		if (ps.executeUpdate() == 1) 
			System.out.format("%s\n", "ALUMNO INSERTADO CON ÉXITO.");
		

	}

	/**
	 * Cerrar.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void cerrar() throws SQLException {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conexion != null)
			conexion.close();

	}
}
