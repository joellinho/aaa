package personasJDBC;

/**
 * @author aarons
 *
 */
public class Persona {
private int id_persona;
private String nombre;
private String apellido;


public Persona() {
	super();
}



public Persona(int id_persona) {
	super();
	this.id_persona = id_persona;
}



public Persona(int id_persona, String nombre, String apellido) {
	super();
	this.id_persona = id_persona;
	this.nombre = nombre;
	this.apellido = apellido;
}


public int getId_persona() {
	return id_persona;
}


public void setId_persona(int id_persona) {
	this.id_persona = id_persona;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido() {
	return apellido;
}


public void setApellido(String apellido) {
	this.apellido = apellido;
}


@Override
public String toString() {
	return "Persona [id_persona=" + id_persona + ", nombre=" + nombre + ", apellido=" + apellido + "]";
}



}
