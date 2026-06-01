import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();
        GestorEntradas input = new GestorEntradas();

        Player player = new Player("Nave", 0, 0);

        motor.setPlayer(player);
        motor.addEntidad(new Enemy("Drone-1", 3, 3));
        motor.addEntidad(new Enemy("Drone-2", -2, 1));

        Scanner sc = new Scanner(System.in);

        motor.iniciar();

        while (!motor.isGameOver()) {

            System.out.println("\nComando:");
            String cmd = sc.nextLine();

            input.procesar(cmd, player);

            motor.actualizar();
        }

        System.out.println("Fin del programa.");
    }
}