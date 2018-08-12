package com.sumanthbayya.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumanthbayya.entities.Master_Category;
import com.sumanthbayya.entities.Master_Department;

@Transactional
@Repository
public interface CategoryDAO extends CrudRepository<Master_Category, Long>{
	
	List<Master_Category> findByMasterCategoryIdAndDepartment(Long masterCategoryId,Master_Department department);
	
	List<Master_Category> findByDepartment(Master_Department department);

}
