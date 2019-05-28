package modelo;

public class AlumnoAprobado {

	private String expediente;
	private String nombre_apellidos;
	private double media;

	public AlumnoAprobado(String expediente, String nombre_apellidos, double media) {
		this.expediente = expediente;
		this.nombre_apellidos = nombre_apellidos;
		this.media = media;
	}

	public AlumnoAprobado() {
		this.expediente = "";
		this.nombre_apellidos = "";
		this.media = 0;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}

	public void setNombre_apellidos(String nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "AlumnoAprobado [expediente=" + expediente + ", nombre_apellidos=" + nombre_apellidos + ", media="
				+ media + "]";
	}

}
