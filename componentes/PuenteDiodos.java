package componentes;

public class PuenteDiodos extends Componente implements ITransferencia
{
	public PuenteDiodos(java.lang.String nombre)
	{
		super(nombre);
	}
	public double getSalida(double entrada)
	{
		return Math.abs(entrada);
	}

}
