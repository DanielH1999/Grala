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
		
		int CantJugadores = 0;
		
		int Turnos = 3; //Cantidad de turnos (3 para default)
		
		int MultServido = 1; //MULTIPLICADOR DE JUGADA SERVIDA (1 para default)
		
		int Servido = 5 * MultServido; //valor de jugada servida
		
		int Turno = 0; //TURNO ACTUAL

		//String[] Jugador = jugadores(CantJugadores);
		
		
		//System.out.println(Jugador[0] + " lanza con la fuerza de 10 locomotoras...");
						
//		int[] Dados = lanzar(CantDados); //hago un array de numeros al azar

		
//		//DEBUG
//		int[] Dados = new int[CantDados];
//		System.out.println("dados");
//		for (int i = 0; i < CantDados; i++)
//		{
//			Dados[i] = leer.nextInt();
//		}
//		//GUBED
		
		//CULOS
		
		
		mostrarDados(Dados, CantDados);
		Turno++;
		
		
		//reintentar(Dados, Turnos, Turno, CantDados);
		
		
		int[] Estado = new int[13]; //Declaracion y asignacion de memoria
			//Estado[0] numero de jugador
			//Estado[1~6] cantidad de Dados del mismo numero que el indice
			//Estado[7~12] escalera~generala doble
			//Estado[13] total
		
		String[] EstadoTitulo = 
		{"Jugador","1","2","3","4","5","6",
		"Escalera","Full","Poker","Generala","Generala Doble","Totales"};
		
		if (Turno > 1)
		{
			Servido = 0;
		}

		
		resultados(Estado, Dados, CantDados, Servido, Turno);

		
		//dar a elegir la categoria al usuario cuando corresponda
		
		System.out.println("Podes...");
		
		for (int i = 1; i < (Estado.length - 2); i++)
		{
			System.out.print(i + " -> ");
			if (Estado[i] > 0)
			{
				System.out.print("Anotar al ");
				System.out.println(EstadoTitulo[i] + ": " + Estado[i] + " puntos");
			}
			else
			{
				System.out.print("Tachar ");
				System.out.println(EstadoTitulo[i]);
			}
		}
		
		//calcular total de puntos
		
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
		Arrays.sort(Dados);
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
	
	private static void reintentar(int[] Dados, int Turnos, int Turno, int CantDados)
	{
		Scanner leer = new Scanner(System.in);
		
		while (Turnos > Turno)
		{
			System.out.println("¿Queres volver a lanzar algun dado? (S)");

			if (leer.next().equalsIgnoreCase("s"))
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

				System.out.println("Nuevos dados: ");
				
				mostrarDados(Dados, CantDados);
				Turno++;
			}
			else
			{
				break;
			}
		}
	}

	private static String[] jugadores(int CantJugadores)
	{
		Scanner leer = new Scanner(System.in);
		
		String nombres = "";
		
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

	private static int resultados(int[] Estado, int[] Dados, int CantDados, int Servido, int Turno)
	{
		for (int DadoActual = 0; DadoActual < CantDados; DadoActual++)
		{
			switch (Dados[DadoActual])
			{
				case 1:
					Estado[1]+=1;
					break;
					
				case 2:
					Estado[2]+=2;
					break;
					
				case 3:
					Estado[3]+=3;
					break;
					
				case 4:
					Estado[4]+=4;
					break;
					
				case 5:
					Estado[5]+=5;
					break;
					
				case 6:
					Estado[6]+=6;
					break;	
				//Terminan los numeros posibles de los dados
				//mas adelante en estado estan las jugadas mayores
			}
		}
		
		//buscar jugadas mayores

		for (int a = 1; a <= 6; a++)
		{
			if (Estado[a] == a*5) //busco generala una vez
			{
				//[a][a][a][a][a]
				if(Estado[10] == 0)
				{
					Estado[10] = 60; //si es servida gana el juego

					if (Turno == 1)
					{
						return 1;
					}
					//AGREGAR GENERALA DOBLE?
				}
			}

			if (Estado[a] == a*4) //busco poker una vez
			{
				//[a][a][a][a] y [x]
				Estado[9] = 40 + Servido;
			}				

			if (Estado[a] == a*2 || Estado[a] == a*3) //busco full un maximo de 2 veces
			{
				for (int b = 1; b <= 6; b++)
				{
					if (Estado[b] != Estado[a])
					{
						if (Estado[b] == b*2 && Estado[a] == a*3 || Estado[b] == b*3 && Estado[a] == a*2)
						{
							//[a][a][a] y [b][b]
							Estado[8] = 30 + Servido;
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
			Estado[7] = 20 + Servido;
		}
		
		System.out.println("");
		
		return 0;
	}
}
