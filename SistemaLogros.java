import java.util.ArrayList;

public class SistemaLogros {

    private ArrayList<String> logros = new ArrayList<>();
    private int enemigosEliminados = 0;

    public void enemigoEliminado() {
        enemigosEliminados++;

        if (enemigosEliminados >= 3) {
            desbloquear("CAZADOR: 3 enemigos eliminados");
        }
    }

    public void posicionJugador(int x) {
        if (x >= 5) {
            desbloquear("EXPLORADOR: X >= 5");
        }
    }

    private void desbloquear(String logro) {
        if (!logros.contains(logro)) {
            logros.add(logro);
            System.out.println("🏆 LOGRO: " + logro);
        }
    }

    public void mostrar() {
        System.out.println("=== LOGROS ===");
        for (String l : logros) {
            System.out.println("- " + l);
        }
    }
}