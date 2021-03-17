package com.example.mongodb.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.mongodb.model.Funcionario;

public interface FuncionarioService {

	public List<Funcionario> obterTodos();
	
	public Funcionario obterPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);
	
	public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate);
}
