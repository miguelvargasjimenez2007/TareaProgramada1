/**
     * @file Ficha.java
     * @brief Clase que representa una ficha del juego domino.
     */
    
    /**
     * @class Ficha
     * @brief Estructuras de datos para gestionar los valores, condición de comodín y orientación de una ficha.
     */
public class Ficha{
    private int valor1;
    private int valor2;
    private boolean esComodin;
    private boolean esDoble;
    
    /**
     * @brief Constructor de la ficha
     * @param valor1 Valor del primer lado de la ficha
     * @param valor2 Valor del segundo lado de la ficha
     * @param esComodin Indica si la ficha cumple como comodin.
     */
    public Ficha(int valor1, int valor2, boolean esComodin){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.esComodin = esComodin;
        this.esDoble = (valor1 == valor2);
    }
    
    /**
     * @brief Obtiene el primer valor de las ficha.
     * @return entero con el valor 1
     */
    public int getValor1(){
        return valor1;
    }
    
    /**
     * @brief Obtiene el segundo valor de las ficha.
     * @return entero con el valor 2
     */
    public int getValor2(){
        return valor2;
    }
    
    /**
     * @brief consulta si la ficha es comodin o no
     * @return esComodin
     */
    public boolean esComodin() {
        return esComodin;
    }
    
    /**
     * @brief consulta si la ficha es doble
     * @return true si ambos lados son iguales, false si no
     */
    public boolean esDoble(){
        boolean doble = false;
        if(esDoble){
            doble = true;
        }
        return doble;
    }
    
    /**
     * @brief para calcular los puntos que aporta la ficha al perdedor de una ronda
     * @param valorMaximoTablero Puntuacion maxima del modo (6,7,8) que asigana si la ficha es comodin
     * @return Suma de lados si es ficha normal o el valor maximo si es comodin
     */
    public int obtenerPuntosMano(int valorMaximoTablero){
        if(esComodin){
            return valorMaximoTablero;
        }
        else{
            return valor1 + valor2;
        }
    }
    
    /**
     * @brief Verificar si la ficha coincide con un extremo del tablero.
     * @param valor Número presente en el extremo del tablero.
     * @return true si es comodín o si alguno de sus lados coincide con el valor.
     */
    
    public boolean coincideCon(int valor){
        if(esComodin){
            return true;
        }
        return (valor1 == valor || valor2 == valor);
    }
    
    /**
     * @brief invierte la posocion de valor1 y valor2, para acomplar la ficha al, tablero
     */
    //Invertir la posición de valor1 y valor2 para acomodarla en el tablero.
    public void voltear(){
        int temp = valor1;
        valor1 = valor2;
        valor2 = temp;
    }
    
    /**
     * @brief Genera la ficha en formato string
     * @return Cadena de texto con el formato [C|x] para comodin o [A|B] para fichas normales
     */
    
    public String toString(){
        if(esComodin){
            return "[Comodin] = [C|"+valor1+"]";
        }
        return "[" + valor1 + "|" + valor2 + "]";
    }
}