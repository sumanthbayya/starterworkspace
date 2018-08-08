package com.sumanthbayya.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumanthbayya.entities.Master_Department;
import com.sumanthbayya.entities.Master_Location;

@Transactional
@Repository
public interface LocationDAO extends CrudRepository<Master_Location, Long>{
	
	Master_Location findByMasterLocationName(String masterLocationName);
}
