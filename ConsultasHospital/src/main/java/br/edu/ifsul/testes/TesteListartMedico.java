    /*  
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListartMedico {
    
       public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        List<Medico> l = em.createQuery("from Medico order by id").getResultList();
        for (Medico p : l){
            System.out.println("ID: " + p.getId()+ " Nome: " + p.getNome() + " Especialidade: " + p.getEspecialidade().getDescricao());  
        }

        em.close();
        emf.close();
        
        
        
    }
   
}
