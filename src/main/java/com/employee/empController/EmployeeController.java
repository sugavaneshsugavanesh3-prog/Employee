package com.employee.empController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.GlobalExceptionHandler.ExperienceNotFoundException;
import com.employee.GlobalExceptionHandler.NameNotFoundException;
import com.employee.GlobalExceptionHandler.SalaryNotFoundException;
import com.employee.empEntity.EmployeeEntity;
import com.employee.empRepository.EmployeeRepository;
import com.employee.empService.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@Autowired
	EmployeeRepository er;
	@PostMapping(value="postData")
	public String postData(@RequestBody EmployeeEntity e) {
return es.postData(e);
	}
	

	@PostMapping(value="postData1")
	public String postData1(@RequestBody List<EmployeeEntity> e) {
	return es.postData1(e);
}
	@GetMapping(value="getData/{a}")
	public EmployeeEntity getData(@PathVariable int a) {
		return es.getData(a);
	}
	@GetMapping(value="getData1")
	public List <EmployeeEntity> getData1() {
		return es.getData1();
	}
	@PutMapping("update/{a}")
	public String updatevalue(@RequestBody EmployeeEntity e,@PathVariable Integer a) {
		return es.updatevalue(e,a);
		
	}
	@PatchMapping("update1/{a}")
	public String update1(@RequestBody EmployeeEntity e,@PathVariable Integer a) {
		return es.update1(e,a);
	}
	@DeleteMapping("/delete/{a}")
	public String delete(@PathVariable Integer a) {
		return es.delete(a);
	}
@DeleteMapping("/deleteValue/{a}")
public String deleteValue(@PathVariable Integer a) {
	return es.deleteValue(a);
}
//service class implementation(day3/11/11/25)
@GetMapping(value="maxsalary")
public int maxsalary() {
return es.maxsalary();
	}
@GetMapping(value="getobjcall")
public EmployeeEntity getobjcall() {
	return es.getobjcall();
}
@GetMapping(value="get1/{a}")
public List<EmployeeEntity>get1(@PathVariable String a){
	return es.get1(a);
}
@GetMapping(value="getsalaryRange/{a}/{b}")
public List<EmployeeEntity>getsalaryRange(@PathVariable Integer a,Integer b){
	return es.getsalaryRange(a,b);
}
@GetMapping(value="getcount/{a}/{b}")
public long getcount(@PathVariable String a,String b){
	return es.getcount(a,b);
}//native query solved
@GetMapping(value="/getmax")
public int getmax() {
	return es.getmax();
}
@GetMapping(value="/getmaxobjcall")
public  EmployeeEntity getmaxobjcall() {
	return es.getmaxobjcall();
}
@GetMapping(value="/getemp/{a}")
public List<EmployeeEntity> getemp(@PathVariable int a) {
	return es.getemp(a);
}
@GetMapping(value="getsalaryall/{a}/{b}")
public List<EmployeeEntity>getsalaryall(@PathVariable Integer a,@PathVariable Integer b){
	return es.getsalaryall(a,b);
}
@GetMapping(value="getid")
public List<EmployeeEntity>getid(){
	return es.getid();
}
//jpqlquery
@GetMapping(value="getall")
public List<EmployeeEntity> getallvalue(){
	return es.getallvalue();
}
@GetMapping(value="getsalaryvalue")//jpqlquerybased salary value
public List<Integer>getsalaryvalue(){
	return es.getsalaryvalue();
	
}
@GetMapping(value="get2maxsal")//maximum 2sal jpql print only salary
public Integer get2maxsal() {
	return es.get2maxsal();
}
@GetMapping(value="get2maxobj")
public List <EmployeeEntity> get2maxobj() {
	return es.get2maxobj();
}

@GetMapping(value="getparam")
public List<EmployeeEntity>getsalrange1(@RequestParam Integer a,@RequestParam Integer b){
	return es.getsalrange1(a, b);
}
@GetMapping(value="getsalary1")
public List<EmployeeEntity> getrange(@RequestParam Integer a,@RequestParam Integer b){
	return es.getrange(a, b);
}
//exception

@GetMapping("getNamedetails/{a}")
public List<EmployeeEntity>getNamedetails(@PathVariable String a) throws NameNotFoundException {
	return es.getNamedetails(a);

}
@GetMapping("getSalarydetail/{a}")
public List<EmployeeEntity>getSalarydetail(@PathVariable Integer a)throws SalaryNotFoundException {
	return es.getSalarydetail(a);
	
}
@GetMapping("getexperience/{a}")
public List<EmployeeEntity>getexperience(@PathVariable float a)throws ExperienceNotFoundException {
	return es.getexperience(a);
}
}