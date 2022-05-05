package pe.edu.upc.university.business.crud.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.university.business.crud.UsersService;
import pe.edu.upc.university.model.entity.Clothing;
import pe.edu.upc.university.model.entity.Users;
import pe.edu.upc.university.model.repository.UsersRepository;
import pe.edu.upc.university.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class UsersServiceImpl implements UsersService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private  UsersRepository usersRepository;
	
	@Override
	public JpaRepository<Users, Integer> getJpaRepository() {
		return this.usersRepository;
	}
	
	@Transactional
	@Override
	public Users update(Users entity) throws Exception {
		return usersRepository.update(entity);
	}
	
	@Override
	public List<Users> findByData(String Name) throws Exception {
		return this.usersRepository.findByData(Name);
	}

}
