package pe.edu.upc.university.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CategoriesService;
import pe.edu.upc.university.business.crud.CrudService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.university.model.entity.Categories;


@Named("categoriesView")
@ViewScoped
public class CategoriesView implements Serializable, EntityView<Categories, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Categories> entities;
	private Categories entitySelected;
	private List<Categories> entitiesSelected;
	private Categories entitySearch;
	
	@Inject
	private CategoriesService entityService;
	
	public void saveCategories() {
		try {
			this.entityService.create(this.entitySelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public CrudService<Categories, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Categories();		
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Categories> getEntities() {
		return entities;
	}

	public void setEntities(List<Categories> entities) {
		this.entities = entities;
	}

	public Categories getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Categories entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Categories> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Categories> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Categories getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Categories entitySearch) {
		this.entitySearch = entitySearch;
	}

	public CategoriesService getEntityService() {
		return entityService;
	}

	public void setEntityService(CategoriesService entityService) {
		this.entityService = entityService;
	}
	
	@PostConstruct
	public void init() {
		
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Categories();
		getAllEntities();
	}
}
