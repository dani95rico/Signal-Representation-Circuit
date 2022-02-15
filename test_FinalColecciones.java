import java.util.Scanner;

import componentes.CircuitoSerie;
import componentes.ComponentesList;
import componentes.ComponentesMap;
import componentes.Condensador;
import componentes.Diodo;
import componentes.IComponentes;
import componentes.ITransferencia;
import componentes.PuenteDiodos;
import generadores.GeneradorSe�al;
import generadores.GeneradorSe�alSinusoidal;
import generadores.GeneradorSe�alSinusoidalConSaturacion;
import generadores.GeneradorSe�alTriangular;

public class P8FinalColecciones {

	public static void main(String[] args) throws MalFuncionamientoException {
		try
		{
			ITransferencia componente = null;
			int eleccion=Integer.parseInt(args[0]);
			IComponentes componentes;
			if(eleccion==1 || eleccion==2)
			{
				if(eleccion==1)
				{
					 componentes=new ComponentesList();
					 System.out.println("Se utilizar� una LISTA.");
				}
				else
				{
					 componentes=new ComponentesMap();
					 System.out.println("Se utilizar� un MAPA.");
				}
				
				componentes.AddComponente(new Diodo("Diodo 1"));
				componentes.AddComponente(new Diodo("Diodo 2"));
				CircuitoSerie circuito=new CircuitoSerie(3);
				crearCircuito(componentes,circuito);
				String nombres[]=componentes.getNombresComponentes();
				
				String tipoGenerador, tipoComponente;
				final int NUMEROMUESTRAS = 1000;
				final double F = 2.0 / NUMEROMUESTRAS;
				GeneradorSe�al generador = null;
				
				Scanner sc = new Scanner(System.in);
			
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
							generador = new GeneradorSe�alSinusoidalConSaturacion("Sinusoidal con umbral", F, 0, 0.8);
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
					
					for(int i=0;i<nombres.length;i++)
					{
						componentes.delComponente(nombres[i]);
					}
					if(componentes.size()==0)
					{
						System.out.println("Se han borrado correctamente los componentes.");
					}
					}
				}
				sc.close();
				
			}else
			{
				System.out.println("ERROR: Elija 1 para lista, 2 para mapa.");
			}
			
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}	
		catch (MalFuncionamientoException e){
			e.printStackTrace();
		}	
		catch (Exception e){
			e.printStackTrace();
		}	
	}

	/**
	 * Muestra en la sonda gráfica el resultado de aplicar la señal del
	 * generador sobre el componente, con el número de muestras indicado. En el titulo
	 * de la ventana gr�fica se añadirá el nombre del componente si el parámetro 
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
			ITransferencia componente, int muestras)throws MalFuncionamientoException {
		//  Rellenar por el alumno
		try{
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
			SondaGrafica sonda=new SondaGrafica("Sonda Gr�fica",5);
			for(int i=0;i<muestras;i++)
			{
				
				sonda.addMuestra(componente.getSalida(generador.getSalida()));
			}
		}
		}catch(IllegalArgumentException e)
		{
			throw new MalFuncionamientoException("El "+componente+": ha reportado: "+e.getMessage());
		}
	}
	public static void crearCircuito(IComponentes c, CircuitoSerie s)
	{
		String nombres[]=c.getNombresComponentes();
		for(int i=0;i<nombres.length;i++)
		{
			s.addComponente(c.getComponente(nombres[i]));
		}
	}
}
