public class Enemy extends EntidadVideojuego {

    private enum Estado { PATRULLA, PERSEGUIR }
    private Estado estado = Estado.PATRULLA;

    public Enemy(String nombre, int x, int y) {
        super(nombre, x, y, 1, 1, 3);
    }

    public void update(EntidadVideojuego player) {

        int dx = player.x - this.x;
        int dy = player.y - this.y;

        double distancia = Math.sqrt(dx * dx + dy * dy);

        estado = (distancia < 5) ? Estado.PERSEGUIR : Estado.PATRULLA;

        if (estado == Estado.PERSEGUIR) {
            x += Integer.signum(dx);
            y += Integer.signum(dy);
        } else {
            x += (Math.random() > 0.5 ? 1 : -1);
        }

        System.out.println("[ENEMY] " + nombre + " -> " + estado + " (" + x + "," + y + ")");
    }

    @Override
    public void update() {
        // no usado
    }
}