/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc2017.dao; 

import br.com.tcc2017.model.Caixa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class CaixaDao extends AbstractDao<Caixa> {

    @PersistenceContext(unitName="TCC2017PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public CaixaDao(){
        super(Caixa.class);
    }
}
