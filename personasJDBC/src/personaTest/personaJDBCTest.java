package personaTest;

import java.util.List;

import personasJDBC.Persona;
import personasJDBC.PersonasJDBC;

public class personaJDBCTest {

	public static void main(String[] args) {
		PersonasJDBC per = new PersonasJDBC();
		//per.insert();
		//per.update(3, "javier", "martines");
		//per.delete(6);
		//per.select();
		List<Persona> personas = per.select();
		for(Persona pers : personas){
			System.out.println("id"+pers.getId_persona());
			System.out.println("nombre"+pers.getNombre());
			System.out.println("apellido"+pers.getApellido());
		}
	}

}
