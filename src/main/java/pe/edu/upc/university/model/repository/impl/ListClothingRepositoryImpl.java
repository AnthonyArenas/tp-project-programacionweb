package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.university.model.entity.ListClothing;
import pe.edu.upc.university.model.repository.ListClothingRepository;
@Named
@ApplicationScoped
public class ListClothingRepositoryImpl implements ListClothingRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Transactional
	@Override
	public ListClothing save(ListClothing users) throws Exception{
		this.entityManager.persist(users);
		return users;
	}
	
	@Override
	public Optional<ListClothing> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, ListClothing.class);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub deleteById(id);
		this.entityManager.remove(this.entityManager.find(ListClothing.class, id));
	}

	@Override
	public ListClothing update(ListClothing listClothing) throws Exception{
		this.entityManager.merge(listClothing);
		return listClothing;
	}
	
	@Override
	public List<ListClothing> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT listClothing FROM ListClothing listClothing WHERE listClothing.id = listClothing.id";
		return this.findByQuery(ListClothing.class, jpql);
	}

	
	@Override
	public List<ListClothing> findByData(String data) throws Exception {
		String jpql = "SELECT listClothing FROM ListClothing listClothing WHERE listClothing.id = '%" + data + "%'";
		return this.findByQuery(ListClothing.class, jpql);
	}
}
