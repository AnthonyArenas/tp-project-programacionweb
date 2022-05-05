package pe.edu.upc.university.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import pe.edu.upc.university.business.crud.CrudService;

public interface EntityView<T, ID> {

	CrudService<T, ID> getCrudService();
	
	default boolean hasEntitiesSelected() {
		if (getEntitiesSelected().isEmpty()) {
			return false;
		}
		return true;
	}
	
	default boolean hasEntitySelected() {
		if (getEntitiesSelected().size() == 1) {
			return true;
		}
		return false;
	}
	
	void createNew();
	
	default void editEntitySelected() {
		setEntitySelected(getEntitiesSelected().get(0));
	}
	
	ID getIdFromEntitySelected();
	
	
	default void saveEntity() {
		try {
			if (getIdFromEntitySelected() == null) {
				getCrudService().create(getEntitySelected());
				getEntities().add(getEntitySelected());
			} else {
				getCrudService().update(getEntitySelected());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('entityDialog').hide()");
		PrimeFaces.current().ajax().update("entityDataTable");
	}
	
	default void deleteEntity() {
		try {
			getEntities().remove(getEntitySelected());
			getCrudService().deleteById(getIdFromEntitySelected());
			setEntitySelected(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		PrimeFaces.current().ajax().update("form:messages", "entityDataTable");
	}
	void searchEntity();
	
	default void getAllEntities() {
		try {
			setEntities(getCrudService().getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	List<T> getEntities();
	void setEntities(List<T> entities);
	
	List<T> getEntitiesSelected();
	
	T getEntitySelected();
	void setEntitySelected(T entitySelected);
	
}