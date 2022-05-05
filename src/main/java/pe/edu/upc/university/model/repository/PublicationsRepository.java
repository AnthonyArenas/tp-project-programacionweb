package pe.edu.upc.university.model.repository;

import java.util.List;

import pe.edu.upc.university.model.entity.ListClothing;
import pe.edu.upc.university.model.entity.Publications;

public interface PublicationsRepository extends JpaRepository<Publications, Integer> {
	List<Publications> findByData(String Name) throws Exception;
}
