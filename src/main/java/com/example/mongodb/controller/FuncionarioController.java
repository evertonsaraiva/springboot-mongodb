package com.example.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.model.Funcionario;
import com.example.mongodb.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionariService;
	
	@GetMapping
	public List<Funcionario> obterTodos() {
		return this.funcionariService.obterTodos();
	}
	
	@GetMapping("/{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionariService.obterPorCodigo(codigo);
	}
	
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionariService.criar(funcionario);
	}
	
	@GetMapping("/obterporidade/minimo/{de}/maximo/{ate}")
	public List<Funcionario> obterFuncionariosPorIdade(@PathVariable Integer de, @PathVariable Integer ate) {
		return this.funcionariService.obterFuncionariosPorIdade(de, ate);
	}
}
