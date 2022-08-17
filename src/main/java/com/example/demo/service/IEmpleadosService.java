package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Empleados;

public interface IEmpleadosService {

public List<Empleados> listarEmpleados(); //Listar All 
	
	public Empleados guardarEmpleado(Empleados empleado);	//Guarda un video CREATE
	
	public Empleados empleadoXID(Long codigo); //Leer datos de un video READ
	
	public Empleados actualizarEmpleado(Empleados empleado); //Actualiza datos del video UPDATE
	
	public void eliminarEmpleado(Long codigo);// Elimina el video DELETE
}
