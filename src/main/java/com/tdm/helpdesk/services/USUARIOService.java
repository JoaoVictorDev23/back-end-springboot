package com.tdm.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.helpdesk.domain.Pessoa;
import com.tdm.helpdesk.domain.USUARIO;
import com.tdm.helpdesk.domain.dtos.USUARIODTO;
import com.tdm.helpdesk.repositories.PessoaRepository;
import com.tdm.helpdesk.repositories.UsuarioRepository;
import com.tdm.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.tdm.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class USUARIOService {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PessoaRepository pessoarepository;
	
	public USUARIO findById(Integer id) {
		
		Optional<USUARIO> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID: "+ id));
		
	}
	
	public List<USUARIO> findAll(){
		return repository.findAll();
	}

	public USUARIO create(USUARIODTO objDTO) {
		
		objDTO.setId(null);
		
		validaPorCpfEEmail(objDTO);
		USUARIO newObj = new USUARIO(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(USUARIODTO objDTO) {
		Optional<Pessoa> obj = pessoarepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no Sistema!");
		}
		
		obj = pessoarepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no Sistema!");
		}
		
	}
}
