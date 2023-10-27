
package domain.impl;
import domain.Juguete;

public class Carrito implements Juguete,Comparable<Carrito> {

    private int id;
    private String color;
    private int numeroPuertas;
    private String marca;

    public Carrito(int id, String color, int numeroPuertas, String marca) {
        this.id = id;
        this.color = color;
        this.numeroPuertas = numeroPuertas;
        this.marca = marca;
    }

    @Override
    public int getId() {
        return this.id;
    }
    
    public int getNumeroPuertas() {
    	return this.numeroPuertas;
    }
    
    public String getColor() {
    	return this.color;
    }

    @Override
    public Carrito clone() {
        return Carrito.builder()
                .color(this.color)
                .numeroPuertas(this.numeroPuertas)
                .marca(this.marca)
                .build();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public static CarritoBuilder builder() {
        return new CarritoBuilder();
    }

    public static class CarritoBuilder {
        private int id;
        private String color;
        private int numeroPuertas;
        private String marca;

        public CarritoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CarritoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarritoBuilder numeroPuertas(int numeroPuertas) {
            this.numeroPuertas = numeroPuertas;
            return this;
        }

        public CarritoBuilder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public Carrito build() {
            return new Carrito(id, color, numeroPuertas, marca);
        }



    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", numeroPuertas=" + numeroPuertas +
                ", marca='" + marca + '\'' +
                '}';
    }

	@Override
	public int compareTo(Carrito o) {
		return Integer.compare(this.id, o.id);
	}
}
