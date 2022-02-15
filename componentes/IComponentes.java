package componentes;

public interface IComponentes {
	 boolean AddComponente(Componente c);
	 Componente getComponente(java.lang.String nombre);
	 Componente delComponente(java.lang.String nombre);
	 java.lang.String[] getNombresComponentes();
	 Componente[] getComponentes();
	 int size();
}
