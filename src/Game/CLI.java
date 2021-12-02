/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author danielh
 */
//POSIBLES MEJORAS:
//mejorar repeticion de codigo del selector de jugadas
//preguntar al usuario si esta seguro de que esos son los dados que quiere cambiar

public class CLI
{
	public static void main(String[] args)
	{
		Scanner leer = new Scanner(System.in);
		
		boolean culosActivados = false;
		
		int cantDados = 5;
		
		int cantCulos = 0;
		
		int Turnos = 3; //Cantidad de turnos (default: 3)
		
		int MultServido = 1; //Multiplicador de servido (default: 1)
		
		int Servido = 5 * MultServido; //valor de jugada servida
		
		String[] Jugador = jugadores(); //Lista de jugadores
	
		int[][] Puntajes = new int[Jugador.length][13]; //Puntuaciones de los jugadores
			//Puntajes[jugador][0] numero de jugador
			//Puntajes[jugador][1~6] cantidad de Dados del mismo numero que el indice
			//Puntajes[jugador][7~10] escalera~generala
			//Puntajes[jugador][11] vacio
			//Puntajes[jugador][12] total

		String[] tituloPuntajes = {"Jugador","1","2","3","4","5","6",
			"Escalera","Full","Poker","Generala","Generala Doble","Total"};

		
		for (int a = 0; a < Jugador.length; a++) //inicializar tabla de putajes
		{
			Puntajes[a][0] = a; //poner numero de jugador en la primera columna
		}
		
		int cantJugadas = 10; //para modos de juego futuros

		for (int vecesJugadas = 0; vecesJugadas < cantJugadas; vecesJugadas++)
		{
			for (int jugador = 0; jugador < Jugador.length; jugador++)
			{
				int[] Dados = lanzar(5); //hago un array de numeros al azar
				
				boolean continuar = true;
				for (int Turno = 0; Turno <= Turnos && continuar; Turno++)
				{
					int[] Posibles = new int[cantJugadas+1];

					
					System.out.println("Turno de " + Jugador[jugador] + "\n");
					
					if (culosActivados)
					{
						System.out.print("Cantidad de culos (0 para ninguno): ");
						
						cantCulos = leer.nextInt();
					}
					
					System.out.println(Jugador[jugador] + " lanza con "+frase());					
					
					Arrays.sort(Dados);
					mostrarDados(Dados, cantDados);
					
					if (culosActivados)
					{
						culos(Dados, cantCulos, cantDados);
					}
					
					Turno++;
					System.out.println("Turno: " + Turno + "/" + Turnos);


					continuar = reintentar(Dados, Turnos, Turno, cantDados, cantCulos, Posibles, culosActivados);
					
					Turno += Posibles[0];
					System.out.println("Turno: " + Turno + "/" + Turnos);
					

					mostrarDados(Dados, cantDados);
					
					if (Turno > 1)
					{
						Servido = 0;
					}


					resultados(Posibles, tituloPuntajes, Puntajes, Dados, Jugador, jugador, cantDados, cantJugadas, Servido, Turno);
				}
			}
		}
		determinarGanador(Jugador, Puntajes, tituloPuntajes);
	}
	
	public static int[] lanzar(int veces)
	{
		Random azar = new Random();

		int[] resultado = new int[veces];
		
		for (int i = 0; i < veces; i++)
		{
			resultado[i] = 1+azar.nextInt(6);
			//System.out.println("resultado " + i + " = " + resultado[i]);//OUTPUT ON ASK
		}
		
		return resultado;
	}
	
	public static void mostrarDados(int[] Dados, int cantDados)
	{		
		for (int i = 0; i < cantDados; i++) //por cada dado que haya
		{
			if (Dados[i] == 0) //si algun dado esta marcado
			{
				System.out.print("x "); //mostrarlo como una x
				
				continue; //avanzar en el for
			}
			System.out.print(Dados[i] + " "); //si no esta marcado, mostrar el dado			
		}
		System.out.println(""); //imprimir una linea nueva
	}
	
