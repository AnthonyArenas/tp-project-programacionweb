package pe.edu.upc.university.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.university.business.crud.CategoriesService;
import pe.edu.upc.university.model.entity.Categories;

@Named("originalView")
@ViewScoped
public class OriginalView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Categories> entities;
	private Categories entitySelected;
	private List<Categories> entitiesSelected;
	private Categories entitySearch;
	
	@Inject
	private CategoriesService entityService;
	
	@PostConstruct
	public void init() {
		entitiesSelected = new ArrayList<>();
		entitySearch = new Categories();
		getAllEntities();
	}
	
	public boolean hasEntitiesSelected() {
		if (entitiesSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasEntitySelected() {
		if (entitiesSelected.size() == 1) {
			return true;
		}
		return false;
	}
	public void createNew() {
		entitySelected = new Categories();		
	}
	public void editEntitySelected() {
		entitySelected = entitiesSelected.get(0);
	}
	public void saveEntity() {
		try {
			if (entitySelected.getId() == null) {
				entityService.create(entitySelected);
				entities.add(entitySelected);
			} 
			else {
				entityService.update(entitySelected);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('entityDialog').hide()");
        PrimeFaces.current().ajax().update("entityDataTable");
	}
	public void deleteEntity() {
		try {
			this.entities.remove(entitySelected);
			entityService.deleteById(this.entitySelected.getId());
			this.entitySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		PrimeFaces.current().ajax().update("form:messages", "entityDataTable");
	}
	public void searchEntity() {
		try {	// MOdificar de acuerdo al Entity
			entities = entityService.search(entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllEntities() {
		try {
			entities = entityService.getAll();
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
	
		
	
}