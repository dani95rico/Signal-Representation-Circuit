package componentes;

public class Condensador extends Componente implements ITransferencia{
	private double salidaAnterior;
	public Condensador(java.lang.String nombre)
	{
		super(nombre);
		this.salidaAnterior=0.0;
	}
	public double getSalida(double entrada)
	{
		double salida=0;
		if(entrada>=salidaAnterior*0.999)
		{
			salida=entrada;
		}
		if(entrada<salidaAnterior*0.999)
		{
			salida=salidaAnterior*0.999;
		}
		salidaAnterior=salida;
		if(salida<0)
		{
			throw new IllegalArgumentException("ERROR: salida del condensador negativa");
		}
		return salida;
	}
}
