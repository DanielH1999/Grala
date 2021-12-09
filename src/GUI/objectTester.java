/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Arrays;

/**
 *
 * @author danielh
 */
public class objectTester
{
	
	public static Generala generala;
	
	public static void main(String[] args)
	{
		String[] nombres = new String[1];
		
		nombres[0] = "test";
		
		generala = new Generala(nombres);
		
		for (int i = 0; i < generala.dados.length; i++)
		{
			generala.dados[i] = i+1;
		}
		
		generala.calcularJugadas(generala.jugadasPosibles, generala.dados, 1);
		
		System.out.println(Arrays.toString(generala.dados));
		
		//testSelectable(); [PASSED]
	}

	private static void testSelectable()
	{
		int[] selectable = generala.getSeleccionable(generala.jugadasPosibles, 0);
		
		for (int i = 0; i < (generala.jugadasPosibles.length -1); i++)
		{
			System.out.print(generala.tituloPuntajes[i+1]+" ");
			switch (selectable[i])
			{
				case -1:
					System.out.print("Tach"); //tachable
					break;
				case 0:
					System.out.print("noSel"); //no seleccionable
					break;
				case 1:
					System.out.print("Punt"); //puntuable
					break;
			}
			System.out.println("");
		}
	}
}
