package deborah.dbc.service;


import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Funcionario;
import deborah.dbc.repository.FuncionariosRepository;

public class FuncionariosService {
    private FuncionariosRepository funcionariosRepository;

    public FuncionariosService() {
        funcionariosRepository = new FuncionariosRepository();
    }

    // criação de um objeto
    public void adicionarFuncionario(Funcionario funcionario) throws BancoDeDadosException {
        Funcionario funcionarioAdicionado = funcionariosRepository.adicionar(funcionario);
        System.out.println("contato adicinado com sucesso! " + funcionarioAdicionado);
    }

    // remoção
    public void remover(Integer id) {
        try {
            boolean conseguiuRemover = funcionariosRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editar(Integer id, Funcionario funcionario) {
        try {
            boolean conseguiuEditar = funcionariosRepository.editar(id, funcionario);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            funcionariosRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }


}
