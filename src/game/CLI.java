/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author danielh
 */
public class CLI
{
	public static void main(String[] args)
	{
		Scanner leer = new Scanner(System.in);
				
		int CantDados = 5;
		
		int Turnos = 3; //Cantidad de turnos (default: 3)
		
		int MultServido = 1; //Multiplicador de servido (default: 1)
		
		int Servido = 5 * MultServido; //valor de jugada servida
		
		String[] Jugador = jugadores(); //Lista de jugadores
		int[][] Puntajes = new int[Jugador.length][13]; //Puntuaciones de los jugadores

		String[] tituloPuntajes = 
		{"Jugador","1","2","3","4","5","6",
		"Escalera","Full","Poker","Generala","Generala Doble","Total"};

		
		for (int a = 0; a < Jugador.length; a++) //tabla inicial
		{
			Puntajes[a][0] = a; //poner numero de jugador en la primera columna
		}
		
		//Puntajes[jugador][0] numero de jugador
		//Puntajes[jugador][1~6] cantidad de Dados del mismo numero que el indice
		//Puntajes[jugador][7~10] escalera~generala
		//Puntajes[jugador][11] vacio
		//Puntajes[jugador][12] total

		int cantJugadas = 10; //para modos de juego futuros

		for (int vecesJugadas = 0; vecesJugadas < cantJugadas; vecesJugadas++)
		{
			for (int jugador = 0; jugador < Jugador.length; jugador++)
			{
				for (int Turno = 0; Turno <= Turnos; Turno++)
				{
					//System.out.println("[enter] para tirar tus dados");
					
					
					System.out.println(Jugador[0] + " lanza con la fuerza de 10 locomotoras...");


					int[] Dados = lanzar(CantDados); //hago un array de numeros al azar
					//22334 full debug
					//44466 full debug
					//13444 full debug
					//23356 poker debug
					//22555 poker debug
					//22222 generala debug
					//12256 generala debug
					//CULOS

					Arrays.sort(Dados);
					
					
					mostrarDados(Dados, CantDados);
					Turno++;


					Turno = reintentar(Dados, Turnos, Turno, CantDados);
					
					
					mostrarDados(Dados, CantDados);
					
					if (Turno > 1)
					{
						Servido = 0;
					}


					if (resultados(tituloPuntajes, Puntajes, Dados, jugador, CantDados, cantJugadas, Servido, Turno) == 1)
					{
						System.out.println("¡Generala servida, " + Jugador[jugador] + " gana!");
					}
				}
			}
		}

		determinarGanador(Jugador, Puntajes);
	}
	
	private static int[] lanzar(int veces)
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
	
	private static void mostrarDados(int[] Dados, int CantDados)
	{
		for (int i = 0; i < CantDados; i++) //por cada dado que haya
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
	
	private static int reintentar(int[] Dados, int Turnos, int Turno, int CantDados)
	{
		Scanner leer = new Scanner(System.in);
		
		while (Turnos > Turno)
		{
			int reintentar = 0;
			
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
				int DadosACambiar = 0;
				
				System.out.println("¿Que Dados queres cambiar? (0 para terminar)");
				
				mostrarDados(Dados, CantDados);
				
				int x;
					
				for (int i = 0; i < CantDados; i++)
				{
					x = leer.nextInt();
						
					if (x < 0 || x > CantDados)
					{
						i -= 1;
						System.out.println("NUMERO INVALIDO IGNORADO");
					}
					else if (x == 0)
					{
						break;
					}
					else
					{
						Dados[x - 1] = 0;
						DadosACambiar++;
						
						System.out.print("Dados seleccionados: ");
						mostrarDados(Dados, CantDados);
					}
				}

				//VOLVER A TIRAR LOS Dados SELECCIONADOS
				
				int[] cambiados = lanzar(DadosACambiar);
				
				for (int i = 0, j = 0; i < CantDados; i++)
				{ 
					if (Dados[i] == 0)
					{
						Dados[i] = cambiados[j];
						j++;
					}
				}

				Turno++;
				
				Arrays.sort(Dados);
				
				mostrarDados(Dados, CantDados);
			}
			else
			{
				Turno = Turnos;
				break;
			}
		}
		return Turno;
	}

	private static String[] jugadores()
	{
		Scanner leer = new Scanner(System.in);
		
		String nombres = "";
		
		int CantJugadores = 0;
		
		while (true)
		{
			System.out.print("Jugador " + (CantJugadores + 1) + ": ");
			
			nombres += leer.next();
			
			CantJugadores++;
			
			System.out.println("¿Agregar jugador? (S)");
			
			if (!(leer.next().equals("s")))
			{
				break;
			}
			nombres += ", ";
		}
		
		String[] Jugador = nombres.split(", ");
		
		return Jugador;
	}

	private static int resultados(String[] tituloPuntajes, int[][] Puntajes, int[] Dados, int jugador, int CantDados, int cantJugadas, int Servido, int Turno)
	{
		int[] Posibles = new int[cantJugadas+1];
		
		Posibles[0] = jugador;
				
		for (int DadoActual = 0; DadoActual < CantDados; DadoActual++)
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
				//mas adelante en Posibles[] estan las cantJugadas mayores
			}
		}
		
		//buscar cantJugadas mayores

		for (int a = 1; a <= 6; a++)
		{
			if (Posibles[a] == a*5) //busco generala una vez
			{
				//[a][a][a][a][a]
				if(Posibles[10] == 0)
				{
					Posibles[10] = 60; //si es servida gana el juego

					if (Turno == 1)
					{
						return 1;
					}
					//AGREGAR GENERALA DOBLE?
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
					if (Posibles[b] != Posibles[a])
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
		
		for (int d = 0, last = Dados[d] - 1; d < CantDados; d++) //busco escalera una vez
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
		
		return 0;
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
				System.out.println("Anotar " + Posibles[i] + " puntos al " + tituloPuntajes[i]);
			}
			else if (Posibles[i] == 0)
			{
				System.out.print(i + " -> ");
				System.out.println("Tachar " + tituloPuntajes[i]);
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
			
			if (Puntajes[jugador][choice] != 0) //si ya se jugo a esa jugada
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

	private static void determinarGanador(String[] Jugador, int[][] Puntajes)
	{
		//calcular totales
		for (int i = 1; i <= 11; i++)
		{
			for (int jugador = 0; jugador < Jugador.length; jugador++)
			{
				Puntajes[jugador][12] += Puntajes[jugador][i];
			}
		}
		
		String Ganador = Jugador[0];
		int Max = Puntajes[0][12];
		
		for (int i = 0; i < Jugador.length; i++)
		{
			
			if (Max < Puntajes[i][12])
			{
				Ganador = Jugador[i];
				Max = Puntajes[i][12];
			}
		}
		
		System.out.println("¡" +Ganador + " gano la partida con " + Max + " puntos!");
	}
}