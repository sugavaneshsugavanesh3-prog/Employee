package com.employee.empService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.GlobalExceptionHandler.ExperienceNotFoundException;
import com.employee.GlobalExceptionHandler.NameNotFoundException;
import com.employee.GlobalExceptionHandler.SalaryNotFoundException;
import com.employee.empDao.EmployeeDao;
import com.employee.empEntity.EmployeeEntity;
import com.employee.empRepository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	public String postData(EmployeeEntity e) {
	return ed.postData(e);
}
public String postData1(List<EmployeeEntity> e) {
	return ed.postData1(e);
}

public EmployeeEntity getData(int a) {
	return ed.getData(a);
}
public List<EmployeeEntity>getData1(){
	return ed.getData1();
}
public String updatevalue(EmployeeEntity e,Integer a) {
	return ed.updatevalue(e,a);
}
public String update1(EmployeeEntity e,Integer a) {
	return ed.update1(e,a);

}
public String delete(Integer a) {
	return ed.delete(a);

}
public String deleteValue(Integer a) {
	return ed.deleteValue(a);
}
//service class implemention(day3 11/11/25)
public int maxsalary() {
List<EmployeeEntity> aa=ed.getData1();
int cc=aa.stream().map(x->x.getSalary()).max(Comparable::compareTo).get();
return cc;
}
@Autowired
EmployeeRepository er;
public EmployeeEntity getobjcall() {
List<EmployeeEntity>x=er.findAll();
return x.stream()
.sorted(Comparator.comparing(EmployeeEntity::getSalary).reversed())
.findFirst().get();
}

public List <EmployeeEntity>get1(String a){
	List<EmployeeEntity>aa=er.findAll();
	List<EmployeeEntity>bb=aa.stream()
		.filter(x->x.getName().equals(a)).collect(Collectors.toList());
	return bb;
}
public List<EmployeeEntity>getsalaryRange(Integer a,Integer b){
	List<EmployeeEntity>x=ed.getData1();
	return x.stream().filter(y->y.getSalary()>a && y.getSalary()<b)
			.collect(Collectors.toList());
	
}


public long getcount(String a,String b) {
	List<EmployeeEntity>x=er.findAll();
	return x.stream()
			.filter(y->y.getName().startsWith(a)||y.getName().endsWith(b))
			.count();
}//native query based
public int getmax() {
	return ed.getmax();
}
public EmployeeEntity getmaxobjcall() {
	return ed.getmaxobjcall();
}
public List<EmployeeEntity>getemp (int a) {
	return ed.getemp(a);
}
public List<EmployeeEntity>getsalaryall(Integer a,Integer b){
	return ed.getsalaryall(a,b);
}
public List<EmployeeEntity>getid(){
	return ed.getid();
}//nativequery
public List<EmployeeEntity>getallvalue(){
	return ed.gatallvalue();
}
public List<Integer>getsalaryvalue(){
	return ed.getsalaryvalue();
}
public Integer get2maxsal() {
	return ed.get2maxsal();
}
public List<EmployeeEntity>get2maxobj(){
	return ed.get2maxobj();
	
}
public List <EmployeeEntity>getsalrange1(Integer a,Integer b) {
	return ed.getsalrange1(a,b);
	
 }
public List<EmployeeEntity>getrange(Integer a,Integer b){
	return ed.getrange(a,b);
}

//Exception
public List<EmployeeEntity>getNamedetails(String a)throws NameNotFoundException{
	List<EmployeeEntity> x = ed.getNamedetails(a);
	if(x.isEmpty()) {
		throw new NameNotFoundException("Name Not Found");
	}
	else {
		return ed.getNamedetails(a);
		
	}
		
	}
public List<EmployeeEntity>getSalarydetail(Integer a)throws SalaryNotFoundException {
List<EmployeeEntity> x=ed.getSalarydetail(a);
if(x.isEmpty()) {
	throw new SalaryNotFoundException("SalaryNotFound");
	
}
else {
return ed.getSalarydetail(a);
}
}
public List<EmployeeEntity>getexperience(float a)throws ExperienceNotFoundException {
	List<EmployeeEntity>x=ed.getexperience(a);
	if(x.isEmpty()) {
		throw new ExperienceNotFoundException("Experience Not Found");
	}
	else {
		return ed.getexperience(a);
	}
}
}


