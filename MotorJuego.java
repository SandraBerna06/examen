import java.util.ArrayList;
import java.util.Iterator;

public class MotorJuego {

    public enum Estado { MENU, JUGANDO, PAUSA, GAME_OVER }

    private Estado estado;
    private ArrayList<EntidadVideojuego> entidades = new ArrayList<>();

    private Player player;
    private SistemaLogros logros = new SistemaLogros();

    public MotorJuego() {
        estado = Estado.MENU;
    }

    public void iniciar() {
        estado = Estado.JUGANDO;
        System.out.println("== INICIO ==");
    }

    public void setPlayer(Player p) {
        this.player = p;
        entidades.add(p);
    }

    public void addEntidad(EntidadVideojuego e) {
        entidades.add(e);
    }

    public void actualizar() {

        if (estado != Estado.JUGANDO) return;

        System.out.println("\n--- UPDATE ---");

        for (EntidadVideojuego e : entidades) {
            if (e instanceof Enemy enemy) {
                enemy.update(player);
            }
        }

        detectarColisiones();
        limpiar();
        logros.jugadorEnX(player.x);
    }

    private void detectarColisiones() {

        for (EntidadVideojuego e : entidades) {

            if (e != player && player.colisionaCon(e)) {

                System.out.println("[COLISION] con " + e.getNombre());

                player.recibirDanio(1);
                e.recibirDanio(2);

                logros.enemigoEliminado();

                if (!player.estaVivo()) {
                    estado = Estado.GAME_OVER;
                }
            }
        }
    }

    private void limpiar() {

        Iterator<EntidadVideojuego> it = entidades.iterator();

        while (it.hasNext()) {
            EntidadVideojuego e = it.next();

            if (!e.estaVivo()) {
                System.out.println("[REMOVE] " + e.getNombre());
                it.remove();
            }
        }
    }

    // 💾 QUICK SAVE
    public String guardarEstado() {

        return "{player:{x:" + player.x +
                ",y:" + player.y +
                ",vida:" + player.vida +
                "},estado:" + estado + "}";
    }

    public boolean isGameOver() {
        return estado == Estado.GAME_OVER;
    }
}