package menu.strategy.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.Juguete;
import menu.strategy.Accion;
import utils.Kb;

public class AccionEliminarPorColor implements Accion {

	@Override
	public Set<Juguete> aplicar(Set<Juguete> juguetes) {
		Set<String> colores = juguetes.stream()
	            .map(Juguete::getColor)
	            .collect(Collectors.toSet());
	    System.out.println("Colores disponibles:"+"\n");
	    colores.forEach(System.out::println);
	    String color = Kb.leerTexto("Elija un color para filtrar los juguetes:"+"\n");
	       
	    Set<Juguete> juguetesFiltrados = juguetes.stream()
	            .filter(juguete -> !juguete.getColor().equals(color))
	            .collect(Collectors.toSet());
	    reasignarID(juguetesFiltrados);
	    AccionMostrar.mostrarElementos(juguetesFiltrados);
        return juguetesFiltrados;
	}
	
	
	 public static void reasignarID(Set<Juguete> juguetes) {
		    List<Juguete> juguetesList = new ArrayList<>(juguetes);
		    IntStream.range(0, juguetesList.size())
		            .forEach(i -> juguetesList.get(i).setId(i + 1));
		    juguetes.clear();
		    juguetes.addAll(juguetesList);
	    }


	@Override
	public Integer getOpcion() {
		return 8;
	}


}
