package service;

import entity.Pessoa;
import repository.PessoaRepository;

public class PessoaService {
    private PessoaRepository pessoaRepository = new PessoaRepository();

    public void cadastrar(Pessoa pessoa) throws Exception {
        if (pessoa == null || pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
            throw new Exception("Pessoa inválida: nome obrigatório");
        }
        pessoaRepository.inserir(pessoa);
    }
}
