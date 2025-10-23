package dmit2015.persistence;

import dmit2015.entity.Department;
import dmit2015.entity.Employee;
import jakarta.data.repository.Find;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository(dataStore = "oracle-jpa-hr-pu")
public interface HumanResourcesRepository {

    @Query("select d from Department d where lower(d.departmentName) like lower(?1) order by d.departmentName")
    List<Department> departmentsBy(String departmentName);

    @Find
    Department departmentByDepartmentId(Short id);

    @Query("select e from Employee e join fetch e.manager join fetch e.job join fetch e.department where e.department.id = ?1")
    List<Employee> employeesBy(Short departmentId);
}
