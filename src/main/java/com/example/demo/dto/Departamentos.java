package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="departamentos")
public class Departamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long codigo;
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;
	@Column(name = "presupuesto")//no hace falta si se llama igual
	private int presupuesto;
    @OneToMany
    @JoinColumn(name="dni")
    private List<Empleados> empleados;
    
    /**
     * 
     * @param codigo
     * @param nombre
     * @param presupuesto
     * @param empleados
     */
	public Departamentos(Long codigo, String nombre, int presupuesto, List<Empleados> empleados) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.empleados = empleados;
	}
    
	/**
	 * Constructor sin parametros
	 */
	public Departamentos() {

	}

	//Getters y Setters
	
	/**
	 * 
	 * @return codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	 * @return presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}

	/**
	 * 
	 * @param presupuesto
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * 
	 * @return empleados
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleados")
	public List<Empleados> getEmpleados() {
		return empleados;
	}

	/**
	 * 
	 * @param empleados
	 */
	public void setEmpleados(List<Empleados> empleados) {
		this.empleados = empleados;
	}

	/**
	 * Metodo toString
	 */
	@Override
	public String toString() {
		return "Departamentos [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto
				+ ", empleados=" + empleados + "]";
	}
    
	
    
}
