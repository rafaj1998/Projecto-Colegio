package modelo;

public class AlumnoTabla {

	private String nombre;
	private String n_expediente;
	private double nota;
	private double media;
	private String asignatura;
	private String profesor;

	public AlumnoTabla() {
		this.nombre = "";
		this.n_expediente = "";
		this.nota = 0;
		this.asignatura = "";
		this.profesor = "";
	}

	public AlumnoTabla(String n_expediente, String nombre, double media) {
		this.n_expediente = n_expediente;
		this.nombre = nombre;
		this.media = media;
	}

	public AlumnoTabla(String nombre, double nota, String asignatura, String profesor) {
		this.nombre = nombre;
		this.nota = nota;
		this.asignatura = asignatura;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getProfesor() {
		return profesor;
	}

	public String getN_expediente() {
		return n_expediente;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public void setN_expediente(String n_expediente) {
		this.n_expediente = n_expediente;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "AlumnoTabla [nombre=" + nombre + ", n_expediente=" + n_expediente + ", nota=" + nota + ", media="
				+ media + ", asignatura=" + asignatura + ", profesor=" + profesor + "]";
	}
	
	


}
