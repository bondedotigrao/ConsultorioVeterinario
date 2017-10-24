package view;

import controller.ClienteController;
import model.Cliente;

/**
 *
 * @author Sebastian
 */
public class testMain {

    public static void main(String[] args) {

        Cliente c = new Cliente(6, "Phill", "724.908.564-11", "phill@net.com", "7qjsjhd23", "(99)1726-9237", "Rua Monsenhor Rodrigues");
        
        ClienteController.getInstance().adicionar(c);

    }

}