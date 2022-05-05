package pe.edu.upc.university.model.repository;


import java.util.List;

import pe.edu.upc.university.model.entity.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{

	List<Users> findByData(String Data) throws Exception;
}
