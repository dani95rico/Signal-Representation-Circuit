package generadores;
public class GeneradorSeñalTriangular extends GeneradorSeñal{
	private int t; //TIEMPO
	private double T; //PERIODO
	public GeneradorSeñalTriangular(java.lang.String nombre, double f) 
	{
		super(nombre,f);
		this.t=0;
		this.T=1/f;
	}
	public double getSalida()
	{
		double salida=0;
		if(t>=0 && t<(T/4))
		{
			salida=4*t/T;
			t++;		
		}
		if(t>=(T/4) && t<((3*T)/4))
		{
			salida=2-4*t/T;
			t++;
		}
		if(t>=((3*T)/4) && t<T)
		{
			salida=-4+(4*t/T);
			t++;
		}
		if(t>=T)
		{
			t=0;
		}
		return salida;
	}
}
