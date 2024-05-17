
/**
 * Esta es la clase que administra el juego.
 * 
 * @author Jerson Bonilla Fernandez (C31225)
 * @version 30-9-23
 */
public class Partida
{
    private char[][] tableroPrivado;
    private int filas = 6;
    private int columnas = 7;
    

    /**
     * Constructor para objectos de la clase partida, donde cada una tiene un tablero de 6 filas y 7 columnas.
     */
    public Partida()
    {
        // inicial
        tableroPrivado = new char[filas][columnas];
    }
    
    /**
     * Metodo get para obtener el tablero privado actualizado. 
     */
    public char[][] getTableroPrivado()
    {
        return tableroPrivado;
    }
    
    /**
     * Metodo set para actualizar el tablero privado de cada partida.
     * 
     * @param  tableroActualizado   el tablero publico, despues de que un jugador ha agregado una casilla.
     * @return     nada
     */
    public void setTableroPrivado(char[][] tableroActualizado)
    {
        tableroPrivado = tableroActualizado;
    }
    
    /**
     * Metodo para llenar un espacio en el tablero
     * 
     * @param  columna   la columna escogida por alguno de los jugadores, despues de ser validada.
     * @param  tableroPublico   el tablero publico que se crea cada que se inicia una nueva partida.
     * @param  ficha   la ficha del jugador que esta escogiendo la casilla (X o O).
     * @return     nada
     */
    public void LlenarCasilla(int columna, char[][] tableroPublico, char ficha)
    {
        for(int f = 5; f >= 0; f--){
            boolean casillaOcupada = false; 
            if(tableroPublico[f][columna] != ' '){
                 casillaOcupada = true;
             }
            else{
                tableroPublico[f][columna] = ficha;
                f = -1;
            }
        }
    }
    
    /**
     * Metodo para comprobar si alguno de los dos jugadores ha ganado
     * 
     * @param  tableroPublico   el tablero publico que se crea cada que se inicia una nueva partida.
     * @param  ficha   el tablero publico que se crea cada que se inicia una nueva partida.
     * @return  boolean   devuelve true si se ha formado una linea de 4 fichas consecutivas, false en caso contrario.
     */
    public boolean ComprobarGanador(char[][] tableroPublico, char ficha){
        //Comprobar casillas horizontales
        for(int f = 0; f < filas; f++){
            int contador = 0;
            for (int c = 0; c < columnas;c++){
                if (tableroPublico[f][c] == ficha){
                    contador++;
                    if(contador == 4){
                        return true;
                    }
                }
                else{
                    contador = 0;
                }
            }
        }
        
        //comprobar casillas verticales
        for(int c = 0; c < columnas; c++){
            int contador = 0;
            for(int f = 0; f < filas; f++){
                if(tableroPublico[f][c] == ficha){
                    contador++;
                    if(contador == 4){
                        return true;
                    }
                }
                else{
                    contador = 0;
                }
            }
        }
        
        //comprobar espacios diagonales(de a arriba derecha a abajo izquierda)
        for(int f = 0; f < filas-3; f++){
            for(int c = 3; c < columnas; c++){
                if(tableroPublico[f][c] == ficha && tableroPublico[f+1][c-1] == ficha && tableroPublico[f+2][c-2] == ficha && tableroPublico[f+3][c-3] == ficha){
                    return true;
                }
            }
        }
        
        //comprobar espacios diagonales(de a arriba izquierda a abajo derecha)
        for(int f = 0; f < filas-3; f++){
            for(int c = 0; c < columnas-3; c++){
                if(tableroPublico[f][c] == ficha && tableroPublico[f+1][c+1] == ficha && tableroPublico[f+2][c+2] == ficha && tableroPublico[f+3][c+3] == ficha){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodo para comprobar si todas las casillas estan llenas y ningun jugador ha ganado.
     * 
     * @param  nuevoTablero   el tablero publico que se crea cada que se inicia una nueva partida y se actualiza constantemente.
     * @return  boolean   devuelve un true para saber si en efecto se han llenado todas las casillas; caso contrario, false.
     */
    public boolean ComprobarEmpate(char[][] tableroPublico){
        int contadorEmpate = 0;
        for(int f = 0; f < tableroPublico.length; f++) {
            for(int c = 0; c < tableroPublico[f].length; c++) {
                if(tableroPrivado[f][c] != ' '){
                    contadorEmpate++;
                }
                if(contadorEmpate == 42){
                    return true;
                }
            }
        } 
        return false;
    }
    
    /**
     * Metodo para rellenar el tablero de espacios vacios
     * 
     * @param  nuevoTablero   el tablero publico que se crea cada que se inicia una nueva partida.
     * @return     nada
     */
    public void CrearTablero(char[][] nuevoTablero)
    {
        for(int f = 0; f < nuevoTablero.length; f++) {
            for(int c = 0; c < nuevoTablero[f].length; c++) {
                tableroPrivado[f][c] = ' ';
            }
        }
    }
}
