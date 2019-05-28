package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MetodosCalificar.
 */
public class MetodosCalificar {

	/** The st. */
	private static Statement st = null;
	private static PreparedStatement ps = null;

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
	 * Calificar.
	 *
	 * @param expediente the expediente
	 * @param asignatura the asignatura
	 * @param nota       the nota
	 * @throws SQLException the SQL exception
	 */

	public static String selectCodAsignatura(String asignatura) throws SQLException {
		String cod_asignatura = null;

		st = conexion.createStatement();
		rs = st.executeQuery("select	cod_asig from asignatura where upper(nombre) like upper('%'||'" + asignatura + "'||'%')");

		while (rs.next()) {
			cod_asignatura = rs.getString("cod_asig");
		}

		if (cod_asignatura != null)
			return cod_asignatura;
		return "No se ha encontrado el código de la asignatura";
	}

	public static void calificar(String expediente, String asignatura, int nota) throws SQLException {
	
		String cod_asignatura = selectCodAsignatura(asignatura);
		

		String update = "update calificaciones set nota = " + nota + " where cod_asig = '" + cod_asignatura
				+ "' and n_expediente = '" + expediente + "'";
		
		ps = conexion.prepareStatement(update);
		if (ps.executeUpdate() == 1) {// hace falta el execute si no no funcionara
			System.out.format("%s\n", "ALUMNO CALIFICADO CON EXITO.");
		}
		else {
			System.out.format("%s\n", "NO SE HA PODIDO CALIFICAR AL ALUMNO.");
		}
			

	}

	/**
	 * Cerrar.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void cerrar() throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (ps != null)
			ps.close();
		if (conexion != null)
			conexion.close();

	}
}
