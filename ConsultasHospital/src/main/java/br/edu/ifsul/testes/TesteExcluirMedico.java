/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteExcluirMedico {
        public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Medico p = em.find(Medico.class, 16);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
