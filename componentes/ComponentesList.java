package componentes;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentesList implements IComponentes{
	ArrayList<Componente> lista;
	public ComponentesList()
	{
		lista=new ArrayList<Componente>();
	}
	public boolean AddComponente(Componente c)
	{
		return lista.add(c);
	}
	public Componente getComponente(java.lang.String nombre)
	{
		if (nombre == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		Componente res = null;
		boolean encontrado=false;
		Iterator <Componente> iter = lista.iterator();
		
		while(iter.hasNext() && !encontrado){
			Componente aux = iter.next();
			if(aux.getNombre().equals(nombre)) {
				encontrado = true;
				res = aux;
			}
		}
		
		return res;
	}
	public Componente delComponente(java.lang.String nombre)
	{
		if (nombre == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		
		Componente res = null;
		boolean encontrado=false;
		Iterator <Componente> iter = lista.iterator();
		
		while(iter.hasNext() && !encontrado){
			Componente aux = iter.next();
			if(aux.getNombre().equals(nombre)) {
				encontrado = true;
				iter.remove();
				res = aux;
			}
		}
		
		return res;
	}
	public java.lang.String[] getNombresComponentes()
	{
		String [] nombres;
		
			if(lista.size() != 0) {
			nombres = new String[lista.size()];
		
			Iterator <Componente> iter = lista.iterator();
			int i = 0;
		
			while(iter.hasNext()){
				nombres[i] = new String(iter.next().getNombre());
				i++;
			}
		}
		else 
			nombres = null;
			
		return nombres;
	}
	public Componente[] getComponentes()
	{
		Componente [] componentes;
		
		if(lista.size() != 0) {
			componentes = new Componente[lista.size()];
		
			Iterator <Componente> iter = lista.iterator();
			int i = 0;
		
			while(iter.hasNext()){
				componentes[i] = iter.next();
				i++;
			}
		}
		else 
			componentes = null;
			
		return componentes;
	}
	public int size()
	{
		return lista.size();
	}
}
