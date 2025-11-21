package com.employee.empRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.empEntity.EmployeeEntity;

public interface EmployeeRepository  extends JpaRepository <EmployeeEntity,Integer>{

//native querybased//
@Query(value="SELECT max(salary)from employee1.employeedetails",nativeQuery=true)
public int getmax();

@Query(value="SELECT * from employee1.employeedetails where salary=(select max(salary)from employee1.employeedetails)",nativeQuery = true)
public EmployeeEntity getmaxobjcall();

@Query(value="SELECT * from employee1.employeedetails where salary=?1",nativeQuery=true)
public List<EmployeeEntity>getemp(Integer a);

@Query(value="SELECT * from employee1.employeedetails where salary=?1",nativeQuery=true)
public List<EmployeeEntity>getsalaryall(Integer a,Integer b);

@Query(value="select * from employee1.employeedetails where id=1",nativeQuery=true)
public List<EmployeeEntity>getid();//jpqlquery

@Query(value="SELECT e from EmployeeEntity e")
public List<EmployeeEntity>getallvalue();

@Query(value="SELECT e.salary from EmployeeEntity e" )
public List<Integer>getsalaryvalue();

@Query("SELECT MAX(e.salary)from EmployeeEntity e where e.salary<(SELECT MAX(e2.salary)from EmployeeEntity e2)")//2max sal jpql
public Integer get2maxsal();

@Query ("select s2 from EmployeeEntity s2 where salary=(SELECT MAX(e.salary)from EmployeeEntity e where e.salary<(SELECT MAX(s1.salary)from EmployeeEntity s1))")
public List<EmployeeEntity> get2maxobj();

@Query("SELECT e from EmployeeEntity e where e.salary between ?1 and ?2")
public List<EmployeeEntity>getsalrange1(Integer a, Integer b);


@Query("SELECT e from EmployeeEntity e where e.salary between :a and :b")
public List<EmployeeEntity>getrange(@Param ("a")Integer a,@Param("b")Integer b);

@Query(value="SELECT * FROM employee1.employeedetails where name= ?1",nativeQuery=true)
public List<EmployeeEntity>getNamedetails(String a);

@Query(value="SELECT *FROM employee1.employeedetails where salary= ?1",nativeQuery=true)
public List<EmployeeEntity>getSalarydetail(Integer a);

@Query(value="SELECT * FROM employee1.employeedetails where experience=?1",nativeQuery=true)
public List<EmployeeEntity>getexperience(float a);

}