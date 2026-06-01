import java.util.ArrayList;

public class SistemaLogros {

    private ArrayList<String> logrosDesbloqueados = new ArrayList<>();
    private int enemigosEliminados = 0;

    public void enemigoEliminado() {
        enemigosEliminados++;

        if (enemigosEliminados == 3) {
            desbloquear("CAZADOR: elimina 3 enemigos");
        }
    }

    public void jugadorEnX(int x) {
        if (x >= 5) {
            desbloquear("EXPLORADOR: llegar a X >= 5");
        }
    }

    private void desbloquear(String logro) {
        if (!logrosDesbloqueados.contains(logro)) {
            logrosDesbloqueados.add(logro);
            System.out.println("🏆 LOGRO DESBLOQUEADO: " + logro);
        }
    }

    public void mostrarLogros() {
        System.out.println("=== LOGROS ===");
        for (String l : logrosDesbloqueados) {
            System.out.println("- " + l);
        }
    }
}