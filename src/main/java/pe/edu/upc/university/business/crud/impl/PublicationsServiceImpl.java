package pe.edu.upc.university.business.crud.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.university.business.crud.PublicationsServices;
import pe.edu.upc.university.model.entity.Clothing;
import pe.edu.upc.university.model.entity.Publications;
import pe.edu.upc.university.model.repository.JpaRepository;
import pe.edu.upc.university.model.repository.PublicationsRepository;

@Named
@ApplicationScoped
public class PublicationsServiceImpl implements PublicationsServices, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private  PublicationsRepository publicationsRepository;
	
	@Override
	public JpaRepository<Publications, Integer> getJpaRepository() {
		return this.publicationsRepository;
	}
	
	@Transactional
	@Override
	public Publications update(Publications entity) throws Exception {
		return publicationsRepository.update(entity);
	}
	
	@Override
	public List<Publications> findByData(String Name) throws Exception {
		return this.publicationsRepository.findByData(Name);
	}
	
}
