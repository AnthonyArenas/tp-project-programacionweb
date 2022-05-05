package pe.edu.upc.university.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.ClothingService;
import pe.edu.upc.university.business.crud.CrudService;
import pe.edu.upc.university.model.entity.Clothing;


@Named("clothingView")
@ViewScoped
public class ClothingView implements Serializable, EntityView<Clothing, Integer>{

	private static final long serialVersionUID = 1L;
	
	private List<Clothing> entities;
	private Clothing entitySelected;
	private List<Clothing> entitiesSelected;
	private Clothing entitySearch;
	
	@Inject
	private ClothingService entityService;
	
	public void saveClothing() {
		try {
			this.entityService.create(this.entitySelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public CrudService<Clothing, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Clothing();		
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Clothing> getEntities() {
		return entities;
	}

	public void setEntities(List<Clothing> entities) {
		this.entities = entities;
	}

	public Clothing getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Clothing entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Clothing> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Clothing> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Clothing getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Clothing entitySearch) {
		this.entitySearch = entitySearch;
	}

	public ClothingService getEntityService() {
		return entityService;
	}

	public void setEntityService(ClothingService entityService) {
		this.entityService = entityService;
	}
	
	@PostConstruct
	public void init() {
		
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Clothing();
		getAllEntities();
	}


}
