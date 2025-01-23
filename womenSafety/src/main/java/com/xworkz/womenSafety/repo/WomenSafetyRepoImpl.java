package com.xworkz.womenSafety.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.womenSafety.entity.WomenSafetyEntity;

@Repository
public class WomenSafetyRepoImpl implements WomenSafetyRepo {
	@Autowired
	private EntityManagerFactory emf;

	public WomenSafetyRepoImpl() {
		System.out.println("Invoking WomenSafetyRepoImpl...");
	}

	@Override
	public boolean save(WomenSafetyEntity entity) {
		System.out.println("Invoking save...");
		System.out.println("Entity Passed:" + entity);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("Et begin");
			em.persist(entity);
			System.out.println("Persist complete");
			et.commit();

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());
			et.rollback();
		} finally {
			System.out.println("Closing resources");
			em.close();
		}

		return true;

	}
	
	
	@Override
	public boolean findByEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Created EM");

		List<WomenSafetyEntity> list = new ArrayList<WomenSafetyEntity>();
		try {
			et.begin();
			Query query = em.createNamedQuery("findByEmailAndPassword");
			query.setParameter("email", email);
			query.setParameter("password", password);

			list =  query.getResultList();
			et.commit();
			return true;
		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());
			et.rollback();

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}

		return false;
	}
	
	
	@Override
	public List<WomenSafetyEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<WomenSafetyEntity> list = new ArrayList<WomenSafetyEntity>();
		try {
			Query query = em.createNamedQuery("findAll");

			list = query.getResultList();

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return list;
	}
	
	@Override
	public List<WomenSafetyEntity> findByName(String name) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<WomenSafetyEntity> list = null;
		try {
			Query query = em.createNamedQuery("findByName");
			query.setParameter("name", name);

			list = query.getResultList();

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return list;
	}
	
	
	@Override
	public WomenSafetyEntity findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Created EM");
		WomenSafetyEntity ent = null;

		try {
			et.begin();
			Query query = em.createNamedQuery("findByEmail");
			query.setParameter("email", email);

			ent = (WomenSafetyEntity) query.getSingleResult();
			et.commit();
			return ent;
		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());
			et.rollback();

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}

		return null;
	}
	@Override
	public boolean update(WomenSafetyEntity entity,int id) {
		EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    try {
	        et.begin();
	      WomenSafetyEntity entity2 = em.find(WomenSafetyEntity.class, id);
	      entity2.setName(entity.getName());
	      entity2.setAadharNumber(entity.getAadharNumber());
	      entity2.setAddress(entity.getAddress());
	      entity2.setAlternatePhoneNumber(entity.getAlternatePhoneNumber());
	      entity2.setBloodGroup(entity.getBloodGroup());
	      entity2.setCountry(entity.getCountry());
	      entity2.setDateOfBirth(entity.getDateOfBirth());
	      entity2.setEmail(entity.getEmail());
	      entity2.setGender(entity.getGender());
	      entity2.setPhoneNumber(entity.getPhoneNumber());
	      entity2.setState(entity.getState());
	        em.merge(entity2); 
	        et.commit();
	        return true;
	        
	    } catch (PersistenceException pe) {
	        System.out.println("PersistenceException in update:" + pe.getMessage());
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	    } finally {
	        em.close();
	    }

	    return false;
	}
}
