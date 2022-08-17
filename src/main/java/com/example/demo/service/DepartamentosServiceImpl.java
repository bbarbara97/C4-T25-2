package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentosDAO;
import com.example.demo.dto.Departamentos;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService{

	@Autowired
	IDepartamentosDAO iDepartamentoDAO;
	
	@Override
	public List<Departamentos> listarDepartamentos() {
		
		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamentos guardarDepartamento(Departamentos departamento) {
		
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamentos departamentosXID(Long codigo) {
		
		return iDepartamentoDAO.findById(codigo).get();
	}

	@Override
	public Departamentos actualizarDepartamento(Departamentos departamento) {
		
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void eliminarDepartamento(Long codigo) {
		
		iDepartamentoDAO.deleteById(codigo);
		
	}
	
}
