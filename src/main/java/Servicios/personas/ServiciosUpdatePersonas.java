package Servicios.personas;

import dao.DAOpersonas;
import modelos.Personas;

public class ServiciosUpdatePersonas {

    public boolean updateperson(Personas p){
        DAOpersonas dao = new DAOpersonas();
        return dao.updateperson(p);
    }
}
