/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.dao; 

import br.com.tcc2017.model.IngItVenda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class IngItVendaDao extends AbstractDao<IngItVenda> {

    @PersistenceContext(unitName="TCC2017PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public IngItVendaDao(){
        super(IngItVenda.class);
    }
}
