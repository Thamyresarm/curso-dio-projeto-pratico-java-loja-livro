package business;

import basedados.Banco;
import entity.Cliente;

import java.util.Optional;

public class ClienteBusiness {

    private Banco bancoDados;

    public ClienteBusiness(Banco banco) {
        this.bancoDados = banco;
    }


    public Optional<Cliente> consultar(String cpf) {

        for (Cliente cliente: bancoDados.getClientes()) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return  Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    public void salvar(Cliente cliente) {
        this.bancoDados.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }


    /**
     * Exclui um cliente específico.
     * @param cpf CPF do cliente
     */
    //TODO Fazer a exclusão de cliente

}
