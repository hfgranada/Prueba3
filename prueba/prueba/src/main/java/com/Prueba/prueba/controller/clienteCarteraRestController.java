package com.Prueba.prueba.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.prueba.domain.Respuesta;
import com.Prueba.prueba.domain.inputCartera;
import com.Prueba.prueba.domain.inputCliente;
import com.Prueba.prueba.entidad.Clientescartera;
import com.Prueba.prueba.services.clienteCarteraServices;

@RestController
@RequestMapping(path = "/clientes")
@CrossOrigin(origins = "*")
public class clienteCarteraRestController {

	public static final String HTTP_OK = "200";
	public static final String HTTP_BAD_REQUEST = "400";
	
	@Autowired
	private clienteCarteraServices _clienteCarteraServices;
	
	@PostMapping(path ="/consultar")
	public ResponseEntity<?> consultarAgencia(@RequestBody inputCartera inCodigo) throws Exception {
		 Respuesta respuesta = new Respuesta();
		try {
			List<Clientescartera> result = _clienteCarteraServices.findAll();
			respuesta.setCodigo("01");
			respuesta.setEstado(true);
			respuesta.setCodigo("bn");
			respuesta.setObjResult(result);
			
			
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping(path="/consultaId")
	public Clientescartera findById(@RequestParam(value="id") Integer id) throws Exception {
		Clientescartera cliente = (_clienteCarteraServices.findById(id).isPresent() == true)? _clienteCarteraServices.findById(id).get() : null; 
	    return cliente;	
	}
	
	@PostMapping(path="/Guardar")
	public ResponseEntity<?> save(@RequestBody inputCliente obj) throws Exception{
		Respuesta respuesta = new Respuesta();
		try {
			
			List<String> lstErrores = validarCampos(obj);
			
			if(lstErrores.size() > 0) {
				respuesta.setCodigo("99");
				respuesta.setEstado(false);
				respuesta.setCodigo("Se han presentado errores en el proceso");
				respuesta.setObjResult(lstErrores);
				return ResponseEntity.ok(respuesta);
			}
			
			Clientescartera cliente =  new Clientescartera();
			if(!obj.getFechavenc().isEmpty()) {
				Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getFechavenc());
				cliente.setFechavenc(fecha);
			}
			
			
			cliente.setEmail(obj.getEmail());
			
			cliente.setIdcliente(obj.getIdcliente());
			cliente.setIdentificadordeuda(obj.getIdentificadordeuda());
			cliente.setNombrecliente(obj.getNombrecliente());
			cliente.setSaldo(obj.getSaldo());
			var result = _clienteCarteraServices.save(cliente);
			
			respuesta.setCodigo("02");
			respuesta.setEstado(true);
			respuesta.setCodigo("Registro guardado con exito");
			respuesta.setObjResult(result);
			
			
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping(path="/Actualizar")
	public ResponseEntity<?> update(@RequestBody inputCliente obj) throws Exception{
		Respuesta respuesta = new Respuesta();
		try {
			
			List<String> lstErrores = validarCampos(obj);
			
			if(lstErrores.size() > 0) {
				respuesta.setCodigo("99");
				respuesta.setEstado(false);
				respuesta.setCodigo("Se han presentado errores en el proceso");
				respuesta.setObjResult(lstErrores);
				return ResponseEntity.ok(respuesta);
			}
			
			Clientescartera cliente = (_clienteCarteraServices.findById(obj.getId()).isPresent() == true)? _clienteCarteraServices.findById(obj.getId()).get() : null; 
			if(cliente != null) {
				if(!obj.getFechavenc().isEmpty()) {
					Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getFechavenc());
					cliente.setFechavenc(fecha);
				}
				
				
				cliente.setEmail(obj.getEmail());
				
				cliente.setIdcliente(obj.getIdcliente());
				cliente.setIdentificadordeuda(obj.getIdentificadordeuda());
				cliente.setNombrecliente(obj.getNombrecliente());
				cliente.setSaldo(obj.getSaldo());
				var result = _clienteCarteraServices.update(cliente);
				
				respuesta.setCodigo("03");
				respuesta.setEstado(true);
				respuesta.setCodigo("Registro actualizado con exito");
				respuesta.setObjResult(result);
			}
		}catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping(path="/Eliminar")
	public ResponseEntity<?> delete(@RequestParam(value="id") Integer id) throws Exception{
		Respuesta respuesta = new Respuesta();
		try {
				_clienteCarteraServices.deleteById(id);
				respuesta.setCodigo("04");
				respuesta.setEstado(true);
				respuesta.setCodigo("Se a Eliminado el registro con exito");
		}catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	private List<String> validarCampos(inputCliente obj) {
		
		List<String> lstErrores = new ArrayList<String>();

		if(obj.getFechavenc().isEmpty()) {
			lstErrores.add("Falta la fecha de vencimiento");
		}
		
		if(obj.getNombrecliente().isEmpty()) {
			lstErrores.add("El nombre es obligatorio");
		}
		
		return lstErrores;
		
	}
}
