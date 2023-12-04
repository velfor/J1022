import by.itstep.HelloWorld;
import by.itstep.student.Group;
import by.itstep.student.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random gen = new Random();
        ClassPathXmlApplicationContext appContext =
                new ClassPathXmlApplicationContext("app.xml");

        /*HelloWorld helloWorld = appContext.getBean("helloWorld", HelloWorld.class);
        helloWorld.setHelloMessage("Hello ITStep");
        System.out.println(helloWorld);
        HelloWorld helloWorld1 = appContext.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld1);*/

        Group groupJ1022 = appContext.getBean("group", Group.class);
        for(int i=0; i<10; i++){
            Student stud = appContext.getBean("student", Student.class);
            stud.setFullName("Petrov Petr " + i);
            stud.setGroup("J1022");
            stud.setAvgMark(gen.nextInt(100)/10.);
            groupJ1022.addStudent(stud);
        }
        System.out.println(groupJ1022.toString());
    }
}
