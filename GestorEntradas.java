public class GestorEntradas {

    public void procesar(String input, Player player) {

        switch (input.toUpperCase()) {

            case "ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA" -> player.mover(input.toUpperCase());

            case "ACCION" -> System.out.println("[INPUT] Acción especial activada");

            default -> System.out.println("[INPUT] Comando no reconocido");
        }
    }
}