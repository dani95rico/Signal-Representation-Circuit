package generadores;

public class GeneradorSeñal extends java.lang.Object {

	private java.lang.String nombre;
	private double f;
		public GeneradorSeñal(java.lang.String nombre, double f) 
		{
			this.nombre=nombre;
			this.f=f;
			if(f<=0)
			{
				throw new IllegalArgumentException("ERROR: frecuencia igual o menor que 0.");
			}
		}
		public java.lang.String getNombre()
		{
			return nombre;
		}
		public double getSalida()
		{
			return 0;
		}
		public double getFrecuencia()
		{
			return f;
		}
}
