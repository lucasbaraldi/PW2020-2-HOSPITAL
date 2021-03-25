package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class PacienteDAO<TIPO>  extends DAOGenerico<Paciente> implements Serializable  {
    public PacienteDAO(){
        super();
        classePersistente = Paciente.class;
    }
}
