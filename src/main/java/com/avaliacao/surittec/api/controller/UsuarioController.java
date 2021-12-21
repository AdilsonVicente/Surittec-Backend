package com.avaliacao.surittec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.surittec.api.assembler.UsuarioInputDisassembler;
import com.avaliacao.surittec.api.assembler.UsuarioModelAssembler;
import com.avaliacao.surittec.api.model.UsuarioModel;
import com.avaliacao.surittec.api.model.input.SenhaInput;
import com.avaliacao.surittec.api.model.input.UsuarioComSenhaInput;
import com.avaliacao.surittec.api.model.input.UsuarioInput;
import com.avaliacao.surittec.domain.model.Usuario;
import com.avaliacao.surittec.domain.repository.UsuarioRepository;
import com.avaliacao.surittec.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private UsuarioInputDisassembler usuarioInputDisassembler;

	@GetMapping
	public List<UsuarioModel> listar(){
		List<Usuario> todosUsuarios = usuarioRepository.findAll();
		
		return usuarioModelAssembler.toCollectModel(todosUsuarios);
	}
	
	@GetMapping("/{usuarioId}")
	public UsuarioModel buscar(@PathVariable Long usuarioId) {
		Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);
		
		return usuarioModelAssembler.toModel(usuario);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel adicionar(@RequestBody @Valid UsuarioComSenhaInput usuarioComSenhaInput) {
		Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioComSenhaInput);
		
		return usuarioModelAssembler.toModel(cadastroUsuarioService.salvar(usuario));
	}
	
	@PutMapping("/{usuarioId}")
	public UsuarioModel atualizar(@RequestBody @Valid UsuarioInput usuarioInput, 
			@PathVariable Long usuarioId) {
		Usuario usuarioAtual = cadastroUsuarioService.buscarOuFalhar(usuarioId);
		
		usuarioInputDisassembler.copyToDomainObject(usuarioInput, usuarioAtual);
		
		return usuarioModelAssembler.toModel(cadastroUsuarioService.salvar(usuarioAtual));
	}
	
	@PutMapping("/{usuarioId}/senha")
	public void alterarSenha(@RequestBody @Valid SenhaInput senha, 
			@PathVariable Long usuarioId) {
		cadastroUsuarioService.alterarSenha(usuarioId, senha.getSenhaAtual(), senha.getNovaSenha());
	}
	
}
