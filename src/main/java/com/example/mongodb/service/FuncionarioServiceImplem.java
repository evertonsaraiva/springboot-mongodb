package com.example.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodb.model.Funcionario;
import com.example.mongodb.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImplem implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.funcionarioRepository
				.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não existe"));
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		Funcionario chefe = funcionarioRepository.findById(
					funcionario.getChefe().getCodigo() ).orElseThrow(() -> new IllegalArgumentException("Chefe não existe") );
		
		funcionario.setChefe(chefe);
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate) {
		List<Funcionario> funcionarios = this.funcionarioRepository.obterFuncionariosPorIdade(de, ate);
		return funcionarios;
	}

}
