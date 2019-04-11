/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.dukesbookstore.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaeetutorial.dukesbookstore.entity.StateTax;
import javaeetutorial.dukesbookstore.exception.StateTaxNotFoundException;
import javaeetutorial.dukesbookstore.exception.StateTaxesNotFoundException;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tfran
 */
@Stateful
public class StateTaxRequestBean {

    @PersistenceContext
    private EntityManager em;
    private static final Logger logger =
            Logger.getLogger("dukesbookstore.ejb.BookRequestBean");
    
    public StateTaxRequestBean() throws Exception{
    }
    
    public void createStateTax(String state, double tax){
        try {
            StateTax statetax = new StateTax(state, tax);
            logger.log(Level.INFO, "Created StateTax {0}", state);
            em.persist(statetax);
            logger.log(Level.INFO, "Persisted StateTax {0}", state);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    public List<StateTax> getStateTaxes() throws StateTaxesNotFoundException {
        try {
            return (List<StateTax>) em.createNamedQuery("findStateTaxes").getResultList();
        } catch (Exception ex) {
            throw new StateTaxesNotFoundException(
                    "Could not get books: " + ex.getMessage());
        }
    }

    public StateTax getStateTax(String state) throws StateTaxNotFoundException {
        StateTax requestedStateTax = em.find(StateTax.class, state);

        if (requestedStateTax == null) {
            throw new StateTaxNotFoundException("Couldn't find StateTax: " + state);
        }

        return requestedStateTax;
    }
}
