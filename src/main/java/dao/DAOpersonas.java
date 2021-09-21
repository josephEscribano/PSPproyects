package dao;

import modelos.Personas;

import java.util.ArrayList;
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

    public boolean addperson(Personas p){
        return listapersonas.add(p);
    }

    public boolean updateperson(Personas p){
        listapersonas.set(p.getId(),p);
        return listapersonas.contains(p);
    }
}
