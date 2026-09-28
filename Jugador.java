/**
 * @file Jugador.java
 * @brief Clase que gestiona los movimienos del jugador
 */

/**
 * @class Jugador
 * @brief Administra la mano de fichas y jugadas 
 */
public class Jugador{
    
    private String nombre;
    private Ficha[] mano;
    private int cantidadFichas;
    private int puntosAcumulados;
    private boolean esIA;
    
    /**
     * 
     */
    public Jugador(String nombre, boolean esIA, int capacidadMaxima){
        this.nombre = nombre;
        this.esIA = esIA;
        
        this.mano = new Ficha[capacidadMaxima];
        this.cantidadFichas = 0;
        this.puntosAcumulados = 0;    
    }
    /**
     *@brief Agrega una ficha extraida de las fichas en la mesa sin estar jugando (de la pila) a la mano
     *@param ficha Ficha a agregar
     */
    public void recibirFicha(Ficha ficha){
        if(ficha != null && cantidadFichas < mano.length){
            //agregar la ficha en el indice
            mano[cantidadFichas] = ficha;
            //cantidad de fichas aumenta
            cantidadFichas++;
        }
    }
    
    /**
     * @brief  Evalua si el jugador tiene en mano una ficha que pueda jugar
     * @param extremoIzquierdo Valor actual del extremo izquierdo del tablero
     * @param extremoDerecho Valor actual del extremo derecho del tablero
     * @return true si es valida, flase si no es valida
     */
    public boolean tieneJugadaValida(int extremoIzquierdo, int extremoDerecho){
        boolean valida = false;
        int i = 0;
        //si encuentra una ficha que sea valida entra y ya no volvera a entrar porque !valida se volvera false
        while(i < cantidadFichas && !valida){
            //revisar si la ficha en la posicion i es igual con la izquierda o la derecha
            //llamamos al metodo coincideCon de la clase focha
            if(mano[i].coincideCon(extremoIzquierdo) || mano[i].coincideCon(extremoDerecho)){
                //si entra ya encontramos una ficha valida
                valida = true;
            }
            i++;
        }
        return valida;
    }
    
    /**
     * @brief Retira una ficha de la mano del jugador para der juagada
     * @param indice Posicion de la ficha en el arreglo mano
     * @return Ficha a jugar o null si el indice es invalido
     */
    //pasar la ficha de la mano al tablero de juego
    public Ficha jugarFicha(int indice){
        //indice valido
        if(indice >=0 && indice < cantidadFichas){
            //guardar la ficha en el indice indicado en una variable 
            Ficha fichaJugar = mano[indice];
            
            //Organizar las fichas en mano ya que las fichas que esten a la derecha de ;a elegida van a quedar en una posicion anteriar a la que tenian y la que estaba en ultimo lugar ya no va estar
            for(int i = indice; i < cantidadFichas - 1; i++){
                //ahora le asignamos el valor que esta a la derecha de la ficha que jugamos la posicion de esta y asi sucesivamente
                mano[i] = mano[i+1];
            }
            //como sacamos una ficha y movimos todas hacia la izquierda la ultima ya no deberia de estar
            mano[cantidadFichas - 1] = null;
            //reducimos las fichas 
            cantidadFichas--;
            return fichaJugar;
        }
        //si no entro al if el indice no es valido
        return null;
    }
    
    /**
     *@brief Calcula la suma total de puntos de las fichas restantes en mano.
     *@param valorMaximoTablero Limite del modo(6,7,8), para evaluar comodines
     *@return Suma de puntos contenidos en la mano
     */
    public int calcularPuntosMano(int valorMaximoTablero/*6,7,8*/){
        int suma = 0;
        //con un for recorremos las fichas y vaos sumando los puntos por cada una de ellas
        for( int i = 0; i < cantidadFichas; i++){
            //para obtener los puntos de cada ficha llamamos al metodo obtenerPuntosMano de la clase Ficha
            suma += mano[i].obtenerPuntosMano(valorMaximoTablero);//da el valor maximo si es comodin o suma los extremos si no lo es
        }
        return suma;
    }
    
    /**
     * @brief Moatrar en consola las fichas actuales disponibles en la mano
     */
    //importante ya que con cada jugada la mano se va modificando
    public void mostrarMano(){
        System.out.println("Mano de " + nombre + ":");
        for(int i = 0; i < cantidadFichas; i++){
            //aqui tenemos que llmar al metodo toString de la clase ficha
            System.out.println(i+1 +": " + mano[i].toString() +" ");
        }
        System.out.println();
    }
    
    /**
     * @brief Obtiene el nombre del jugados
     * @return Cadena con el nombre
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * @brief Indica si el jugador es controlado por la maquina
     * @return true si es IA, false si es humano
     */
    public boolean esIA(){
        return esIA;
    }
 
    /**
     * @brief Obtieen el acumulado de puntos del jugador
     * @return Entero con la puntuacion total acumulada
     */
    public int getPuntosAcumulados(){
        return puntosAcumulados;
    }
 
    /**
     * @brief Suma una cantidaqd de puntos con el total acumulado del jugador
     * @param puntos Puntos obtenidos en la ronda finalizada
     */
    public void sumarPuntaje(int puntos){
        this.puntosAcumulados += puntos;
    }
 
    /**
     * @brief Cantidad actual de fivhas en mano
     * @return Entero con la cantidad de fichas en mano
     */
    public int getCantidadFichas(){
        return cantidadFichas;
    }
 
    /**
     * @brief Consulta una ficha en su posicion (indice)
     * @param indice Posicion del arreglo mano
     * @return La ficha en la posicion indicada o null si no existe
     */
    public Ficha getFicha(int indice){
        //verificar si el indice es valido
        if (indice >= 0 && indice < cantidadFichas){
            //retornamos la ficha que este en esda pasocion
            return mano[indice];
        }
        //null parque no es valdo el indice
        return null;
    }  
}