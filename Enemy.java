public class Enemy extends EntidadVideojuego {

    public Enemy(String nombre, int x, int y) {
        super(nombre, x, y, 1, 1, 3);
    }

    // IA: persecución simple
    public void update(EntidadVideojuego player) {

        int dx = player.x - this.x;
        int dy = player.y - this.y;

        if (Math.abs(dx) > Math.abs(dy)) {
            x += Integer.signum(dx);
        } else {
            y += Integer.signum(dy);
        }

        System.out.printf("[ENEMY] %s persigue jugador -> (%d,%d)%n", nombre, x, y);
    }

    @Override
    public void update() {
        // fallback (no usado)
    }
}