		private static String frase()
	{
		Random elegir = new Random();
		
		String frase = null;
		
		switch (elegir.nextInt(9))
		{
			case 0:
				frase = "el poder de una barra de carbono";
				break;
			case 1:
				frase = "la dedicacion de 20 chinos";
				break;
			case 2:
				frase = "la potencia de una locomotora a vapor";
				break;
			case 3:
				frase = "la fuerza de 10 viejos con impotencia";
				break;
			case 4:
				frase = "la fuerza de una patada en la piña"; //contribucion de Tobias Rossi
				break;
			case 5:
				frase = "la motivacion de alguien yendo a cobrar"; //contribucion de Tobias Rossi
				break;
			case 6:
				frase = "la esperanza de un argentino en elecciones"; //contribucion de Tobias Rossi
				break;
			case 7:
				frase = "el poder de un choripan en las masas"; //contribucion de Tobias Rossi
				break;
			case 8:
				frase = "la falsa ilusion de que salga generala"; //contribucion de Tobias Rossi
				break;
			default:
				throw new AssertionError();
		}
		return frase;
	}
	
	private static void culos(int[] Dados, int cantCulos, int cantDados)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		//las caras contrarias de los dados suman 7
		//preguntar cuantos culos antes de la primera tirada
		
/*		if (cantCulos == 0)
		{
			return; //evitar todo el proceso y salir de la funcion
		}
		
		Scanner leer = new Scanner(System.in);
		
		int[] culos = new int[cantCulos];
		
		System.out.print("Dados: ");
		
		mostrarDados(Dados, cantDados);
		
		System.out.print("Culos: ");
		for (int dado = 0; dado < cantDados; dado++)
		{
			culos[dado] = (7 - Dados[dado]);
			System.out.print(culos[dado] + " ");
		}
		System.out.println("");
		
		System.out.println("Selecciona tus culos:");
		
		int selection;
		
		for (int i = 0; i < cantCulos; i++)
		{
			do
			{
				System.out.print("culo " + i + ": ");
				selection = leer.nextInt();
			}
			while (selection < 1 || selection > cantDados);
			
			Dados[selection] = culos[i];
		}
*/	}
	
	private static boolean reintentar(int[] Dados, int Turnos, int Turno, int cantDados, int cantCulos, int[] Posibles, boolean culosActivados)
	{
		Scanner leer = new Scanner(System.in);
		
		int reintentar;

		while (Turnos > Turno)
		{
			do
			{
				System.out.println("""
					1 - volver a tirar
					2 - continuar
					""");

				reintentar = leer.nextInt();
			}
			while (reintentar != 1 && reintentar != 2);

			if (reintentar == 1)
			{
				Posibles[0]++;
				Turno++;

				int DadosACambiar = 0;
				
				if (culosActivados)
				{
					System.out.print("Cantidad de culos (0 -> ninguno): ");

					cantCulos = leer.nextInt();
				}
				
				System.out.println("¿Que Dados queres cambiar? (0 -> terminar)");

				mostrarDados(Dados, cantDados);

				int x;

				for (int i = 0; i < cantDados; i++)
				{
					x = leer.nextInt();

					if (x < 0 || x > cantDados) //si el numero ingresado no corresponde a ningun dado
					{
						i -= 1;
						System.out.println("NUMERO INVALIDO IGNORADO");
					}
					else if (x == 0) //si el numero ingresado es un 0
					{
						break; //dejar de pedir numeros
					}
					else //si el usuario ingresa un numero que corresponde a un dado
					{
						Dados[x - 1] = 0; //marcar el dado a cambiar con un 0
						DadosACambiar++; //incrementar el contador de dados a cambiar

						System.out.print("Dados seleccionados: ");
						mostrarDados(Dados, cantDados);
					}
				}

				int[] cambiados = lanzar(DadosACambiar); //obtener los dados a reemplazar

				for (int i = 0, j = 0; i < cantDados; i++)
				{ 
					if (Dados[i] == 0) //si el dado actual es un 0
					{
						Dados[i] = cambiados[j]; //lo cambiamos 
						j++; //vamos al siguiente elemento del array cambiados
					}
				}
			}
			else
			{
				break;
			}
			System.out.println("Turno " + Turno + "/" + Turnos);
			
			Arrays.sort(Dados);
			
			mostrarDados(Dados, cantDados);
			
			if (culosActivados)
			{
				culos(Dados, cantCulos, cantDados);
			}
		}
		return false;
	}

	public static String[] jugadores()
	{
		Scanner leer = new Scanner(System.in);
		
		String nombres = "";
		
		int CantJugadores = 0;
		
		while (true)
		{
			System.out.print("Jugador " + (CantJugadores + 1) + ": ");
			
			nombres += leer.next();
			
			CantJugadores++;
			
			System.out.println("[+] - Agregar jugador");
			
			if (!(leer.next().equals("+")))
			{
				break;
			}
			nombres += ", ";
		}
		String[] Jugador = nombres.split(", ");
				
		return Jugador;
	}

	private static void resultados(int[] Posibles, String[] tituloPuntajes, int[][] Puntajes, int[] Dados, String[] Jugador, int jugador, int cantDados, int cantJugadas, int Servido, int Turno)
	{				
		for (int DadoActual = 0; DadoActual < cantDados; DadoActual++)
		{
			switch (Dados[DadoActual])
			{
				case 1:
					Posibles[1]+=1;
					break;
					
				case 2:
					Posibles[2]+=2;
					break;
					
				case 3:
					Posibles[3]+=3;
					break;
					
				case 4:
					Posibles[4]+=4;
					break;
					
				case 5:
					Posibles[5]+=5;
					break;
					
				case 6:
					Posibles[6]+=6;
					break;	
				//Terminan los numeros posibles de los dados
				//mas adelante en Posibles[] estan las jugadas mayores
			}
		}
		
		for (int a = 1; a <= 6; a++)
		{
			if (Posibles[a] == a*5) //busco generala una vez
			{
				//[a][a][a][a][a]
				if(Posibles[10] == 0)
				{
					if (Turno == 1) //si es generala servida, gana automaticamente
					{
						Puntajes[jugador][12] += 1000;
						determinarGanador(Jugador,Puntajes,tituloPuntajes);
					}
					
					Posibles[10] = 60;
				}
			}

			if (Posibles[a] == a*4) //busco poker una vez
			{
				//[a][a][a][a] y [x]
				Posibles[9] = 40 + Servido;
			}				

			if (Posibles[a] == a*2 || Posibles[a] == a*3) //busco full un maximo de 2 veces
			{
				for (int b = 1; b <= 6; b++)
				{
					if (a != b)
					{
						if (Posibles[b] == b*2 && Posibles[a] == a*3 || Posibles[b] == b*3 && Posibles[a] == a*2)
						{
							//[a][a][a] y [b][b]
							Posibles[8] = 30 + Servido;
						}	
					}				
				}		
			}
		}
		
		int[] escalera = {1,2,3,4,5};
		int contEscalera = 0;
		
		for (int d = 0, last = Dados[d] - 1; d < cantDados; d++) //busco escalera una vez
		{
				if ((Dados[d] == escalera[d] || Dados[d] == (escalera[d]+1)) && last == Dados[d] - 1)
				{
					contEscalera++;
					last++;
				}
				else
				{
					break;
				}
		}
		
		if (contEscalera == 5) //si el patron esta completo
		{
			//[1][2][3][4][5] o [2][3][4][5][6]
			Posibles[7] = 20 + Servido;
		}
		
		System.out.println("");
		
		elegirPuntaje(tituloPuntajes, cantJugadas, Posibles, Puntajes, jugador);
	}

	private static void elegirPuntaje(String[] tituloPuntajes, int cantJugadas, int[] Posibles, int[][] Puntajes, int jugador)
	{
		//dar a elegir la categoria al usuario cuando corresponda
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Elegi: ");
		
		for (int i = 1; i <= cantJugadas; i++)
		{
			
			if (Posibles[i] > 0)
			{
				System.out.print(i + " -> ");
				if (Puntajes[jugador][i] > 0)
				{
					System.out.println(Puntajes[jugador][i]);
				}
				else if (Puntajes[jugador][i] == 0)
				{
					System.out.println("Anotar " + Posibles[i] + " puntos al " + tituloPuntajes[i]);
				}
				else
				{
					System.out.println("Tachado");
				}
				
			}
			else if (Posibles[i] == 0)
			{
				System.out.print(i + " -> ");
				if (Puntajes[jugador][i] > 0)
				{
					System.out.println(Puntajes[jugador][i]);
				}
				else if (Puntajes[jugador][i] == 0)
				{
					System.out.println("Tachar " + tituloPuntajes[i]);
				}
				else
				{
					System.out.println("Tachado");
				}
				
			}
		}
		
		int choice;
		
		do //dar a elegir que hacer
		{
			do //parar choice si esta fuera del rango de eleccion
			{
				choice = leer.nextInt();
				
				if (choice < 1 || choice > cantJugadas)
				{
					System.out.println("Fuera del menu...");
				}
			}
			while (choice < 1 || choice > cantJugadas);
			
			if (Puntajes[jugador][choice] != 0) //si ya se hizo a esa jugada
			{
				System.out.println("Jugada ya hecha:");
				if (Puntajes[jugador][choice] > 0)
				{
					System.out.println(tituloPuntajes[choice]+"|"+Puntajes[jugador][choice]);
				}
				else //si se tacho la jugada
				{
					System.out.println(tituloPuntajes[choice]+"|"+"-");
				}
			}
		}
		while (Puntajes[jugador][choice] != 0);
		
		Puntajes[jugador][choice] += Posibles[choice];

		if (Puntajes[jugador][choice] > 0)
		{
			System.out.println("Anotado: " + Puntajes[jugador][choice] + " puntos al " + tituloPuntajes[choice]);
		}
		else
		{
			System.out.println("Tachado: " + tituloPuntajes[choice]);
			Puntajes[jugador][choice] = -1;
		}
	}

	public static void determinarGanador(String[] Jugador, int[][] Puntajes, String[] tituloPuntajes)
	{
		//calcular totales
		for (int jugador = 0; jugador < Jugador.length; jugador++)
		{
			for (int i = 1; i <= 11; i++)
			{
				if (Puntajes[jugador][i] > 0)
				{
					Puntajes[jugador][12] += Puntajes[jugador][i];
				}
			}
		}
		
		String Ganador = Jugador[0];
		int Max = Puntajes[0][12];
		
		//calcular ganador
		for (int i = 0; i < Jugador.length; i++)
		{
			if (Puntajes[i][12] >= 1000)
			{
				Ganador = Jugador[i];
				Max = Puntajes[i][12];
				break;
			}
			if (Max < Puntajes[i][12])
			{
				Ganador = Jugador[i];
				Max = Puntajes[i][12];
			}
		}
		
		mostrartablero(tituloPuntajes, Jugador, Puntajes);
		
		if (Max >= 1000)
		{
			System.out.println("¡" +Ganador + " gano la partida por generala servida!");
		}
		else
		{
			System.out.println("¡" +Ganador + " gano la partida con " + Max + " puntos!");
		}
		System.exit(0);
	}
	private static void mostrartablero(String[] tituloPuntajes, String[] Jugador, int[][] Puntajes)
	{
		for (int x = 0; x < 13; x++)
		{
			if (x == 11)
			{
				continue;
			}
			System.out.print(tituloPuntajes[x]+": \t");

			switch (x)
			{
				case 1,2,3,4,5,6,8,9,12 -> System.out.print("\t");
			}
			
			for (int y = 0; y < Jugador.length; y++)
			{
				if (x > 0)
				{
					if (Puntajes[y][x] > 0)
					{
						System.out.print("|"+Puntajes[y][x]+"\t");
					}
					else
					{
						System.out.print("|"+"-"+"\t");
					}
				}
				else
				{
					System.out.print("|"+Jugador[y]+"\t");
				}
			}
			System.out.println("|");
		}
	}
}