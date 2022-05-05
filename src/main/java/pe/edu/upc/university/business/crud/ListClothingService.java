package pe.edu.upc.university.business.crud;

import java.util.List;
import pe.edu.upc.university.model.entity.ListClothing;

public interface ListClothingService extends CrudService<ListClothing, Integer> {
	
	List<ListClothing> findByData(String Data) throws Exception;
}
