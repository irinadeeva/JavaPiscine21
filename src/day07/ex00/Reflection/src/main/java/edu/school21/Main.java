package edu.school21;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Method[] declaredMethods;
    static Field[] declaredFields;
    static Scanner sc = new Scanner(System.in);
    static String str = null;
    static Object tmp = null;

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
        boolean flag = false;

        while (true) {
            System.out.println("Enter class name:");
            str = sc.nextLine();
            for (Class c : classes) {
                if (c.getSimpleName().equals(str)) {
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
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createObject(Class c) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        System.out.println("Let’s create an object.");
        Object obj = c.newInstance();

        for (Field field : declaredFields) {
            System.out.println(field.getName() + ":");
            correctSnan(field);
            field.setAccessible(true);
            field.set(obj, tmp);
        }
        System.out.println(obj);
        changeField(obj, c);
    }

    private static void changeField(Object obj, Class c) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        System.out.println("---------------------");
        System.out.println("Enter name of the field for changing:");

        str = sc.nextLine();
        str = sc.nextLine();
        for (Field field : declaredFields) {
            if (str.equals(field.getName())) {
                System.out.println("Enter " + field.getType().getSimpleName() + " value:");
                correctSnan(field);
                field.setAccessible(true);
                field.set(obj, tmp);
                break;
            }
        }
        System.out.println(obj);
        callMethod(obj, c);
    }

    private static void callMethod(Object obj, Class c) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("---------------------");
        System.out.println("Enter name of the method for call:");

        str = sc.nextLine();
        str = sc.nextLine();
        for (Method method : declaredMethods) {

            String tmp = method.getName();
            String classes = "";
            Class<?>[] types = method.getParameterTypes();
            for (Class t : types) {
                classes += t.getSimpleName();
            }
            String all = tmp + "(" + classes + ")";
            if (str.equals(all)) {
                method.setAccessible(true);
                Class<?>[] params = method.getParameterTypes();
                for (Class<?> param : params) {
                    System.out.println("Enter " + param.getSimpleName() + " value");
                    str = sc.next();
                    if (!method.getReturnType().getSimpleName().equals("void")) {
                        System.out.print("Method returned: ");
                        if (param.equals(int.class)) {
                            Object value = method.invoke(obj, Integer.parseInt(str));
                            System.out.println((int) value);
                        } else if (param.equals(String.class)) {
                            Object value = method.invoke(obj, str);
                            System.out.println((String) value);
                        }
                    }
                    break;
                }
            }
        }
    }

    private static void correctSnan(Field field) throws ClassNotFoundException {
        tmp = Class.forName(field.getType().getName());
        if (tmp == Boolean.class) {
            while (sc.hasNextBoolean() == false) {
                sc.next();
            }
            tmp = sc.nextBoolean();
        } else if (tmp == String.class) {
            while (sc.hasNext() == false) {
                sc.next();
            }
            tmp = sc.next();
            ;
        } else if (tmp == Integer.class) {
            while (sc.hasNextInt() == false) {
                sc.next();
            }
            tmp = sc.nextInt();
        } else if (tmp == Double.class) {
            while (sc.hasNextDouble() == false) {
                sc.next();
            }
            tmp = sc.nextDouble();
        } else if (tmp == Long.class) {
            while (sc.hasNextLong() == false) {
                sc.next();
            }
            tmp = sc.nextLong();
        }
    }
}
