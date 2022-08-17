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

import com.example.demo.dto.Empleados;
import com.example.demo.service.EmpleadosServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadosController {

	@Autowired
	EmpleadosServiceImpl empleadosServideImpl;
	
	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados(){
		return empleadosServideImpl.listarEmpleados();
	}
	
	@PostMapping("/empleados")
	public Empleados salvarEmpleado(@RequestBody Empleados empleados) {
		
		return empleadosServideImpl.guardarEmpleado(empleados);
	}
	
	@GetMapping("/empleados/{codigo}")
	public Empleados empleadosXID(@PathVariable(name="codigo") Long codigo) {
		
		Empleados empleados_xid= new Empleados();
		
		empleados_xid=empleadosServideImpl.empleadoXID(codigo);
		
		System.out.println("Empleado XID: "+empleados_xid);
		
		return empleados_xid;
	}
	
	@PutMapping("/empleados/{codigo}")
	public Empleados actualizarEmpleado(@PathVariable(name="codigo") Long codigo,@RequestBody Empleados empleados) {
		
		Empleados empleados_seleccionado;
		Empleados empleados_actualizado;
		
		empleados_seleccionado= empleadosServideImpl.empleadoXID(codigo);
		
		empleados_seleccionado.setDni(empleados.getDni());
		empleados_seleccionado.setNombre(empleados.getNombre());
		empleados_seleccionado.setApellidos(empleados.getApellidos());
		empleados_seleccionado.setDepartamento(empleados.getDepartamento());
		
		empleados_actualizado = empleadosServideImpl.actualizarEmpleado(empleados_seleccionado);
		
		System.out.println("El empleado actualizado es: "+ empleados_actualizado);
		
		return empleados_actualizado;
	}
	
	@DeleteMapping("/empleados/{codigo}")
	public void eleiminarArticulo(@PathVariable(name="codigo")Long codigo) {
		empleadosServideImpl.eliminarEmpleado(codigo);
	}
}
