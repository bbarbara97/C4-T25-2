package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Departamentos;
import com.example.demo.service.DepartamentosServiceImpl;


@RestController
@RequestMapping("/api")
public class DepartamentosController {

	@Autowired
	DepartamentosServiceImpl departamentoServideImpl;

	@GetMapping("/departamentos")
	public List<Departamentos> listarDepartamentos(){
		return departamentoServideImpl.listarDepartamentos();
	}

	@PostMapping("/departamentos")
	public Departamentos salvarDepartamentos(@RequestBody Departamentos departamentos) {

		return departamentoServideImpl.guardarDepartamento(departamentos);
	}

	@GetMapping("/departamentos/{codigo}")
	public Departamentos departamentoXID(@PathVariable(name="codigo") Long codigo) {

		Departamentos departamento_xid= new Departamentos();

		departamento_xid=departamentoServideImpl.departamentosXID(codigo);

		System.out.println("departamento XID: "+departamento_xid);

		return departamento_xid;
	}

	@PutMapping("/departamentos/{codigo}")
	public Departamentos actualizarDepartamento(@PathVariable(name="codigo")Long codigo,@RequestBody Departamentos departamentos) {

		Departamentos departamentos_seleccionado;
		Departamentos departamentos_actualizado;

		departamentos_seleccionado= departamentoServideImpl.departamentosXID(codigo);

		departamentos_seleccionado.setNombre(departamentos.getNombre());
		departamentos_seleccionado.setPresupuesto(departamentos.getPresupuesto());

		departamentos_actualizado = departamentoServideImpl.actualizarDepartamento(departamentos_seleccionado);

		System.out.println("El departamento actualizado es: "+ departamentos_actualizado);

		return departamentos_actualizado;
	}

	@DeleteMapping("/departamentos/{codigo}")
	public void eliminarDepartamento(@PathVariable(name="codigo")Long codigo) {
		departamentoServideImpl.eliminarDepartamento(codigo);
	}
}
