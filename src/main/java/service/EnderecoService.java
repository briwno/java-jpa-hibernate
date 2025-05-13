package service;

import entity.Endereco;
import repository.EnderecoRepository;

public class EnderecoService {
    private EnderecoRepository enderecoRepository = new EnderecoRepository();

    public void cadastrar(Endereco endereco) throws Exception {
        if (endereco == null) {
            throw new Exception("Endereço inválido: objeto nulo");
        }
        if (endereco.getRua() == null || endereco.getRua().trim().isEmpty()) {
            throw new Exception("Endereço inválido: rua obrigatória");
        }
        if (endereco.getNumero() == null || endereco.getNumero().trim().isEmpty()) {
            throw new Exception("Endereço inválido: número obrigatório");
        }
        if (endereco.getBairro() == null || endereco.getBairro().trim().isEmpty()) {
            throw new Exception("Endereço inválido: bairro obrigatório");
        }
        if (endereco.getCidade() == null || endereco.getCidade().trim().isEmpty()) {
            throw new Exception("Endereço inválido: cidade obrigatória");
        }
        if (endereco.getEstado() == null || endereco.getEstado().trim().isEmpty()) {
            throw new Exception("Endereço inválido: estado obrigatório");
        }
        if (endereco.getCep() == null || endereco.getCep().trim().isEmpty()) {
            throw new Exception("Endereço inválido: CEP obrigatório");
        }
        enderecoRepository.inserir(endereco);
    }
}
