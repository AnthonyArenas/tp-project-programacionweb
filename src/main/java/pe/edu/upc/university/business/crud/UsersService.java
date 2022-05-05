package pe.edu.upc.university.business.crud;

import java.util.List;
import pe.edu.upc.university.model.entity.Users;

public interface UsersService extends CrudService<Users, Integer>{
	
	List<Users> findByData(String Data) throws Exception;
}
