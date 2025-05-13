package app;

import entity.Departamento;
import entity.Funcionario;
import repository.DepartamentoRepository;
import repository.FuncionarioRepository;
import util.TecladoUtil;

public class App3 {
    public static void main(String[] args) {
        try {
            System.out.println("=== Cadastro de Departamento ===");
            Departamento departamento = new Departamento();
            System.out.print("Nome do departamento: ");
            departamento.setNome(TecladoUtil.leitura());

            DepartamentoRepository departamentoRepository = new DepartamentoRepository();
            departamentoRepository.inserir(departamento);

            System.out.println("=== Cadastro de Funcionário ===");
            Funcionario funcionario = new Funcionario();
            System.out.print("Nome do funcionário: ");
            funcionario.setNome(TecladoUtil.leitura());
            funcionario.setDepartamento(departamento);

            FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
            funcionarioRepository.inserir(funcionario);

            System.out.println("Departamento e Funcionário cadastrados com sucesso!");
            System.out.println("Funcionário '" + funcionario.getNome() + "' cadastrado no departamento '" + departamento.getNome() + "'.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
