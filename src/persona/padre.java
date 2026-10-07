package persona;

public class padre {
private String nom, dni, apellido;
private int edad;
public padre(String nom, String dni, String apellido, int edad) {
	this.nom = nom;
	this.dni = dni;
	this.apellido = apellido;
	this.edad = edad;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}


}

