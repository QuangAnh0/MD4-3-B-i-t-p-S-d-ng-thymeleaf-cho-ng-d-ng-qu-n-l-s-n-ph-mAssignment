package com.codegym.repository;

import com.codegym.model.Shoes;

import javax.transaction.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class ShoesRepository implements IShoeRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Shoes> findAll() {
        TypedQuery<Shoes> query = em.createQuery("select c from Shoes c", Shoes.class);
        return query.getResultList();
    }


    @Override
    public Shoes findById(Integer id) {
        TypedQuery<Shoes> query = em.createQuery("select c from Shoes c where  c.id=:id", Shoes.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Shoes shoes) {
        if (shoes.getId() != null) {
            em.merge(shoes);
        } else {
            em.persist(shoes);
        }
    }


    @Override
    public void remove(Integer id) {
        Shoes shoes = findById(id);
        if (shoes != null) {
            em.remove(shoes);
        }
    }

    @Override
    public void update(Integer i, Shoes shoes) {

    }
}
