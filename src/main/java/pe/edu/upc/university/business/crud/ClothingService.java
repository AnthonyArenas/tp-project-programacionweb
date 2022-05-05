package pe.edu.upc.university.business.crud;

import java.util.List;
import pe.edu.upc.university.model.entity.Clothing;

public interface ClothingService extends CrudService<Clothing, Integer>{
	List<Clothing> findByData(String Data) throws Exception;
}
