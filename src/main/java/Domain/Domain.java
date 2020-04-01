package Domain;

import buisnessLogic.HibernateUtil;
import entity.Adress;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();*/

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Adress adress = new Adress();
        adress.setCountry("DC");
        adress.setCity("Gotham");
        adress.setStreet("Arkham street 1");
        adress.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham City Police Department Commissioner");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAdress(adress);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(adress);
        session.save(project);
        session.save(employee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
