/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author danielh
 */
public class CLI
{
	public static void main(String[] args)
	{
		Scanner leer = new Scanner(System.in);
		
		int CantDados = 5; //TOTAL DE DADOS
		
		int CantJugadores = 0; //TOTAL DE JUGADORES
		
		int Turnos = 3; //TOTAL DE TURNOS
		
		int MultServido = 1; //MULTIPLICADOR DE JUGADA SERVIDA

		
		int Turno = 0; //TURNO ACTUAL

		String[] Jugador = jugadores(CantJugadores);
		
		
		System.out.println(Jugador[0] + " lanza con la fuerza de 10 locomotoras...");
						
//		int[] Dados = lanzar(CantDados); //hago un array de numeros al azar
		
//		int[] Dados = {1,2,3,4,5}; //DEBUG Escalera
//		int[] Dados = {1,1,4,4,4}; //DEBUG Full
//		int[] Dados = {2,4,4,4,4}; //DEBUG Poker
//		int[] Dados = {1,1,1,1,1}; //DEBUG Generala
		int[] Dados = {1,1,1,5,6}; //DEBUG
		
		//CULOS
		
		mostrarDados(Dados, CantDados);
		Turno++;
		
		reintentar(Dados, Turnos, Turno, CantDados);
		
		//FIJARSE SI EL USUARIO GANO ALGO
		
		int[] Estado = new int[13]; //INICIALIZAR
		//Estado[0] numero de jugador
		//Estado[1~6] cantidad de Dados del mismo numero que el indice
		//Estado[7~12] escalera~generala doble
		//Estado[13] total
		
		String[] EstadoTitulo = 
		{"Jugador","1","2","3","4","5","6",
		"Escalera","Full","Poker","Generala","Generala Doble","Totales"};
				
		int Servido = 5 * MultServido;
		
		if (Turno > 1)
		{
			Servido = 0;
		}
		
		resultados(Estado, Dados, CantDados, Servido);
		
		//dar a elegir la categoria al usuario cuando corresponda
		
		System.out.println("Podes...");
		
		for (int i = 1; i < Estado.length; i++)
		{
			if (Estado[i] > 0)
			{//IGNORAR Generala2 si no tiene Generala1
				System.out.print("Anotar al ");
				System.out.println(EstadoTitulo[i] /*+ EsServida*/ + ": " + 
									Estado[i] + " puntos");
			}
//			else
//			{
//				System.out.print("Tachar ");
//				System.out.println(EstadoTitulo[i]);
//			}
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

	private static void resultados(int[] Estado,int[] Dados, int CantDados, int Servido)
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
				////////////////////////////Terminan los numeros
			}
		}
		
		//REVISAR SI HAY JUGADAS ESPECIALES
		for (int i = 1, c = 0; i < CantDados; i++) //(1;CantDados)
		{
			for (int j = i + 1; j <= CantDados; j++) //(2;CantDados]
			{
				if (Dados[i] == Dados[j]) //si algun dado es igual a otro
				{//no es escalera
					c++;
				//si es full
				//si es poker
				//si es generala o generala doble
				}
				else if (i == CantDados - 1 && c == 0) //si terminaste y son todos diferentes
				{
					Estado[7] = 20 + Servido; //es escalera
				}
			}
		}
	}
}
