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

    private void desbloquear(String l) {
        if (!logros.contains(l)) {
            logros.add(l);
            System.out.println("🏆 LOGRO: " + l);
        }
    }
}