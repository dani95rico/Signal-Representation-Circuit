package componentes;
public class CircuitoSerie extends java.lang.Object implements ITransferencia{
	private int maxComponentes;
	private int numComponentes;
	Componente componentes[];
	public CircuitoSerie(int maxComponentes)
	{
		this.maxComponentes=maxComponentes;
		this.numComponentes=0;
		componentes=new Componente[maxComponentes];
	}
	public void addComponente(Componente componente)
	{
		if(!isLleno())
		{
			componentes[numComponentes]=componente;
			numComponentes++;
		}
		else
		{
			throw new IllegalArgumentException("ERROR: circuito serie lleno.");
		}
	}
	public int size()
	{
		return numComponentes;
	}
	public boolean isLleno()
	{
		boolean lleno=false;
		if(numComponentes>=maxComponentes)
		{
			lleno=true;
		}
		return lleno;
	}
	public double getSalida(double entrada)
	{
		double salida=entrada;
		if(numComponentes>0)
		{
			for(int i=0;i<numComponentes;i++)
			{
			 salida=componentes[i].getSalida(entrada);
			 entrada=salida;
			}
		}
		return salida;
	}
	public java.lang.String toString()
	{
		java.lang.String frase="Circuito Serie de componentes: ";
		for(int i=0;i<numComponentes;i++)
		{
			frase=frase+componentes[i].getNombre();
		}
		return frase;
	}
}
