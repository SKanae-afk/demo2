package com.example.dao;

import com.example.entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class Users extends GenericDao<UsersEntity>{

    private final EntityManagerFactory entityManagerFactory;

    public Users(EntityManagerFactory entityManagerFactory) {
        super(UsersEntity.class);
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public EntityManager getEntityManager() {
        try {
            return entityManagerFactory.createEntityManager();
        }
        catch (Exception e) {
            System.out.println("The entity manager cannot be created");
        }
        return null;
    }

    //for login
    public List<UsersEntity> find(String name) {
        EntityManager entityManager = getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsersEntity> query = criteriaBuilder.createQuery(UsersEntity.class);

        Root<UsersEntity> c = query.from(UsersEntity.class);
        ParameterExpression<String> paramName = criteriaBuilder.parameter(String.class);
        query.select(c).where(criteriaBuilder.equal(c.get("username"), paramName));
        TypedQuery<UsersEntity> q = entityManager.createQuery(query);
        q.setParameter(paramName, name);

        List<UsersEntity> results = q.getResultList();
        return results;
    }
}