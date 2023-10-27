package menu.strategy.impl;

import domain.Juguete;
import menu.strategy.Accion;
import utils.Kb;
import java.util.LinkedHashSet;
import java.util.Set;


public class AccionClonar implements Accion {


    @Override
    public Set<Juguete> aplicar(Set<Juguete> juguetes) {
        AccionMostrar.mostrarElementos(juguetes);
        int opcion=Kb.leerEntero("Que juguete quiere Clonar");
        Juguete jugueteACopiar = EncontrarJuguete(opcion,juguetes);
        int numeroDeVeces=Kb.leerEntero("Cuantas veces lo quieres Clonar");
        Set<Juguete> juguetesCopia = new LinkedHashSet<>(juguetes);
        for(int i = 0; i < numeroDeVeces; i++) {
            Juguete jugueteClonado = jugueteACopiar.clone();
            jugueteClonado.setId(juguetesCopia.size()+1);
            juguetesCopia.add(jugueteClonado);
        }
        return juguetesCopia;
    }

    @Override
    public Integer getOpcion() {
        return 2;
    }
    
    public static Juguete EncontrarJuguete(int opcion,Set<Juguete> juguetes) {
    	Juguete encontrado=null;
    	for (Juguete i : juguetes) {
    	    if (i.getId()==opcion) { 
    	        encontrado = i;
    	        break; 
   	    }throw new RuntimeException("Opcion no valida"); 	
    } 
    	return encontrado;
 }
}
