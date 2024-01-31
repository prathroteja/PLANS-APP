package in.jam.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PLAN-MASTER")
public class Plan {
	
	@Id
	//@GeneratedValue
	private Integer planId;
	private String planName;
	private String planstartDate;
	private LocalDate planEnddate;
	private String activeSw;
	private Integer planCategoryId;
	private String craetedBy;
	private String updatedBy;
	@Column(name="CREATED-DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name="UPDATED-DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updateDate;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanstartDate() {
		return planstartDate;
	}
	public void setPlanstartDate(String planstartDate) {
		this.planstartDate = planstartDate;
	}
	public LocalDate getPlanEnddate() {
		return planEnddate;
	}
	public void setPlanEnddate(LocalDate planEnddate) {
		this.planEnddate = planEnddate;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public Integer getPlanCategoryId() {
		return planCategoryId;
	}
	public void setPlanCategoryId(Integer planCategoryId) {
		this.planCategoryId = planCategoryId;
	}
	public String getCraetedBy() {
		return craetedBy;
	}
	public void setCraetedBy(String craetedBy) {
		this.craetedBy = craetedBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", planstartDate=" + planstartDate
				+ ", planEnddate=" + planEnddate + ", activeSw=" + activeSw + ", planCategoryId=" + planCategoryId
				+ ", craetedBy=" + craetedBy + ", updatedBy=" + updatedBy + ", createdDate=" + createdDate
				+ ", updateDate=" + updateDate + "]";
	}
	
}
