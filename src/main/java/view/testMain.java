package view;

import controller.ClienteController;
import java.util.Random;
import model.Cliente;

/**
 *
 * @author Sebastian
 */
public class testMain {

    public static void main(String[] args) {

        Random r = new Random();
        
        Cliente c = new Cliente((100 + r.nextInt(800)), "José", "Augusto", "87676456787", "cais@gmail.com", "87555544443");
        
        ClienteController.getInstance().adicionar(c);

    }

}