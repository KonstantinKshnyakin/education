//package ru.alishev.springcourse;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ru.alishev.springcourse.config.HibernateConfig;
//import ru.alishev.springcourse.config.SpringConfig;
//import ru.alishev.springcourse.models.Person;
//import ru.alishev.springcourse.service.PersonService;
//
//import java.util.List;
//
//public class MainApp {
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(HibernateConfig.class);
//
//        PersonService personService = context.getBean(PersonService.class);
//
//        // Add Users
//        personService.save(new Person("Bora"));
//        personService.save(new Person("Miller"));
//        personService.save(new Person("Singh"));
//        personService.save(new Person("Smith"));
//
//        // Get Users
//        List<Person> people = personService.findAll();
//        for (Person person : people) {
//            System.out.println("Id = "+ person.getId());
//            System.out.println("Name = "+ person.getName());
//            System.out.println();
//        }
//
//        context.close();
//    }
//}
