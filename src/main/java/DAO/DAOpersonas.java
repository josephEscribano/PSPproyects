package DAO;

import Modelos.Personas;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DAOpersonas {

    private static List<Personas> listapersonas;


    public DAOpersonas() {
        if (listapersonas == null){
            listapersonas = new ArrayList<>();
        }
    }

    public List<Personas> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(List<Personas> listapersonas) {
        DAOpersonas.listapersonas = listapersonas;
    }
    public void filtrarmujer(){
        listapersonas.removeIf(Personas::isSexo);
    }

    public void filtrarhombre(){
        listapersonas.removeIf(p -> !p.isSexo());
    }

    public boolean addperson(Personas p){
        return listapersonas.add(p);
    }

    public boolean updateperson(Personas p){
        listapersonas.set(p.getId(),p);
        return listapersonas.contains(p);
    }
}
