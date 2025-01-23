package com.project.datingRecommendation.repo;

import com.project.datingRecommendation.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean save(UserEntity entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public UserEntity findById(Long id) {
		EntityManager em = emf.createEntityManager();
		UserEntity user = em.find(UserEntity.class, id);
		em.close();
		return user;
	}

	@Override
	public List<UserEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM UserEntity u");
		List<UserEntity> users = query.getResultList();
		em.close();
		return users;
	}
}