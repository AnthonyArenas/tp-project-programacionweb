package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import pe.edu.upc.university.model.entity.Categories;
import pe.edu.upc.university.model.entity.Users;
import pe.edu.upc.university.model.repository.UsersRepository;

@Named
@ApplicationScoped
public class UsersRepositoryImpl implements UsersRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Transactional
	@Override
	public Users save(Users users) throws Exception{
		this.entityManager.persist(users);
		return users;
	}
	
	@Override
	public Optional<Users> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.findById(id, Users.class);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub deleteById(id);
		this.entityManager.remove(this.entityManager.find(Users.class, id));
	}

	@Override
	public Users update(Users users) throws Exception{
		this.entityManager.merge(users);
		return users;
	}
	
	@Override
	public List<Users> findAll() throws Exception {
		// TODO Auto-generated method stub
		String jpql = "SELECT users FROM Users users WHERE users.id = users.id";
		return this.findByQuery(Users.class, jpql);
	}

	
	@Override
	public List<Users> findByData(String data) throws Exception {
		String jpql = "SELECT users FROM Users users WHERE users.id = '%" + data + "%'";
		return this.findByQuery(Users.class, jpql);
	}
	
}
