package com.employee.empDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.GlobalExceptionHandler.NameNotFoundException;
import com.employee.empEntity.EmployeeEntity;
import com.employee.empRepository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;
	public String postData(EmployeeEntity e) {
		er.save(e);
		return "save successfully";
		
	}

	public String postData1(List<EmployeeEntity> e) {
		er.saveAll(e);
		return "save all sucessfully";
	}
	public EmployeeEntity getData(int a) {
		EmployeeEntity e =er.findById(a).get();
		return e;
		
	}
	public List<EmployeeEntity>getData1(){
		List<EmployeeEntity> e =er.findAll();
		return e;
	}
	public String updatevalue(EmployeeEntity e,Integer a) {
		EmployeeEntity x=er.findById(a).get();
		x.setName(e.getName());
		x.setSalary(e.getSalary());
		x.setExperience(e.getExperience());
		x.setGender(e.getGender());
		er.save(x);
		return"updated successfully";
	}
	public String update1(EmployeeEntity e,Integer a) {
		EmployeeEntity x=er.findById(a).get();
		x.setName(e.getName());
		er.save(x);
		return "updated suceesfully";
	}
	public String delete(Integer a) {
		er.deleteById(a);
		return "Deleted successfully";
	}
	public String deleteValue(Integer a) {
		EmployeeEntity x=er.findById(a).get();
		er.delete(x);
		return "Deleted successfully";
	}//native query based
	public int getmax() {
		return er.getmax();
		
	}
	public EmployeeEntity getmaxobjcall() {
		return er.getmaxobjcall();
	}
	public List<EmployeeEntity>getemp(int a){
		return er.getemp(a);
	}
	public List<EmployeeEntity>getsalaryall(Integer a,Integer b){
		return er.getsalaryall(a,b);
	}
	public List<EmployeeEntity>getid(){
		return er.getid();
	}//jpqlquery
	public List<EmployeeEntity>gatallvalue(){
		return er.getallvalue();
	}
	public List<Integer>getsalaryvalue(){
		return er.getsalaryvalue();
	}
	public Integer get2maxsal() {
		return er.get2maxsal();
	}
	public List<EmployeeEntity> get2maxobj(){
		return er.get2maxobj();
	}
	public List<EmployeeEntity>getsalrange1(Integer a,Integer b){
		return er.getsalrange1(a,b); 	 
		}
	public List<EmployeeEntity>getrange(Integer a,Integer b){
		return er.getrange(a,b);
	}
	public List<EmployeeEntity>getNamedetails( String a)  {
		return er.getNamedetails(a);
	}
	public List<EmployeeEntity>getSalarydetail(Integer a){
		return er.getSalarydetail(a);
	}
	public List<EmployeeEntity>getexperience(float a){
		return er.getexperience(a);
	}
}
