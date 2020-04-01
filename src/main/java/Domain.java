import buisnessLogic.Util;
import entity.Adress;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AdressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class Domain {
    public static void main(String[] args) {
        /*Util util = new Util();
        util.getConnection();*/

        //пока не работает

        AdressService adressService = new AdressService();
        EmployeeService employeeService = new EmployeeService();
        EmplProjService emplProjService = new EmplProjService();
        ProjectService projectService = new ProjectService();

        Adress adress = new Adress();
        adress.setId(1L);
        adress.setCountry("DC");
        adress.setCity("Gotham");
        adress.setStreet("Arkham street 1");
        adress.setPostCode("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAdress(adress);

        Project project = new Project();
        project.setId(1L);
        project.setTitle("Gotham City Police Department Commissioner");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(project.getId());

        try{
            adressService.createOne(adress);
            employeeService.createOne(employee);
            projectService.createOne(project);
            emplProjService.createOne(emplProj);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
