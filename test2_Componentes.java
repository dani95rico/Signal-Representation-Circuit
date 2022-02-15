/* Programa de prueba de la Practica 6 Fase 2 
 * 
 * @author PRL, DTE-UPM
 * @version 1.1
 */

import java.util.Scanner;

import componentes.CircuitoSerie;
import componentes.Condensador;
import componentes.Diodo;
import componentes.ITransferencia;
import componentes.PuenteDiodos;
import generadores.GeneradorSe�al;
import generadores.GeneradorSe�alSinusoidal;
import generadores.GeneradorSe�alSinusoidalConSaturacion;
import generadores.GeneradorSe�alTriangular;

public class P6F2Componentes {

	public static void main(String[] args) {
		final int NUMEROMUESTRAS = 1000;
		final double F = 2.0 / NUMEROMUESTRAS;
		GeneradorSe�al generador = null;
		String tipoGenerador, tipoComponente;
		ITransferencia componente = null;
		Scanner sc = new Scanner(System.in);
		CircuitoSerie circuito=new CircuitoSerie(2);
		circuito.addComponente(new PuenteDiodos("Puente Diodos 1"));
		circuito.addComponente(new Condensador("Condensador 1"));
		System.out.print("Teclee tipo (T o S o U):");
		tipoGenerador = sc.nextLine().toUpperCase();
		if (!tipoGenerador.equals("T") && !tipoGenerador.equals("S") && !tipoGenerador.equals("U")) {
			System.out.println("El tipo de generador especificado no es correcto.");
		} else {
			System.out.print("Teclee Componente (C,D,P,S):");
			tipoComponente = sc.nextLine().toUpperCase();
			if (!tipoComponente.equals("C") && !tipoComponente.equals("D") && !tipoComponente.equals("P") && !tipoComponente.equals("S")) {
				System.out.println("El tipo de componente especificado no es correcto.");
			} else {
				switch (tipoGenerador) {
				  case "T":
					generador = new GeneradorSe�alTriangular("Triangular", F);
					break;
				  case "S":
					generador = new GeneradorSe�alSinusoidal("Sinusoidal", F, 0);
					break;
				  case "U":
					generador = new GeneradorSe�alSinusoidalConSaturacion(
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
				  case "S":
					componente=circuito;
					 break;
				}
				// Mostrar la sonda con la señal de salida del componente
				mostrarSonda(generador, componente, NUMEROMUESTRAS);

			}
		}
		sc.close();
	}

	/**
	 * Muestra en la sonda gráfica el resultado de aplicar la señal del
	 * generador sobre el componente, con el número de muestras indicado. En el titulo
	 * de la ventana gráfica se añadirá el nombre del componente si el parámetro 
	 * componente es de clase Componente ó el texto fijo "ITransferencia" en
	 * cualquier otro caso.
	 * 
	 * @param generador
	 *            es el generador de señal a utilizar
	 * @param componente
	 *            es el componente al que aplicar la señal del generador
	 * @param muestras
	 *            es el número de muestras a mostrar en la ventana gráfica
	 */
	private static void mostrarSonda(GeneradorSe�al generador,
			ITransferencia componente, int muestras) {
		//  Rellenar por el alumno
		if(componente instanceof CircuitoSerie)
		{
			SondaGrafica sonda=new SondaGrafica(componente.toString(),5);
			for(int i=0;i<muestras;i++)
			{
				
				sonda.addMuestra(componente.getSalida(generador.getSalida()));
			}
		}
		else
		{
			SondaGrafica sonda=new SondaGrafica("Sonda Gráfica",5);
			for(int i=0;i<muestras;i++)
			{
				
				sonda.addMuestra(componente.getSalida(generador.getSalida()));
			}
		}
	}

}
