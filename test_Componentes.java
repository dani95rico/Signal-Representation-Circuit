/** 
 * Programa de prueba de la Practica 6 Fase 1 
 * 
 * @author PRL, DTE-UPM
 * @version 1.1
 */

import java.util.Scanner;

import componentes.Condensador;
import componentes.Diodo;
import componentes.ITransferencia;
import componentes.PuenteDiodos;
import generadores.GeneradorSeñal;
import generadores.GeneradorSeñalSinusoidal;
import generadores.GeneradorSeñalSinusoidalConSaturacion;
import generadores.GeneradorSeñalTriangular;

public class P6F1Componentes {

	public static void main(String[] args) {
		final int NUMEROMUESTRAS = 1000;
		final double F = 2.0 / NUMEROMUESTRAS;
		GeneradorSeñal generador = null;
		String tipoGenerador, tipoComponente;
		ITransferencia componente = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Teclee tipo (T o S o U):");
		tipoGenerador = sc.nextLine().toUpperCase();
		if (!tipoGenerador.equals("T") && !tipoGenerador.equals("S") && !tipoGenerador.equals("U")) {
			System.out.println("El tipo de generador especificado no es correcto.");
		} else {
			System.out.print("Teclee Componente (C,D,P):");
			tipoComponente = sc.nextLine().toUpperCase();
			if (!tipoComponente.equals("C") && !tipoComponente.equals("D") && !tipoComponente.equals("P")) {
				System.out.println("El tipo de componente especificado no es correcto.");
			} else {
				switch (tipoGenerador) {
				  case "T":
					generador = new GeneradorSeñalTriangular("Triangular", F);
					break;
				  case "S":
					generador = new GeneradorSeñalSinusoidal("Sinusoidal", F, 0);
					break;
				  case "U":
					generador = new GeneradorSeñalSinusoidalConSaturacion(
							"Sinusoidal con umbral", F, 0, 0.8);
				}
				switch (tipoComponente) {
				  case "C":
					componente = new Condensador("Condensador 1");
					break;
				  case "D":
					componente = new Diodo("Diodo 1");
					break;
				  case "P":
					componente = new PuenteDiodos("Puente 1");
					break;			
				}
				// Mostrar la sonda con la seÃ±al de salida del componente
				mostrarSonda(generador, componente, NUMEROMUESTRAS);

			}
		}
		sc.close();
	}

	/**
	 * Muestra en la sonda grÃ¡fica el resultado de aplicar la seÃ±al del
	 * generador sobre el componente, con el nÃºmero de muestras indicado. En el titulo
	 * de la ventana grÃ¡fica se aÃ±adirÃ¡ el nombre del componente si el parÃ¡metro 
	 * componente es de clase Componente Ã³ el texto fijo "ITransferencia" en
	 * cualquier otro caso.
	 * 
	 * @param generador
	 *            es el generador de seÃ±al a utilizar
	 * @param componente
	 *            es el componente al que aplicar la seÃ±al del generador
	 * @param muestras
	 *            es el nÃºmero de muestras a mostrar en la ventana grÃ¡fica
	 */
	private static void mostrarSonda(GeneradorSeñal generador,
			ITransferencia componente, int muestras) {
		//  Rellenar por el alumno
		
			SondaGrafica sonda=new SondaGrafica("Sonda Grï¿½fica",5);
			for(int i=0;i<muestras;i++)
			{
				
				sonda.addMuestra(componente.getSalida(generador.getSalida()));
			}
		
	}

}
