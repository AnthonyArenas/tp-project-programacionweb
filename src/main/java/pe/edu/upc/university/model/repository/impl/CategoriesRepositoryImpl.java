package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.university.model.entity.Categories;
import pe.edu.upc.university.model.repository.CategoriesRepository;

@Named
@ApplicationScoped
public class CategoriesRepositoryImpl implements CategoriesRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Transactional
	@Override
	public Categories save(Categories categories) throws Exception{
		this.entityManager.persist(categories);
		return categories;
	}
	
	@Override
	public Optional<Categories> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Categories.class);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub deleteById(id);
		this.entityManager.remove(this.entityManager.find(Categories.class, id));
	}
	
	//@Transactional
	@Override
	public Categories update(Categories categories) throws Exception{
		
		//original
		this.getEntityManager().merge(categories);

		return categories;
	}
	
	@Override
	public List<Categories> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT categories FROM Categories categories WHERE categories.name LIKE categories.name";
		return this.findByQuery(Categories.class, jpql);
	}


	@Override
	public List<Categories> findByName(String Name) throws Exception {
		String jpql = "SELECT categories FROM Categories categories WHERE categories.name LIKE '%" + Name + "%'";
		return this.findByQuery(Categories.class, jpql);
	}
	
	@Override
	public List<Categories> findByData(String data) throws Exception {
		String jpql = "SELECT categories FROM Categories categories WHERE categories.name LIKE '%" + data + "%'";
		return this.findByQuery(Categories.class, jpql);
	}

}
