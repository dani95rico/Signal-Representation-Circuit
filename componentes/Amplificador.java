package componentes;

public class Amplificador extends Componente implements ITransferencia{
	private double ganancia;
	public Amplificador(java.lang.String nombre, double ganancia)
	{
		super(nombre);
		this.ganancia=ganancia;
	}
	public double getSalida(double entrada)
	{
		return entrada*ganancia;
	}
	public double getGanancia()
	{
		return ganancia;
	}
	public void setGanancia(double ganancia)
	{
		this.ganancia=ganancia;
	}

}
