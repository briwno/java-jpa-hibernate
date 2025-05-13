package app;

import entity.Pessoa;
import entity.Endereco;
import service.PessoaService;
import util.TecladoUtil;

public class App2 {
    public static void main(String[] args) {
        PessoaService pessoaService = new PessoaService();

        try {
            System.out.println("=== Cadastro de Pessoa ===");
            Pessoa pessoa = new Pessoa();
            System.out.print("Nome: ");
            pessoa.setNome(TecladoUtil.leitura());

            System.out.println("=== Cadastro de Endereço ===");
            Endereco endereco = new Endereco();
            System.out.print("Rua: ");
            endereco.setRua(TecladoUtil.leitura());
            System.out.print("Número: ");
            endereco.setNumero(TecladoUtil.leitura());
            System.out.print("Complemento: ");
            endereco.setComplemento(TecladoUtil.leitura());
            System.out.print("Bairro: ");
            endereco.setBairro(TecladoUtil.leitura());
            System.out.print("Cidade: ");
            endereco.setCidade(TecladoUtil.leitura());
            System.out.print("Estado: ");
            endereco.setEstado(TecladoUtil.leitura());
            System.out.print("CEP: ");
            endereco.setCep(TecladoUtil.leitura());

            pessoa.setEndereco(endereco);
            endereco.setPessoa(pessoa);

            pessoaService.cadastrar(pessoa);

            System.out.println("Pessoa e Endereço cadastrados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
