package com.mytutorial.rateflats.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mytutorial.rateflats.Flat;

@Repository(value = "flatDao")
public class JPAFlatDAO implements FlatDAO {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED) 
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	@Transactional(readOnly = false)
	public void createNewFlat(Flat newFlat) {
		// TODO Auto-generated method stub
		em.persist(newFlat);
	}

	@Transactional(readOnly = false)
	public void saveFlat(Flat flatToSave) {
		// TODO Auto-generated method stub
		Flat oldFlat = (Flat)em.createQuery("select f from Flat f "
				+ "where f.id = :flatId")
				.setParameter("flatId", flatToSave.getId()).getSingleResult();
		oldFlat = flatToSave;
		em.merge(oldFlat);
	}

	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Flat> getAllFlatsSorted() {
		// TODO Auto-generated method stub
		return em.createQuery("select f from Flat f order by f.finalRating DESC").getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Flat> searchFlatsByName(String keyFlat) {
		// TODO Auto-generated method stub
		keyFlat = "%"+keyFlat+"%";
		return em.createQuery("select f from Flat f "
				+ "where f.nameOfStreetandNumber LIKE :keyFlat")
				.setParameter("keyFlat", keyFlat).getResultList();
	}

	@Transactional(readOnly = true)
	public Flat searchOneFlatById(int flatId) {
		// TODO Auto-generated method stub
		return (Flat)em.createQuery("select f from Flat f "
				+ "where f.id = :flatId")
				.setParameter("flatId", flatId).getSingleResult();
	}

	@Transactional(readOnly = false)
	public void removeFlatWithId(int flatId) {
		// TODO Auto-generated method stub
		Flat flatToRemove = (Flat)em.createQuery("select f from Flat f "
				+ "where f.id = :flatId")
				.setParameter("flatId", flatId).getSingleResult();
		em.remove(em.merge(flatToRemove));
	}
}
