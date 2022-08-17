package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Departamentos;

public interface IDepartamentosService {

	public List<Departamentos> listarDepartamentos(); //Listar All 
	
	public Departamentos guardarDepartamento(Departamentos departamentos);	//Guarda un video CREATE
	
	public Departamentos departamentosXID(Long id); //Leer datos de un video READ
	
	public Departamentos actualizarDepartamento(Departamentos departamentos); //Actualiza datos del video UPDATE
	
	public void eliminarDepartamento(Long id);// Elimina el video DELETE
}
