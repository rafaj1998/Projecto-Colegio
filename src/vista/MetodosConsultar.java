package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.AlumnoAprobado;
import modelo.AlumnoTabla;

// TODO: Auto-generated Javadoc
/**
 * Clase MetodosConsultar.
 */
public class MetodosConsultar {

	/** The st. */
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

	public static List<AlumnoAprobado> seleccionarAprobados() throws SQLException {
		st = conexion.createStatement();

		String n_expediente;
		String nombre;
		double media;

		String select_aprobados = "select alumnos.n_expediente as alumnos, nombre, apellidos, round(avg(nota),2) as media from alumnos join calificaciones on alumnos.n_expediente = calificaciones.n_expediente group by alumnos.n_expediente, nombre, apellidos";
		List<AlumnoAprobado> alumnos = new ArrayList<AlumnoAprobado>();
		rs = st.executeQuery(select_aprobados);

		while (rs.next()) {
			AlumnoAprobado a = new AlumnoAprobado();
			n_expediente = rs.getString("alumnos");
			a.setExpediente(n_expediente);
			nombre = rs.getString("nombre") + ", " + rs.getString("apellidos");
			a.setNombre_apellidos(nombre);
			media = rs.getDouble("media");
			a.setMedia(media);
			alumnos.add(a);
		}
		return alumnos;
	}

	/**
	 * Seleccionar.
	 *
	 * @return the alumno
	 * @throws SQLException the SQL exception
	 */

	public static List<AlumnoTabla> seleccionar() throws SQLException {
		st = conexion.createStatement();

		String nombre;
		String apellidos;
		double nota;
		String asignatura;
		String profesor;

		String select_join = "select al.nombre as alumno, al.apellidos as alumno_apellidos, nota, asig.nombre as asignatura, p.nombre as profesor from alumnos al join calificaciones c on al.n_expediente = c.n_expediente join asignatura asig on c.cod_asig = asig.cod_asig join profesores p on asig.cod_prof = p.cod_prof";
		List<AlumnoTabla> alumnos = new ArrayList<AlumnoTabla>();
		rs = st.executeQuery(select_join);

		while (rs.next()) {
			AlumnoTabla a = new AlumnoTabla();
			nombre = rs.getString("alumno");
			apellidos = rs.getString("alumno_apellidos");
			a.setNombre(nombre + ", " + apellidos);
			nota = rs.getDouble("nota");
			a.setNota(nota);
			asignatura = rs.getString("asignatura");
			a.setAsignatura(asignatura);
			profesor = rs.getString("profesor");
			a.setProfesor(profesor);
			alumnos.add(a);
		}
		return alumnos;
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
		if (conexion != null)
			conexion.close();

	}

}
