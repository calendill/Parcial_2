package menu.strategy.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Juguete;
import menu.strategy.Accion;

public class AccionCrearMap implements Accion {

	@Override
	public Set<Juguete> aplicar(Set<Juguete> juguetes) {
		         Map<Integer, Juguete> juguetesMap = juguetes.stream()
		        		 .collect(Collectors.toMap(Juguete::getId, juguete -> juguete));
		         juguetesMap.forEach((key,value) -> System.out.printf("Key->" + key + " Value->"+ value + "\n"));
		return juguetes;
	 }
	

	@Override
	public Integer getOpcion() {
		return 7;
	}

}
