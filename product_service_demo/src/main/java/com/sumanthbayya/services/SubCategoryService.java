package com.sumanthbayya.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumanthbayya.entities.Master_Category;
import com.sumanthbayya.entities.Master_Department;
import com.sumanthbayya.entities.Master_SubCategory;
import com.sumanthbayya.repositories.CategoryDAO;
import com.sumanthbayya.repositories.DepartmentDAO;
import com.sumanthbayya.repositories.LocationDAO;
import com.sumanthbayya.repositories.SubCategoryDAO;
import com.sumanthbayya.vo.SubCategoryVo;

@Service
public class SubCategoryService {

	private static final Logger LOG = LoggerFactory.getLogger(SubCategoryService.class);
	
	@Autowired
	LocationDAO locationDao;
	
	@Autowired
	DepartmentDAO departmentDAO;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	SubCategoryDAO subCategoryDao;
	
	@Autowired
	CommonService commonService;
	
	
	public List<SubCategoryVo> getSubCategoryByCategoryAndDepartmentAndLocation(String location_id, String department_id,String category_id, String subcategory_id) {

		LOG.info("Getting locations and department wise categories");
			List<Master_SubCategory> subcatDBData = new ArrayList<>();
			List<Master_Department> depsByLocationList = commonService.getDepartmentsByLocationId(Long.valueOf(location_id));
			for (Master_Department master_Department : depsByLocationList) {
				categoryDao.findByMasterCategoryIdAndDepartment(Long.valueOf(category_id),master_Department);
				for (Master_Category master_category : categoryDao.findByMasterCategoryIdAndDepartment(Long.valueOf(category_id),master_Department)) {
					// commonService.getCategoryByObjectId(master_category.getMasterCategoryId())
					for (Master_SubCategory master_SubCategory : subCategoryDao.findByMasterSubCategoryIdAndCategory(Long.valueOf(subcategory_id),master_category)) {
						subcatDBData.add(master_SubCategory);
					}
				}
			}
			List<SubCategoryVo> uiCatVo  = new ArrayList<>();
			for (Master_SubCategory master_SubCategory : subcatDBData) {
				SubCategoryVo scvo = new SubCategoryVo();
				scvo.setActiveFlag(master_SubCategory.getMasterSubCatActiveFlag());
				scvo.setCategoryId(master_SubCategory.getCategory().getMasterCategoryId());
				scvo.setCategoryName(master_SubCategory.getCategory().getMasterCategoryName());
				scvo.setDepartmentId(master_SubCategory.getCategory().getDepartment().getMasterDepartmentId());
				scvo.setDepartmentName(master_SubCategory.getCategory().getDepartment().getMasterDepartmentName());
				scvo.setLocationId(master_SubCategory.getCategory().getDepartment().getLocation().getMasterLocationId());
				scvo.setLocationName(master_SubCategory.getCategory().getDepartment().getLocation().getMasterLocationName());
				scvo.setId(master_SubCategory.getMasterSubCategoryId());
				scvo.setSubCateogryName(master_SubCategory.getMasterSubCategoryName());
				scvo.setSubCategoryDesc(master_SubCategory.getMasterSubCategoryName());
				
				
				uiCatVo.add(scvo);
			}
			
			return uiCatVo;
		
	}

	public void deleteSubCategoryByCategoryAndDepartmentAndLocation(String subcategory_id) {
		subCategoryDao.deleteById(Long.valueOf(subcategory_id));
		
	}
}
