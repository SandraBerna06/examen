# 🚀 SPACE GRID ENGINE

## 🎮 Temática del videojuego

Este proyecto simula un **motor básico de videojuego 2D tipo cuadrícula**, donde el jugador controla una nave espacial que debe moverse, evitar enemigos y sobrevivir el mayor tiempo posible.

El objetivo no es construir un videojuego completo, sino diseñar un **motor de lógica interna** con arquitectura orientada a objetos, control de estados, colisiones y sistema de eventos.

---

# 🧠 Arquitectura del Software

El sistema se ha diseñado con una arquitectura modular y mínima (máx. 6 clases):

## 🧩 Clases principales

- **Main**
  - Punto de entrada del programa
  - Simula inputs del usuario por consola

- **MotorJuego**
  - Controlador principal del juego
  - Gestiona estados: MENU, JUGANDO, PAUSA, GAME OVER
  - Maneja entidades y lógica del game loop

- **EntidadVideojuego (abstracta)**
  - Clase base de todos los objetos del juego
  - Define posición (x, y), tamaño (w, h) y vida
  - Implementa lógica base de colisión

- **Player**
  - Representa al jugador (nave espacial)
  - Se mueve mediante inputs

- **Enemy**
  - NPC enemigo con IA básica de persecución

- **GestorEntradas**
  - Procesa comandos del usuario

- **SistemaLogros**
  - Gestiona eventos de logros desbloqueados

---

# 📊 Diagrama de Clases UML (Mermaid)

```mermaid
classDiagram

class EntidadVideojuego {
  +String nombre
  +int x
  +int y
  +int w
  +int h
  +int vida
  +update()
  +colisionaCon()
  +recibirDanio()
}

class Player {
  +mover()
  +update()
}

class Enemy {
  +update(Player)
}

class MotorJuego {
  -Estado estado
  -ArrayList entidades
  +iniciar()
  +actualizar()
  +guardarEstado()
}

class GestorEntradas {
  +procesar()
}

class SistemaLogros {
  +registrarMuerteEnemigo()
  +revisarPosicion()
}

EntidadVideojuego <|-- Player
EntidadVideojuego <|-- Enemy

MotorJuego --> EntidadVideojuego
MotorJuego --> SistemaLogros
Main --> MotorJuego
Main --> GestorEntradas

## 🎯 Diagrama de casos de uso (UML)

```mermaid
usecaseDiagram
actor Jugador

rectangle "Space Grid Engine" {

  (Iniciar partida) as UC1
  (Mover nave) as UC2
  (Acción especial) as UC3
  (Actualizar juego) as UC4
  (Detectar colisiones) as UC5
  (Desbloquear logros) as UC6
  (Guardar estado) as UC7
}

Jugador --> UC1
Jugador --> UC2
Jugador --> UC3

UC1 --> UC4
UC4 --> UC5
UC4 --> UC6
UC4 --> UC7

UC5 --> UC6
```

### 📌 Especificación de Casos de Uso

---

### 🧾 CU-01 Iniciar partida

| Campo | Descripción |
|------|-------------|
| **Nombre** | CU-01 Iniciar partida |
| **Objetivo** | Iniciar una nueva partida desde estado inicial |
| **Actor principal** | Jugador |
| **Precondiciones** | El sistema debe estar en estado MENU |
| **Flujo principal** | 1. El jugador ejecuta el programa<br>2. El sistema cambia a estado JUGANDO<br>3. Se inicializan entidades del juego |
| **Flujos alternativos** | Si el juego ya está en curso, no se reinicia |
| **Postcondiciones** | El motor entra en estado activo |
| **Reglas de negocio** | No puede haber dos partidas activas simultáneamente |

---

### 🧾 CU-02 Mover nave

| Campo | Descripción |
|------|-------------|
| **Nombre** | CU-02 Mover nave |
| **Objetivo** | Permitir el desplazamiento del jugador en la cuadrícula |
| **Actor principal** | Jugador |
| **Precondiciones** | El juego debe estar en estado JUGANDO |
| **Flujo principal** | 1. El jugador introduce comando<br>2. El sistema procesa entrada<br>3. Se actualiza la posición del jugador |
| **Flujos alternativos** | Si el comando es inválido, se ignora |
| **Postcondiciones** | La posición del jugador cambia |
| **Reglas de negocio** | El jugador no puede salir del mapa definido |

---

## 🤖 Bitácora de uso de inteligencia artificial

### 🛠 Herramienta utilizada
ChatGPT (OpenAI)  
Rol: Asistente de diseño de arquitectura, generación de código y documentación UML

---

### 💬 Prompts utilizados

**Prompt 1:**
> Diseña un motor de videojuego en Java con máximo 6 clases, colisiones y enemigos

**Prompt 2:**
> Añade sistema de logros y guardado rápido sin superar el límite de clases y manteniendo UML coherente

---

### ⚠️ Control de errores de la IA

Durante el desarrollo, la IA cometió los siguientes errores:

- Propuesta inicial con más de 6 clases (sobreingeniería)
- Separación innecesaria de sistemas en managers adicionales
- Complejidad excesiva para el alcance del proyecto

✔ **Correcciones aplicadas:**

- Reducción estricta a 6 clases máximas
- Integración de lógica dentro de `MotorJuego`
- Simplificación del sistema de colisiones y logros
- Eliminación de abstracciones innecesarias

---

## 🧠 Reflexión crítica

El uso de inteligencia artificial en el desarrollo de software permite acelerar significativamente la creación de estructuras complejas como motores de videojuegos.

Sin embargo, también presenta riesgos importantes:

- Tendencia a sobreingeniería
- Generación de arquitecturas demasiado complejas
- Necesidad de supervisión humana constante

Por ello, es fundamental combinar la IA con criterio de diseño propio para garantizar un código limpio, mantenible y ajustado a requisitos reales.

---

## 🏁 Conclusión

Este proyecto demuestra la capacidad de diseñar un motor de videojuego funcional, aplicando:

- Programación orientada a objetos  
- Gestión de estados  
- Colisiones básicas  
- IA simple de enemigos  
- Sistemas de eventos (logros)  
- Uso controlado de inteligencia artificial en el desarrollo