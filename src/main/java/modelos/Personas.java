package modelos;


import lombok.*;

import java.time.LocalDate;

@Data @Setter @Getter

public class Personas {
    public Personas() {
        id = incrementoid;
        incrementoid++;
    }
    private final int id;
    private String Nombre;
    private int Edad;
    private boolean sexo;
    private LocalDate FechaRegistro;

    private int incrementoid = 0;

    @Override
    public String toString() {
        String genero = "";
        if(this.sexo){
            genero = "mujer";
        }else{
            genero = "hombre";
        }
        return "Personas{" +
                "Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                " , Sexo= " + genero +
                ", FechaRegistro=" + FechaRegistro +
                '}';
    }
}
