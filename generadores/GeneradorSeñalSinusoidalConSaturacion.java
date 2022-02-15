package generadores;
public class GeneradorSeñalSinusoidalConSaturacion extends GeneradorSeñalSinusoidal {
	private double umbral;
	public GeneradorSeñalSinusoidalConSaturacion(java.lang.String nombre,double f,double fase0,double umbral)
	{
		super(nombre,f,fase0);
		this.umbral=umbral;
		if(umbral<0 || umbral>1)
		{
			throw new IllegalArgumentException("ERROR: umbral menor que 0 o mayor que 1.");
		}

	}
	public double getSalida()
	{
		double salida= super.getSalida();
		double salidaFinal=0;
		if(salida>umbral)
		{
			salidaFinal=umbral;
		}
		if(salida<=umbral)
		{
			salidaFinal=salida;
		}
		if(salida<(-umbral))
		{
			salidaFinal=-umbral;
		}
		return salidaFinal;
	}
}
