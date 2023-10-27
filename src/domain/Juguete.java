package domain;

public interface Juguete  {

    int getId();
    String getColor();
    Juguete clone();
    void setId(int id);
}
