package menu.strategy.impl;
import  utils.Kb;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import domain.Juguete;
import domain.impl.Carrito;
import domain.impl.Peluche;
import menu.strategy.Accion;

public class AccionFiltrarJuguete implements Accion{

	@Override
	public Set<Juguete> aplicar(Set<Juguete> juguetes) {
		Set<Juguete> juguetesCopia = new LinkedHashSet<>(juguetes);
		int opcion=Kb.leerEntero("1.Carrito\n" + "2.Peluche");
		if(opcion == 1) {
			juguetesCopia.stream().filter(x -> x instanceof Carrito)
			 .sorted(Comparator.comparing(Juguete::getId).reversed())
		        .collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
			    System.out.println();			
		}else if(opcion == 2){
			juguetesCopia.stream().filter(x -> x instanceof Peluche)
			 .sorted(Comparator.comparing(Juguete::getId).reversed())
		        .collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
			    System.out.println();
		}
		return juguetes;
	
	}
	@Override 
	public Integer getOpcion() {
		return 5;
	}

}
