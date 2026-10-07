package clases;

import persona.padre;

public class paciente  extends padre{
private String caso;
private String fecha;
private String doctor;
private String diagnostico = "";
private String receta = "";
public paciente(String dni, String nom, String apellido, int edad, String fecha, String doctor, String caso) {
	super(nom, dni, apellido, edad);
	this.caso = caso;
	this.fecha = fecha;
	this.doctor = doctor;
	
}
public String getCaso() {
	return caso;
}
public void setCaso(String caso) {
	this.caso = caso;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getDoctor() {
	return doctor;
}
public void setDoctor(String doctor) {
	this.doctor = doctor;
}
public String getDiagnostico() { return diagnostico; }
public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

public String getReceta() { return receta; }
public void setReceta(String receta) { this.receta = receta; }
}



