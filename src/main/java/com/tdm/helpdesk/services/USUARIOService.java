package com.tdm.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public USUARIO findById(Integer id) {
		
		Optional<USUARIO> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado! ID: "+ id));
		
	}
	
	public List<USUARIO> findAll(){
		return repository.findAll();
	}

	public USUARIO create(USUARIODTO objDTO) {
		
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		USUARIO newObj = new USUARIO(objDTO);
		newObj.setDataCriacao(LocalDate.now());
		return repository.save(newObj);
	}
	
	public USUARIO update(Integer id, @Valid USUARIODTO objDTO) {
		objDTO.setId(id);
		USUARIO oldobj = findById(id); 
		
		if(!objDTO.getSenha().equals(oldobj.getSenha())) {
			objDTO.setSenha(encoder.encode(objDTO.getSenha())); 
		}
		
		validaPorCpfEEmail(objDTO);
		oldobj = new USUARIO(objDTO);
		return repository.save(oldobj);
	}
	 

	public void delete(Integer id) {
		
		USUARIO obj = findById(id);
		if(obj.getTarifas().size()>0) {
			throw new DataIntegrityViolationException("Usuario possui Tarifas e não pode ser excluido!");		
			
		}else {
			repository.deleteById(id);
		}
		
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
    public Integer findUserIdByEmail(String email) {
        Optional<Pessoa> pessoa = pessoarepository.findByEmail(email);
        return pessoa.map(Pessoa::getId).orElse(null);
    }


	




}


