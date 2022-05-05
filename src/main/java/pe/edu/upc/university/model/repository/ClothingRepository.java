package pe.edu.upc.university.model.repository;

import java.util.List;

import pe.edu.upc.university.model.entity.Clothing;

public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
	List<Clothing> findByData(String Name) throws Exception;
}
