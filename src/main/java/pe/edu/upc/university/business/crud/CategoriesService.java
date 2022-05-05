package pe.edu.upc.university.business.crud;

import java.util.List;

import pe.edu.upc.university.model.entity.Categories;

public interface CategoriesService extends CrudService<Categories, Integer>{
	
	List<Categories> findByName(String Name) throws Exception;
}
