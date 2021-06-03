package com.Prueba.prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.Prueba.prueba.entidad.Clientescartera;
import com.Prueba.prueba.repository.clienteCarteraRepository;
import com.Prueba.prueba.services.clienteCarteraServices;

@Scope("singleton")
@Service
public class clienteCarteraServicesImpl implements clienteCarteraServices{

	@Autowired
	private clienteCarteraRepository  _clienteCarteraRepository;

	@Override
	public List<Clientescartera> findAll() {
		// TODO Auto-generated method stub
		return _clienteCarteraRepository.findAll();
	}

	@Override
	public Optional<Clientescartera> findById(Integer id) {
		// TODO Auto-generated method stub
		return _clienteCarteraRepository.findById(id);
	}

	@Override
	public Clientescartera save(Clientescartera entity) throws Exception {
		// TODO Auto-generated method stub
		return  _clienteCarteraRepository.save(entity);
	}

	@Override
	public Clientescartera update(Clientescartera entity) throws Exception {
		// TODO Auto-generated method stub
		return _clienteCarteraRepository.save(entity);
	}

	@Override
	public void delete(Clientescartera entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		_clienteCarteraRepository.deleteById(id);
	}

	@Override
	public void validate(Clientescartera entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
