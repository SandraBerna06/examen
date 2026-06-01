public abstract class EntidadVideojuego {

    protected String nombre;
    protected int x, y, w, h;
    protected int vida;

    public EntidadVideojuego(String nombre, int x, int y, int w, int h, int vida) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void update();

    // COLISIÓN REAL (AABB)
    public boolean colisionaCon(EntidadVideojuego other) {
        return this.x < other.x + other.w &&
               this.x + this.w > other.x &&
               this.y < other.y + other.h &&
               this.y + this.h > other.y;
    }

    public void recibirDanio(int dmg) {
        vida -= dmg;
        System.out.println(nombre + " recibe " + dmg + " daño. Vida: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }
}