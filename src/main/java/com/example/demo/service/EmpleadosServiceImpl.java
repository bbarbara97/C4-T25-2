package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadosDAO;
import com.example.demo.dto.Empleados;


@Service
public class EmpleadosServiceImpl implements IEmpleadosService{

	
	@Autowired
	IEmpleadosDAO iEmpleadosDAO;
	
	@Override
	public List<Empleados> listarEmpleados() {
		
		return iEmpleadosDAO.findAll();
	}

	@Override
	public Empleados guardarEmpleado(Empleados empleado) {
		
		return iEmpleadosDAO.save(empleado);
	}

	@Override
	public Empleados empleadoXID(Long codigo) {
		return iEmpleadosDAO.findById(codigo).get();

	}

	@Override
	public Empleados actualizarEmpleado(Empleados empleado) {
		
		return iEmpleadosDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long codigo) {
		
		iEmpleadosDAO.deleteById(codigo);
		
	}
}
