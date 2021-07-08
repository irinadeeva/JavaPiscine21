package edu.school21;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static Method[] declaredMethods;
    static Field[] declaredFields;


    public static void main(String[] args) {

        Set<Class> classes = new Reflections("edu.school21.classes", new SubTypesScanner(false))
                .getSubTypesOf(Object.class)
                .stream()
                .collect(Collectors.toSet());

        if (classes.size() != 0) {
            System.out.println("Classes:");
            for (Class c : classes) {
                System.out.println("  - " + c.getSimpleName());
            }
            System.out.println("---------------------");
            chooseMethod(classes);
        } else {
            System.out.println("No classes in the package edu.school21.classes.");
        }
    }


    private static void chooseMethod(Set<Class> classes) {
        String line;
        boolean flag = false;

        while (true) {
            System.out.println("Enter class name:");
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine();
            for (Class c : classes) {
                if (c.getSimpleName().equals(line)) {
                    System.out.println("---------------------");
                    printField(c);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            System.out.println("The class name is wrong.");
        }
    }

    private static void printField(Class c) {

        declaredFields = c.getDeclaredFields();
        if (declaredFields.length != 0)
            System.out.println("fields:");
        for (Field field : declaredFields) {
            System.out.println("    " + field.getType().getSimpleName() + " " + field.getName());
        }
        printMethods(c);
    }

    private static void printMethods(Class c) {

        declaredMethods = c.getDeclaredMethods();

        Method[] objectMethods = new Object().getClass().getMethods();
        HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
        for (Method method : objectMethods)
            hash.put(method.getName(), false);

        if (declaredMethods.length != 0)
            System.out.println("methods:");
        for (Method m : declaredMethods) {
            if (!hash.containsKey(m.getName())) {
                System.out.print(
                        "    " + m.getReturnType().getSimpleName()
                                + " " + m.getName() + "(");
                Class<?>[] types = m.getParameterTypes();
                for (Class t : types) {
                    System.out.print(t.getSimpleName());
                }
                System.out.println(")");
            }
        }
        System.out.println("---------------------");
        try {
            createObject(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void createObject(Class c) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("Let’s create an object.");

        Object name = "Ira";
        Object surname = "SaM";
        Object pN = 1;


/*
        Customer customer = new Customer(name, surname, pN);
        System.out.println(customer);
        c.newInstance(name, surname , pN);
*/


        //Class randomClass = Class.forName(c.getName());
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() != 0) {
                constructor.getParameterTypes();
            }
        }

  /*      Object o = randomClass.newInstance();
        System.out.println(o);
*/
        //Constructor<?>[] constructors = randomClass.getConstructors();


    }
}
