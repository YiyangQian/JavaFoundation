package com.yiyang.reflection.classObject;

/**
 * 3 different ways to get Class object
 * Approach 1 cons: most time there's no student object available
 * Approach 2 cons: Student class must have been compiled
 * Approach 3: recommended
 */
public class Reflection {
    public static void main(String[] args) {
        // Approach 1
        Student student = new Student();
        Class studentClass1 = student.getClass();
        System.out.println(studentClass1.getName());

        //Approach 2
        Class studentClass2 = Student.class;
        System.out.println(studentClass2 == studentClass1);

        //Approach 3
        try {
            Class studentClass3 = Class.forName("com.yiyang.reflection.classObject.Student");
            System.out.println(studentClass3 == studentClass1);
            System.out.println(studentClass3 == studentClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}