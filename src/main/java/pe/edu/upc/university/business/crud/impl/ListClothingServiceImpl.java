package pe.edu.upc.university.business.crud.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.university.business.crud.ListClothingService;
import pe.edu.upc.university.model.entity.Clothing;
import pe.edu.upc.university.model.entity.ListClothing;
import pe.edu.upc.university.model.repository.JpaRepository;
import pe.edu.upc.university.model.repository.ListClothingRepository;

@Named
@ApplicationScoped
public class ListClothingServiceImpl implements ListClothingService {

	@Inject
	private  ListClothingRepository listClothingRepository;
	
	@Override
	public JpaRepository<ListClothing, Integer> getJpaRepository() {
		
		return this.listClothingRepository;
	}
	
	@Transactional
	@Override
	public ListClothing update(ListClothing entity) throws Exception {
		return listClothingRepository.update(entity);
	}

	@Override
	public List<ListClothing> findByData(String Data) throws Exception {
		return this.listClothingRepository.findByData(Data);
	}

}
