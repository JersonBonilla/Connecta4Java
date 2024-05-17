import java.util.Scanner;
/**
 * Esta es la clase static que corresponde al GUI.
 * 
 * @author Jerson Bonilla Fernandez (C31225)
 * @version 30-9-23
 */
public class GUI
{
    public static String nombre = "GUI";
    static Scanner input = new Scanner(System.in);
    /**
     * Metodo que ocurre si se ingresa -h o -help desde la linea de comandos
     * @param help parametro que se recibe desde la linea de comandos
     * @return     nada 
     */
    public static void AyudaUsuario(String help)
    {
        System.out.println("Bienvenido al Conecta 4.");
        System.out.println("Ingresa 1 para iniciar una nueva partida.");
        System.out.println("Ingresa 2 para ver las reglas del juego.");
        System.out.println("Ingresa 3 para salir del programa.");
    }
    
    /**
     * Metodo de introduccion, muestra el menu y valida la opcion ingresada por el usuario.
     * 
     */
    public static int Introduccion()
    {
        System.out.println("\n================= Bienvenido a Conecta 4 =================\n");
        System.out.println("1. Jugar partida");
        System.out.println("2. Ver reglas");
        System.out.println("3. Salir");
        
        int opcion = 0;
        boolean valido = false;
        while(!valido){
           try {
                System.out.println("Ingrese la accion que desea realizar: ");
                String opcionIngresada = input.nextLine();
                opcion = Integer.parseInt(opcionIngresada);
                if(opcion < 1 || opcion > 3){
                    System.out.println("La opcion ingresada no es valida. Ingrese una opcion valida.");
                }
                else{
                    valido = true;
                }
            }
            catch(Exception excepcionPorDefecto){
                System.out.println("La opcion ingresada no es valida. Ingrese una opcion valida.");
            } 
        }
        return opcion;
    }
    
    /**
     * Metodo para mostrar las reglas. Ocurre si la opcion ingresada por el usuario es 2.
     * 
     */
    public static void Reglas(){
        System.out.println();
        System.out.println("¡Bienvenido a Conecta 4!");
        System.out.println("El juego consiste en un tablero de 6 filas y 7 columnas como el siguiente:");
        
        System.out.println("---------------------------");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");
        System.out.println("| |" + "| |"+"| |"+"| |"+"| |"+"| |"+"| |");

        System.out.println(" 0 " + " 1 " + " 2 " + " 3 " + " 4 " + " 5 " + " 6 ");
        System.out.println("---------------------------");
        
        System.out.println("El juego consta de dos jugadores que intentaran formar una línea de cuatro fichas consecutivas('X' o 'O'), \nde forma horizontal, vertical o diagonal."); 
        System.out.println("Jugador 1 juega con la ficha 'X' y Jugador 2 juega con la ficha 'O'");
        System.out.println("Para seleccionar la columna en la que se desea poner la ficha basta con escribir el número correspondiente.");
        System.out.println("La gravedad es un factor importante en el juego, por lo que siempre y cuando los espacios no estén ocupados, \nla ficha caerá hasta la última fila o hasta el espacio que esté libre.");
        System.out.println("El primer jugador que logre formar dicha línea gana.");
        System.out.println("¡Buena Suerte!");
        System.out.println();
    }
    
    /**
     * Metodo para mostrar el tablero, muestra el menu y valida la opcion ingresada por el usuario.
     * 
     * @param  nuevoTablero  el tablero que se crea cada vez que se crea una partida, o cada vez que se actualiza.
     */
    public static void MostrarTablero(char[][] nuevoTablero)
    {
        System.out.println("---------------------------");
        // Loop para pasar por cada fila
        for (int f = 0; f < nuevoTablero.length; f++){
            // Loop para pasar por cada elemento de la fila, es decir, cada columna
            for (int c = 0; c < nuevoTablero[f].length; c++)
            {
                char casilla = nuevoTablero[f][c];
                System.out.print("|" + casilla + "|");
            }
            System.out.println();
        }
        System.out.println(" 0 " + " 1 " + " 2 " + " 3 " + " 4 " + " 5 " + " 6 ");
        System.out.println("---------------------------");
        System.out.println();
    }
    
    /**
     * Metodo para pedir una columna al usuario y para validar la jugada (es decir, la columna seleccionada).
     * 
     * @param  tableroPublico   el tablero que los usuarios pueden ver y se actualiza. 
     * @return   int   el numero de columna validado como un int para ser usado en la clase Partida. 
     */
    public static int validarJugada(char[][] tableroPublico)
    {
        String numeroColumnaUsuario = "";
        int numeroColumnaValido = 0;
        boolean valido = false;
        
        while(!valido){
           try {
                System.out.println("Digite el numero de columna en que desea poner la ficha:");
                numeroColumnaUsuario = input.nextLine();
                numeroColumnaValido = Integer.parseInt(numeroColumnaUsuario);
                if(numeroColumnaValido > 6 || numeroColumnaValido < 0){
                    System.out.println("El valor ingresado se encuentra fuera de los límites.\nPor favor, ingrese un número de columna válido.");
                }
                else{
                    if(tableroPublico[0][numeroColumnaValido] != ' '){
                        System.out.println("¡La columna seleccionada ya se encuentra llena! Escoja otra columna.");
                    }
                    else{
                        valido = true;
                    }
                }
            }
            catch(Exception excepcionPorDefecto){
                System.out.println("El valor ingresado no es válido.\nPor favor, ingrese un número de columna válido.");
            } 
        }
        
        return numeroColumnaValido;
    }   
}
