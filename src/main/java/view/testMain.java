package view;

import controller.ClienteController;
import controller.EnderecoController;
import controller.MedicoVeterinarioController;
import java.util.Random;
import model.Cliente;
import model.Endereco;
import model.MedicoVeterinario;

/**
 *
 * @author Sebastian
 */
public class testMain {

    public static void main(String[] args) {

        Cliente c = new Cliente("teste", "teste", "teste", "teste", "teste");

        ClienteController.getInstance().adicionar(c);

//        MedicoVeterinarioController.getInstance().adicionar(m);

    }

}
