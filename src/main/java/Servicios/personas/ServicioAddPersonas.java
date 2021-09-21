package Servicios.personas;

import dao.DAOpersonas;
import modelos.Personas;

public class ServicioAddPersonas {

    public boolean addperson(Personas p){
        DAOpersonas dao = new DAOpersonas();
        return dao.addperson(p);

    }
}
