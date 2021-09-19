package Servicios.personas;

import DAO.DAOpersonas;
import Modelos.Personas;

public class ServiciosUpdatePersonas {

    public boolean updateperson(Personas p){
        DAOpersonas dao = new DAOpersonas();
        return dao.updateperson(p);
    }
}
