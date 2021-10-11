package br.com.mcp.val.sec.entity.persistence;

import br.com.core.exception.NegocioException;
import br.com.core.persistence.OraclePersistence;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;

/**
 * <b>Classe:</b> AbstractMvsPersistence <br>
 * <b>Descrição:</b>     <br>
 *
 * <b>Projeto:</b> mcp-val-sec <br>
 * <b>Pacote:</b> mcp.val.sec.persistence <br>
 * <b>Empresa:</b> Caser&Buys Consultoria. <br>
 *
 * Copyright (c) 2021 CASER&BUYS - Todos os direitos reservados.
 *
 * @author marcelocaser
 * @version Revision: $$ Date: 24/09/2021
 */
public abstract class AbstractMvsPersistence<E extends Serializable, I> extends OraclePersistence<E, I> {

    @PersistenceContext(unitName = "intranet")
    private EntityManager entityManager;

    public void create(E entity) throws NegocioException {
        super.create(entityManager, entity); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer count() {
        return super.count(entityManager); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(E entity) throws NegocioException {
        super.delete(entityManager, entity); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteById(I entityId) throws NegocioException {
        super.deleteById(entityManager, entityId); //To change body of generated methods, choose Tools | Templates.
    }

    public void evict() {
        super.evict(entityManager); //To change body of generated methods, choose Tools | Templates.
    }

    public E find(E entity) {
        return super.find(entityManager, entity); //To change body of generated methods, choose Tools | Templates.
    }

    public E findOne(I id) {
        return super.findOne(entityManager, id); //To change body of generated methods, choose Tools | Templates.
    }

    public List<E> list(E entity) {
        return super.list(entityManager, entity); //To change body of generated methods, choose Tools | Templates.
    }

    public List<E> list(E entity, List<Order> order, int maxResult) {
        return super.list(entityManager, entity, order, maxResult); //To change body of generated methods, choose Tools | Templates.
    }

    public E update(E entity) throws NegocioException {
        return super.update(entityManager, entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    public Date getDateTimeToOracle() throws NegocioException {
        return super.getDateTimeToOracle(entityManager); //To change body of generated methods, choose Tools | Templates.
    }

    public LocalDateTime getLocalDateTimeToOracle() throws NegocioException {
        return super.getLocalDateTimeToOracle(entityManager); //To change body of generated methods, choose Tools | Templates.
    }

    public int truncate(E entity) {
        return super.truncate(entityManager, entity);
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
