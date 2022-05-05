package pe.edu.upc.university.business.crud;

import java.util.List;
import pe.edu.upc.university.model.entity.Publications;

public interface PublicationsServices extends CrudService<Publications, Integer> {
	List<Publications> findByData(String Name) throws Exception;
}
