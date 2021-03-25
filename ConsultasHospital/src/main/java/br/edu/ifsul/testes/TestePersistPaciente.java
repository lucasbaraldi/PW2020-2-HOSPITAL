package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistPaciente {
    public static void main(String[] args) throws ParseException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Paciente r = new Paciente();
        
        
        r.setNome("jose da silva ");
        
        String strDate = "28/04/1968";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        c.setTime(sdf.parse(strDate));
        r.setNascimento(c);
        
        r.setTelefone("54999886931");
        
        r.setSexo("M");
        
        r.setHistorico("");
        
        r.setPeso(90.00);
        
        
        r.setAltura(1.85);
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
 
}
