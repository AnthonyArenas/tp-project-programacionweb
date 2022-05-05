package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.university.model.entity.Publications;
import pe.edu.upc.university.model.entity.Users;
import pe.edu.upc.university.model.repository.PublicationsRepository;
@Named
@ApplicationScoped
public class PublicationsRepositoryImpl implements PublicationsRepository {
	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Transactional
	@Override
	public Publications save(Publications publications) throws Exception{
		this.entityManager.persist(publications);
		return publications;
	}
	
	@Override
	public Optional<Publications> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Publications.class);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub deleteById(id);
		this.entityManager.remove(this.entityManager.find(Users.class, id));
	}

	@Override
	public Publications update(Publications publications) throws Exception{
		this.entityManager.merge(publications);
		return publications;
	}
	
	@Override
	public List<Publications> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT publications FROM Publications publications WHERE publications.id = publications.id";
		return this.findByQuery(Publications.class, jpql);
	}

	
	@Override
	public List<Publications> findByData(String data) throws Exception {
		String jpql = "SELECT publications FROM Publications publications WHERE publications.id = '%" + data + "%'";
		return this.findByQuery(Publications.class, jpql);
	}
}
