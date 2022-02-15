package componentes;

import java.util.*;

public class ComponentesMap implements IComponentes {
	 Map <String,Componente> mapa;
	 public ComponentesMap()
	 {
			mapa=new HashMap<String,Componente>();
	 }
	 
	public boolean AddComponente(Componente c) {
		if(c.getNombre()==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		mapa.put(c.getNombre(), c);
		return true;
	}
	
	public Componente getComponente(String nombre) {
		if(nombre==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		return mapa.get(nombre);
	}
	
	public Componente delComponente(String nombre) {
		if(nombre==null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		
		return mapa.remove(nombre);
	}
	
	public String[] getNombresComponentes() {
		String [] nombres;
		if(mapa.size() != 0){
			nombres = new String[mapa.size()];
			
			Iterator <String> iter = mapa.keySet().iterator();
			int i = 0;
			
			while(iter.hasNext()){
				nombres[i]=new String(iter.next());
				i++;
			}
		}	
		else
			nombres = null;
		
		return nombres;
	}
	
	public Componente[] getComponentes() {
		Componente [] componentes;
		if(mapa.size() != 0){
			componentes = new Componente[mapa.size()];
			
			Iterator <String> iter = mapa.keySet().iterator();
			int i = 0;
			
			while(iter.hasNext()){
				componentes[i]=mapa.get(new String(iter.next()));
				i++;
			}
		}	
		else
			componentes = null;
		
		return componentes;
	}
	
	public int size() {
		return mapa.size();
	}
	 
		
}
