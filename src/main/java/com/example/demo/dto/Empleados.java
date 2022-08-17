package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	
	@ManyToOne
    @JoinColumn(name="departamento")
    private Departamentos departamento;

	/**
	 * Constructor con parametros
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param departamento
	 */
	public Empleados(String dni, String nombre, String apellidos, Departamentos departamento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}

	/**
	 * Constructor sin parametros
	 */
	public Empleados() {
		
	}

	//Getters y Setters
	
	/**
	 * 
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @return departamento
	 */
	public Departamentos getDepartamento() {
		return departamento;
	}

	/**
	 * 
	 * @param departamento
	 */
	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	/**
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
