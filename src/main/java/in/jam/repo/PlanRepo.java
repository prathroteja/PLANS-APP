package in.jam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.jam.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer>{

}
