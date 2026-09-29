/**
 * @file Partida.java
 * @brief Controlador principal del flujo, rteglas y estado del juego
 */

/**
 * @class Partida
 * @brief Administra los participantes, la pila de fichas, el tablero y la puntuacion requerida para ganar
 */
public class Partida{
    //los atributos deben de estar en doxy
    private static final int puntosParaGanar = 70;
    private static final int fichasIniciales = 7;
    
    private Jugador jugador1;
    private Jugador jugador2;
    //intancia de la clase PilaFichas
    private PilaFichas pila;
    //Instancia de la clase Tablero
    private Tablero tablero;
    //Limite numerico del modo de juego actual(6,7,8)
    private int valorMaximo;
    private boolean usarComodines;
    
    /**
     * @brief Constructor de la clase Partida
     * @details Inicializa la pila de fichas, calcula la capacidad del sistema e instancia los participantes y el tablero de juego
     * @param nombreJugador1 Nombre del primer jugador
     * @param esVirtual1 true si el jugador 1 es IA, false si es humano
     * @param nombreJugador2 Nombre del segundo jugador
     * @param esVirtual2 true si el jugador 2 es IA, false si es humano
     * @param valorMaximo Valor mas alto segun el modo seleccionado(6,7,8)
     * @param usarComodines Indica si la partida incluye fichas de tipo comodin
     */
    public Partida(String nombreJugador1, boolean esVirtual1,
                    String nombreJugador2, boolean esVirtual2,
                    int valorMaximo, boolean usarComodines)
    {
        this.valorMaximo = valorMaximo;
        this.usarComodines = usarComodines;
        this.pila = new PilaFichas(valorMaximo);
        //numero de fichas
        int capacidadMaxima = pila.getCantidadActual();
        //inicializacion de los jugadores 
        this.jugador1 = new Jugador(nombreJugador1, esVirtual1, capacidadMaxima);
        this.jugador2 = new Jugador(nombreJugador2, esVirtual2, capacidadMaxima);
        //inicializacon del tablero
        this.tablero = new Tablero(capacidadMaxima);
    }

}