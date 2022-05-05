package pe.edu.upc.university.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CrudService;
import pe.edu.upc.university.business.crud.UsersService;
import pe.edu.upc.university.model.entity.Users;


@Named("usersView")
@ViewScoped
public class UsersView implements Serializable, EntityView<Users, Integer>{
	
	private static final long serialVersionUID = 1L;
	
	private List<Users> entities;
	private Users entitySelected;
	private List<Users> entitiesSelected;
	private Users entitySearch;
	
	@Inject
	private UsersService entityService;
	
	public void saveCategories() {
		try {
			this.entityService.create(this.entitySelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public CrudService<Users, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Users();		
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

	public List<Users> getEntities() {
		return entities;
	}

	public void setEntities(List<Users> entities) {
		this.entities = entities;
	}

	public Users getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Users entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Users> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Users> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Users getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Users entitySearch) {
		this.entitySearch = entitySearch;
	}

	public UsersService getEntityService() {
		return entityService;
	}

	public void setEntityService(UsersService entityService) {
		this.entityService = entityService;
	}
	
	@PostConstruct
	public void init() {
		
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Users();
		getAllEntities();
	}
	
	
}
