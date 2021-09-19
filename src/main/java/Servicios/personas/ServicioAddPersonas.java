package Servicios.personas;

import DAO.DAOpersonas;
import Modelos.Personas;

public class ServicioAddPersonas {




    public boolean addperson(Personas p){
        DAOpersonas dao = new DAOpersonas();
        return dao.addperson(p);

    }
}
