package in.jam.service;

import java.util.List;
import java.util.Map;

import in.jam.entity.Plan;

public interface Planservice {
	
	public Map<Integer, String> getPlanCategories();
	public boolean savePlan(Plan paln);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
	public boolean updatePlan(Plan plan);
	public boolean deletePlanById(Integer planId); 
	public boolean planStatusChange(Integer planId,String status);
	
	
	
	

}
