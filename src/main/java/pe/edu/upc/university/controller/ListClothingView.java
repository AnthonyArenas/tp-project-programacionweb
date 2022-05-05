package pe.edu.upc.university.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CrudService;
import pe.edu.upc.university.business.crud.ListClothingService;
import pe.edu.upc.university.model.entity.ListClothing;
import pe.edu.upc.university.model.entity.Users;

@Named("listClothingView")
@ViewScoped
public class ListClothingView implements Serializable, EntityView<ListClothing, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<ListClothing> entities;
	private ListClothing entitySelected;
	private List<ListClothing> entitiesSelected;
	private ListClothing entitySearch;
	
	@Inject
	private ListClothingService entityService;
	
	public void saveListClothing() {
		try {
			this.entityService.create(this.entitySelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public CrudService<ListClothing, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new ListClothing();
		this.entitySelected.setUsers(new Users());
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

	public List<ListClothing> getEntities() {
		return entities;
	}

	public void setEntities(List<ListClothing> entities) {
		this.entities = entities;
	}

	public ListClothing getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(ListClothing entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<ListClothing> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<ListClothing> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public ListClothing getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(ListClothing entitySearch) {
		this.entitySearch = entitySearch;
	}
	
	public ListClothingService getEntityService() {
		return entityService;
	}

	public void setEntityService(ListClothingService entityService) {
		this.entityService = entityService;
	}
	
	@PostConstruct
	public void init() {
//		this.entitySearch = new ListClothing();
//		this.entitySelected = new ListClothing();
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new ListClothing();
		getAllEntities();
	}
	
	
	
}
