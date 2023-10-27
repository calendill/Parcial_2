package domain.impl;

import domain.Juguete;

public class Peluche implements Juguete,Comparable<Peluche> {

    private int id;
    private String relleno;
    private String materialExterior;
    private String color;

    public Peluche(int id, String relleno, String materialExterior, String color) {
        this.id = id;
        this.relleno = relleno;
        this.materialExterior = materialExterior;
        this.color = color;
    }

    @Override
    public int getId() {
        return this.id;
    }
    
    public String getColor() {
    	return this.color;
    }

    @Override
    public Peluche clone() {
        return Peluche.builder()
                .relleno(this.relleno)
                .color(this.color)
                .materialExterior(this.materialExterior)
                .build();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public static PelucheBuilder builder() {
        return new PelucheBuilder();
    }

    public static class PelucheBuilder {
        private int id;
        private String relleno;
        private String materialExterior;
        private String color;

        public PelucheBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PelucheBuilder color(String color) {
            this.color = color;
            return this;
        }

        public PelucheBuilder materialExterior(String materialExterior) {
            this.materialExterior = materialExterior;
            return this;
        }

        public PelucheBuilder relleno(String relleno) {
            this.relleno = relleno;
            return this;
        }

        public Peluche build() {
            return new Peluche(id, relleno, materialExterior, color);
        }


		
    }

  //fin clase Builder 
    
    
    @Override
	public String toString() {
		return "Peluche [id=" + id + ", relleno=" + relleno + ", materialExterior=" + materialExterior + ", color="
				+ color + "]";
	}

	@Override
	public int compareTo(Peluche o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.id, o.id);
	}
}
