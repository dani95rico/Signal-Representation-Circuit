package componentes;

public abstract class Componente extends java.lang.Object implements ITransferencia
{
	private java.lang.String nombre;
	public Componente(java.lang.String nombre)
	{
		this.nombre=nombre;
	}
	public java.lang.String getNombre()
	{
		return nombre;
	}
	public java.lang.String toString()
	{
		java.lang.String frase="Componente [nombre="+nombre+"]";
		return frase;
	}
	public abstract double getSalida(double entrada);

}
