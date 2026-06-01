import java.util.ArrayList;
import java.util.Iterator;

public class MotorJuego {

    public enum Estado { MENU, JUGANDO, PAUSA, GAME_OVER }

    private Estado estado;
    private ArrayList<EntidadVideojuego> entidades;
    private Player player;

    public MotorJuego() {
        estado = Estado.MENU;
        entidades = new ArrayList<>();
    }

    public void iniciar() {
        estado = Estado.JUGANDO;
        System.out.println("== JUEGO INICIADO ==");
    }

    public void pausar() {
        estado = Estado.PAUSA;
    }

    public void reanudar() {
        estado = Estado.JUGANDO;
    }

    public void gameOver() {
        estado = Estado.GAME_OVER;
        System.out.println("== GAME OVER ==");
    }

    public boolean isGameOver() {
        return estado == Estado.GAME_OVER;
    }

    public void setPlayer(Player p) {
        this.player = p;
        entidades.add(p);
    }

    public void addEntidad(EntidadVideojuego e) {
        entidades.add(e);
    }

    public void actualizar() {

        if (estado != Estado.JUGANDO) {
            System.out.println("[MOTOR] Estado: " + estado);
            return;
        }

        System.out.println("\n===== UPDATE =====");

        // IA / updates
        for (EntidadVideojuego e : entidades) {
            if (e instanceof Enemy enemy) {
                enemy.update(player);
            }
        }

        detectarColisiones();
        limpiarMuertos();
    }

    private void detectarColisiones() {

        for (EntidadVideojuego e : entidades) {

            if (e != player && player.colisionaCon(e)) {

                System.out.println("[COLISION] con " + e.getNombre());

                player.recibirDanio(1);
                e.recibirDanio(2);

                if (!player.estaVivo()) {
                    gameOver();
                }
            }
        }
    }

    private void limpiarMuertos() {

        Iterator<EntidadVideojuego> it = entidades.iterator();

        while (it.hasNext()) {
            EntidadVideojuego e = it.next();

            if (!e.estaVivo()) {
                System.out.println("[REMOVE] " + e.getNombre());
                it.remove();
            }
        }
    }
}