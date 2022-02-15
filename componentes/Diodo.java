package componentes;

public class Diodo extends Componente implements ITransferencia{
	public Diodo(java.lang.String nombre)
	{
		super(nombre);
	}
	public double getSalida(double entrada)
	{
		double salida;
		if(entrada<0)
		{
			salida=0.0;
		}else
		{
			salida=entrada;
		}
		return salida;
	}

}
