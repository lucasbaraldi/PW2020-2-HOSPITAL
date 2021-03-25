package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class EspecialidadeDAO<TIPO>  extends DAOGenerico<Especialidade> implements Serializable  {
    public EspecialidadeDAO(){
        super();
        classePersistente = Especialidade.class;
    }
}
