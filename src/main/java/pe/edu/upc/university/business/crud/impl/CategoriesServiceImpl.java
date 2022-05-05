package pe.edu.upc.university.business.crud.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.university.business.crud.CategoriesService;
import pe.edu.upc.university.model.entity.Categories;
import pe.edu.upc.university.model.repository.CategoriesRepository;
import pe.edu.upc.university.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class CategoriesServiceImpl implements CategoriesService, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private  CategoriesRepository categoriesRepository;
	
	@Override
	public JpaRepository<Categories, Integer> getJpaRepository() {
		return this.categoriesRepository;
	}
	

	@Transactional
	@Override
	public Categories update(Categories entity) throws Exception {
		return categoriesRepository.update(entity);
	}

	@Override
	public List<Categories> findByName(String Name) throws Exception {
		return this.categoriesRepository.findByName(Name);
	}


}
