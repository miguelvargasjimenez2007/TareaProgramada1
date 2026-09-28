import java.util.Random;
/**
 * @file PilaFichas.java
 * @brief Clase para gestionar las fichas en el juego
 */

/**
 * @class PilaFichas
 * @brief Administra la creacion, mezcla y extraccion de las fivhasd del juego
 */
public class PilaFichas{
    
    private Ficha[] fichas;
    private int cantidadActual;
    
    /**
     * @brief Constructor de PilaFichas
     * @param maximoModo Valor maximo de las fichas segun el modo
     */
    
    
    public PilaFichas(int limiteModo){
        //** formula para determinar la cantidad de fichas dependiendo el modo de juego (6,7,8).((n+1)*(n+2))/2*/
        int totalEstandar = ((limiteModo + 1) * (limiteModo +2))/2;
        //un comodin por cada numero de ficha, como van de 0 hasta 6,7 o 8 comodines = limiteModo +1
        int totalComodines = limiteModo + 1;
        //total de fichas con el modo que se elige y sus comodines 
        int capacidadTotal = totalEstandar + totalComodines;
        
        this.fichas = new Ficha[capacidadTotal];
        this.cantidadActual = 0;
        
        inicializar(limiteModo);
        
    }
    
    /**
     * @brief Generae inserta todas las fichas estandar y comodines en la pila
     * @param limiteModo Valor maximo del modo elegido
     */
    public void inicializar(int limiteModo){
        //genera las fichas estandar
        for(int i = 0; i <= limiteModo; i++){
            for(int j = i; j <= limiteModo;j++){
                //aqui creamos las fichas una a una, sin ser comodines
                fichas[cantidadActual] = new Ficha(i, j, false);
                //la cantidad actal inicializada en 0 se ira aumentando por cada vex]z que creemos una nueva ficha
                cantidadActual++;
            }
        }
        
        //ahora, para generar los comodines, [C|0],.....[C|limiteModod(6,7,8)]
        for(int i = 0; i <= limiteModo; i++){
            fichas[cantidadActual] = new Ficha(i, i, true);
            cantidadActual++;
        }
    }
    
    /**
     * @brief Mezcla aleatoriamente las fichas de la pila
     */
    public void mezclar(){
        Random random = new Random();
        for(int i = 0; i < cantidadActual; i++){
            int j = random.nextInt(cantidadActual);
            Ficha temp = fichas[i];
            fichas[i] = fichas[j];
            fichas[j] = temp;
        }
    }
    
    /**
     * @brief Extrae y retorna una ficha de la pila (comer)
     * @return La ultima Ficha disponible o null si la pila esta vacia
     */
    public Ficha comerFicha(){
        //con el if verifico si quedan fichas aun
        if(cantidadActual > 0){
            //el -- para sacarlo en el arreglo
            cantidadActual--;
            Ficha sacada = fichas[cantidadActual];
            //ponemos en null poprque la acabamos se tomar o sacar de la pila
            fichas[cantidadActual] = null;
            return sacada;
        }
        //si no entra al if es porque ya no quedan fichas
        return null;
    }
    
    /**
     * @brief Obtiene el numero total de fichas restantes en la pila
     * @return Entero con la cantidad de fichas disponibles
     */
    public int getCantidadActual(){
        return cantidadActual;
    }
    
    /**
     * @brief Obtiene la capacidad total de fichas con la 
     * @return Entero con la capacidad total
     */
    public int getTotalFichas(){
        return fichas.length;
    }
}
