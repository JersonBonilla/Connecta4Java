import java.util.Scanner;
/**
 * Esta es la clase principal
 * 
 * @author Jerson Bonilla Fernandez (C31225) 
 * @version 30-9-23
 */
public class Principal
{
    public static void main (String[] args)
    {
        for (String argument : args){
            if (argument.equals("-h") || argument.equals("-help")){
                GUI.AyudaUsuario(argument);
            }
            else{
            }
        }
        Scanner input = new Scanner(System.in);
        boolean continuarPrograma = true;
        
        while (continuarPrograma){
            int opcion = GUI.Introduccion();
            if(opcion == 1){
                Partida partida1 = new Partida();
        
                char[][] tableroPublico; //creamos el tablero para mostrar
                tableroPublico = partida1.getTableroPrivado(); //hacemos que el tablero publico sea igual al tablero privado
                partida1.CrearTablero(tableroPublico); // Creamos el tablero publico llenandolo de ' '.
                partida1.setTableroPrivado(tableroPublico); //actualizamos el tablero privado de la partida, haciendo que sea igual al publico lleno
                GUI.MostrarTablero(tableroPublico);
                int numeroColumna = 0;
                char ficha = ' ';
                String estadoFinalPartida = "";
        
                while (true){
                    //turno jugador1
                    System.out.println("-Turno del jugador 1(X)-");
                    ficha = 'X';
                    numeroColumna = GUI.validarJugada(tableroPublico);
                    partida1.LlenarCasilla(numeroColumna, tableroPublico, ficha);
                    partida1.setTableroPrivado(tableroPublico);
                    tableroPublico = partida1.getTableroPrivado();
                    GUI.MostrarTablero(tableroPublico);
                    if (partida1.ComprobarGanador(tableroPublico, ficha)){
                        estadoFinalPartida = "Ganador: jugador 1" + "(" + ficha + ")";
                        break;
                    }
                    else if(partida1.ComprobarEmpate(tableroPublico)){
                        estadoFinalPartida = "Empate.";
                        break;
                    }
            
                    //turno jugador2
                    System.out.println("-Turno del jugador 2(O)-");
                    ficha = 'O';
                    numeroColumna = GUI.validarJugada(tableroPublico);
                    partida1.LlenarCasilla(numeroColumna, tableroPublico, ficha);
                    partida1.setTableroPrivado(tableroPublico);
                    tableroPublico = partida1.getTableroPrivado();
                    GUI.MostrarTablero(tableroPublico);
                    if (partida1.ComprobarGanador(tableroPublico, ficha)){
                        estadoFinalPartida = "Ganador: jugador 2" + "(" + ficha + ")";
                        break;
                    }
                    else if(partida1.ComprobarEmpate(tableroPublico)){
                        estadoFinalPartida = "Empate.";
                        break;
                    }
                }
                System.out.println(estadoFinalPartida);
            }
            
            else if(opcion == 2){
                GUI.Reglas();
            }
            else if(opcion == 3){
                continuarPrograma = false;
            }
        }
    }
}
