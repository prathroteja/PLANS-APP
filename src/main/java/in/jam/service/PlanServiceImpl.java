package in.jam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jam.entity.Plan;
import in.jam.entity.PlanCategory;
import in.jam.repo.PlanCategoryRepo;
import in.jam.repo.PlanRepo;

@Service
public  class PlanServiceImpl implements Planservice{

	

	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> categories=planCategoryRepo.findAll();
		Map<Integer,String> categoryMap=new HashMap<>();
		
		categories.forEach(category->{
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
			
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved=planRepo.save(plan);
//		if(saved.getPalnId()!=null) {
//			return true;
//		}
//			else {
//				return false;
//			}
//		
		//saved.getPlanId()!=null? true:false;
		
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
		
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save=planRepo.save(plan);
		return save.getPlanId()!=null;
		
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try {
			
			planRepo.deleteById(planId);
			status= true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		
		Optional<Plan> findbyId=planRepo.findById(planId);
		if(findbyId.isPresent()) {
			Plan plan=findbyId.get();
			planRepo.save(plan);
			return true;
		}
		
		return false;
	}

	
	

	

}
