package generadores;
public class GeneradorSeñalSinusoidal extends GeneradorSeñal{
	private static final double PI=3.14;
	private int t;
	private double fase0;
	public GeneradorSeñalSinusoidal(java.lang.String nombre,double f,double fase0)
	{
		super(nombre,f);
		this.fase0=fase0;
		this.t=0;
	}
	public double getSalida()
	{
		double salida= Math.sin(2*PI*super.getFrecuencia()*t+fase0);
		t++;
		return salida;
	}
}
