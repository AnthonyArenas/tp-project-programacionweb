package pe.edu.upc.university.model.repository;

import java.util.List;

import pe.edu.upc.university.model.entity.ListClothing;

public interface ListClothingRepository extends JpaRepository<ListClothing, Integer> {
	List<ListClothing> findByData(String Data) throws Exception;
}
