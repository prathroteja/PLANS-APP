package in.jam.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jam.entity.Plan;
import in.jam.service.Planservice;

@RestController
public class PlanRestController {
	
	@Autowired
	private Planservice planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		
		Map<Integer,String> categories=planService.getPlanCategories();
		
		return new ResponseEntity<>(categories,HttpStatus.OK);
		
	}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String responseMsg="";
		boolean isSaved=planService.savePlan(plan);
		if(isSaved) {
			responseMsg="plan saved";
		}else {
			responseMsg="plan not saved";
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
		
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans()
{
		List<Plan> allplans = planService.getAllPlans();
		return new ResponseEntity<>(allplans,HttpStatus.OK);
		
		}
	
	@GetMapping("/plan{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan=planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean isUpdated=planService.updatePlan(plan);
		String msg="";
		if(isUpdated) {
			msg="planUpdated";
		}else {
			msg="plan not updated";
			
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/plan{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted=planService.deletePlanById(planId);
		String msg="";
		if(isDeleted) {
			msg="planDeleted";
		}else {
			msg="plan not deleted";
			
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(Integer planId, String status){
		String msg="";
		boolean isStatusChanged = planService.planStatusChange(planId,status);
		
		if(isStatusChanged) {
			msg="status changesd";
			
		}else {
			msg="status not chanhed";
		}
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}

	
	
}
