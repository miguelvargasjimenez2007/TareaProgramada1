/**
 * @file Tablero.java
 * @brief Representa el tablero de juego donde se colocan las fichas
 */

/**
 * @class Tablero
 * @brief Administra el estado de la mesa, la secuencia de fichas jugadas y la validacion de jugadas
 */
public class Tablero{
    
    private Ficha[] fichasEnMesa;
    private int cantidadFichas;
    private int extremoIzquierdo;
    private int extremoDerecho;
    
    /**
     * @brief Contructor de la clase Tablero
     * @param cantidadFichas Capacidad maxima del tablero
     */
    public Tablero(int capacidadMaxima){
        // Inicializa el arreglo de fichas
        this.fichasEnMesa = new Ficha[capacidadMaxima];
        
        this.cantidadFichas = 0;
        
        //inicializar los extremos en un valor neutero
        this.extremoDerecho = -1;
        this.extremoIzquierdo = -1;
    }
    
    /**
     * @brief Colocar la primera ficvha del juego, en tablero vacio
     * @param Ficha ficha inicial que empieza
     */
    public void colocarPrimeraFicha(Ficha ficha){
        //guardar en la primera casilla del arreglo
        fichasEnMesa[0] = ficha;
        //ahora cantidad de fichas va a tener una ficha
        cantidadFichas = 1;
        
        //los extremos izquierdo y derechos del juego del tablero ahora va a tener los extremos de esta ficha
        extremoDerecho = ficha.getValor1();
        extremoIzquierdo = ficha.getValor2();
    }
    
    /**
     * 
     */
    public void colocarIzquierda(Ficha ficha){
        //verificar que no este vacio y si es asi llamar a colocarPrimeraFicha
        if(cantidadFichas == 0){
            colocarPrimeraFicha(ficha);
        }
        else{
            //que no sea comodin y ver cual es el lado que coincide
            if(!ficha.esComodin() && ficha.getValor2() != extremoIzquierdo){
                ficha.voltear();
            }
            //mover las fichas un espacio a la derecha
            for(int i = cantidadFichas; i > 0; i--){
                fichasEnMesa[i] = fichasEnMesa[i-1];
            }
            fichasEnMesa[0] = ficha;
            //aumnetar la cantidad de fichas en la mesa o jugada
            cantidadFichas++;
            //actualizar el nuevo extremo
            extremoIzquierdo = ficha.getValor1();
        }
    }
    
    /**
     * 
     */
    public void colocarDerecha(Ficha ficha){
        //verificar que no este sin fichas
        if(cantidadFichas == 0){
            colocarPrimeraFicha(ficha);
        }
        else{
            if(!ficha.esComodin() && ficha.getValor1() != extremoDerecho){
                ficha.voltear();
            }
            //guarda la ficha al final
            fichasEnMesa[cantidadFichas] = ficha;
            //aumentamos la cantidad de fichas en la messa o en el juego
            cantidadFichas++;
            //actualizar el nuevo extremo
            extremoDerecho = ficha.getValor2();
        }
    }
    
    /**
     * @brief obtiene el valor de la ficha en el extremo izquierdo libre para seguir la proxima jugada
     * @return Entero con el valor del extremo izquierdo
     */
    public int getExtremoIzquierdo(){
        return extremoIzquierdo;
    }
    
    /**
     * @brief obtiene el valor de la ficha en el extremo derecho     libre para seguir la proxima jugada
     * @return Entero con el valor del extremo derecho
     */
    public int getExtremoDerecho(){
        return extremoDerecho;
    }
    
    /**
     * @brief Obtiene la cantidad de fichas colocadas en la mesa.
     * @return Entero con el numero de fichas en el tablero
     */
    public int getCantidadFichasEnMesa(){
        return cantidadFichas;
    }
}