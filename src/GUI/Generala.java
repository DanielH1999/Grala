/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author danielh
 */
public class Generala
{
	public int turnos = 3;
	
	public boolean jugadaServida;
	
	public String ganador;
	
	public int[] jugadasPosibles = new int[11];
	
	public int[] dados = new int[5]; //DEBUG [5][5][5][4][3]
	
	public int[] guardados = new int[5];

	public String[] jugadores;
	
	public int[][] tablaPuntajes; //Puntuaciones de los jugadores
		//tablaPuntajes[jugador][0] numero de jugador
		//tablaPuntajes[jugador][1~6] cantidad de dados del mismo numero que el indice
		//tablaPuntajes[jugador][7~10] escalera~generala
		//tablaPuntajes[jugador][11] total

	public boolean[][] jugadaHecha;
	
	public String[] tituloPuntajes = {"jugador","1","2","3","4","5","6",
		"Escalera","Full","Poker","Generala","Total"};

	public Generala(String[] nombres)
	{
		jugadores = nombres;
		
		tablaPuntajes = new int[jugadores.length][tituloPuntajes.length];
		
		for (int i = 1; i < tablaPuntajes.length; i++)
		{
			tablaPuntajes[i][0] = i - 1;
		}
	}
	
	public int[] lanzar(int veces)
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

	public int[] cambiarDados(int[] dados)
	{
		int[] cambiados = lanzar(dados.length); //obtener los dados a reemplazar

		for (int i = 0; i < dados.length; i++)
		{ 
			dados[i] = cambiados[i]; //lo cambiamos 
		}
		return dados;
	}
	
	public void calcularJugadas(int[] jugadasPosibles, int[] dados, int Turno)
	{
		int Servido = 5;
		
		Arrays.sort(dados);
		
		for (int DadoActual = 0; DadoActual < dados.length; DadoActual++)
		{
			switch (dados[DadoActual])
			{
				case 1:
					jugadasPosibles[1]+=1;
					break;
					
				case 2:
					jugadasPosibles[2]+=2;
					break;
					
				case 3:
					jugadasPosibles[3]+=3;
					break;
					
				case 4:
					jugadasPosibles[4]+=4;
					break;
					
				case 5:
					jugadasPosibles[5]+=5;
					break;
					
				case 6:
					jugadasPosibles[6]+=6;
					break;	
				//Terminan los numeros posibles de los dados
				//mas adelante en jugadasPosibles[] estan las jugadas mayores
			}
		}
		
		for (int a = 1; a <= 6; a++)
		{
			if (jugadasPosibles[a] == a*5) //busco generala una vez
			{
				//[a][a][a][a][a]
				if(jugadasPosibles[10] == 0)
				{
					if (Turno == 1) //si es generala servida, gana automaticamente
					{
						ganador = jugadores[a];
						break;
					}
					
					jugadasPosibles[10] = 60;
				}
			}

			if (jugadasPosibles[a] == a*4) //busco poker una vez
			{
				//[a][a][a][a] y [x]
				jugadasPosibles[9] = 40 + Servido;
			}				

			if (jugadasPosibles[a] == a*2 || jugadasPosibles[a] == a*3) //busco full un maximo de 2 veces
			{
				for (int b = 1; b <= 6; b++)
				{
					if (a != b)
					{
						if (jugadasPosibles[b] == b*2 && jugadasPosibles[a] == a*3 || jugadasPosibles[b] == b*3 && jugadasPosibles[a] == a*2)
						{
							//[a][a][a] y [b][b]
							jugadasPosibles[8] = 30 + Servido;
						}	
					}				
				}		
			}
		}
		
		int[] escalera = {1,2,3,4,5};
		int contEscalera = 0;
		
		for (int d = 0, last = dados[d] - 1; d < dados.length; d++) //busco escalera una vez
		{
				if ((dados[d] == escalera[d] || dados[d] == (escalera[d]+1)) && last == dados[d] - 1)
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
			jugadasPosibles[7] = 20 + Servido;
		}
		
		//System.out.println("Jugadas posibles: "+Arrays.toString(jugadasPosibles)); //DEBUG
	}
	
	public int[] getSeleccionable(int[] jugadasPosibles, int jugador)
	{
		int[] seleccionable = new int[jugadasPosibles.length];
				
		for (int i = 1; i < jugadasPosibles.length; i++)
		{
			if (jugadasPosibles[i] > 0 && tablaPuntajes[jugador][i] == 0) //si hay posibilidad y disponibilidad
			{
				seleccionable[i] = 1; //puntuable
			}
			else if (jugadasPosibles[i] == 0 && tablaPuntajes[jugador][i] == 0) //si no hay posibilidad pero hay disponibilidad
			{
				seleccionable[i] = -1; //tachable
			}
		}
		
		return seleccionable;
	}
	
	public boolean puntuar(String[] tituloPuntajes, int[] jugadasPosibles, int[][] tablaPuntajes, int jugador, int seleccion)
	{
		//System.out.println("tablaPuntajes["+jugadores.length+"]<-"+jugador); //DEBUG
		if (tablaPuntajes[jugador][seleccion] > 0)
		{
			limpiar();
			return false;
		}
		else if (tablaPuntajes[jugador][seleccion] == 0 && jugadasPosibles[seleccion] > 0)
		{
			//System.out.println("Generala ingresando numero en tabla"); //DEBUG
			
			tablaPuntajes[jugador][seleccion] += jugadasPosibles[seleccion];
			
			//System.out.println("Anotado: " + tablaPuntajes[jugador][seleccion] + " puntos al " + tituloPuntajes[seleccion]); //DEBUG
			
			limpiar();
			return true;
		}
		else if (tablaPuntajes[jugador][seleccion] == 0)
		{
			//System.out.println("marcando para tachar"); //DEBUG
			
			tablaPuntajes[jugador][seleccion] = -1;
			limpiar();
			return true;
		}
		return false;
	}
	
	public void limpiar()
	{
		for (int i = 0; i < jugadasPosibles.length; i++)
		{
			jugadasPosibles[i] = 0;
		}
	}
	
	public static int determinarGanador(String[] jugadores, int[][] tablaPuntajes)
	{
		//calcular totales
		for (int jugador = 0; jugador < jugadores.length; jugador++)
		{
			for (int i = 1; i <= 11; i++)
			{
				if (tablaPuntajes[jugador][i] > 0)
				{
					tablaPuntajes[jugador][11] += tablaPuntajes[jugador][i];
				}
			}
		}
		
		int Ganador = 0;
		int Max = tablaPuntajes[0][11];
		
		//calcular ganador
		for (int i = 0; i < jugadores.length; i++)
		{
			if (tablaPuntajes[i][11] >= 1000)
			{
				Ganador = i;
				Max = tablaPuntajes[i][11];
				break;
			}
			if (Max < tablaPuntajes[i][11])
			{
				Ganador = i;
				Max = tablaPuntajes[i][11];
			}
		}
		
		return Ganador;
	}
}