public class Player extends EntidadVideojuego {

    public Player(String nombre, int x, int y) {
        super(nombre, x, y, 1, 1, 10);
    }

    public void mover(String dir) {
        switch (dir) {
            case "ARRIBA" -> y--;
            case "ABAJO" -> y++;
            case "IZQUIERDA" -> x--;
            case "DERECHA" -> x++;
        }

        System.out.printf("[PLAYER] Posición (%d,%d)%n", x, y);
    }

    @Override
    public void update() {
        // controlado por input
    }
}