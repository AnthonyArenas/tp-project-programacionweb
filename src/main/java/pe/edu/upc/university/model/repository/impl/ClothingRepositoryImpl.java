package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.university.model.entity.Clothing;
import pe.edu.upc.university.model.repository.ClothingRepository;
@Named
@ApplicationScoped
public class ClothingRepositoryImpl implements ClothingRepository {
	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Transactional
	@Override
	public Clothing save(Clothing clothing) throws Exception{
		this.entityManager.persist(clothing);
		return clothing;
	}
	
	@Override
	public Optional<Clothing> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Clothing.class);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub deleteById(id);
		this.entityManager.remove(this.entityManager.find(Clothing.class, id));
	}

	@Override
	public Clothing update(Clothing clothing) throws Exception{
		this.entityManager.merge(clothing);
		return clothing;
	}
	
	@Override
	public List<Clothing> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT clothing FROM Clothing clothing WHERE clothing.id = users.id";
		return this.findByQuery(Clothing.class, jpql);
	}

	
	@Override
	public List<Clothing> findByData(String data) throws Exception {
		String jpql = "SELECT clothing FROM Clothing clothing WHERE clothing.id = '%" + data + "%'";
		return this.findByQuery(Clothing.class, jpql);
	}
}
