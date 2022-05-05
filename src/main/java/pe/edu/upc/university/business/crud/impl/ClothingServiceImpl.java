package pe.edu.upc.university.business.crud.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.university.business.crud.ClothingService;
import pe.edu.upc.university.model.entity.Categories;
import pe.edu.upc.university.model.entity.Clothing;
import pe.edu.upc.university.model.repository.JpaRepository;
import pe.edu.upc.university.model.repository.ClothingRepository;


@Named
@ApplicationScoped
public class ClothingServiceImpl implements ClothingService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private  ClothingRepository clothingRepository;
	
	@Override
	public JpaRepository<Clothing, Integer> getJpaRepository() {
		
		return this.clothingRepository;
	}

	@Transactional
	@Override
	public Clothing update(Clothing entity) throws Exception {
		return clothingRepository.update(entity);
	}

	@Override
	public List<Clothing> findByData(String Data) throws Exception {
		return this.clothingRepository.findByData(Data);
	}


}
