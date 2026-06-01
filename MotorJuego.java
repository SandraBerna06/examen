import java.util.ArrayList;

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

        entidades.removeIf(e -> !e.estaVivo());
    }

    // 💾 SAVE 10/10
    public String guardarEstado() {

        return """
        {
          "estado": "%s",
          "player": {
            "x": %d,
            "y": %d,
            "vida": %d
          },
          "entidades": %d
        }
        """.formatted(estado, player.x, player.y, player.vida, entidades.size());
    }

    // 🔄 LOAD SIMULADO
    public void cargarEstado(String save) {

        System.out.println("Cargando partida...");

        if (save.contains("GAME_OVER")) {
            estado = Estado.GAME_OVER;
        } else {
            estado = Estado.JUGANDO;
        }

        System.out.println("Estado cargado: " + estado);
    }

    public boolean isGameOver() {
        return estado == Estado.GAME_OVER;
    }
}