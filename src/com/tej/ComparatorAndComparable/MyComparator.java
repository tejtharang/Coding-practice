package com.tej.ComparatorAndComparable;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator {
    public static void main(String[] args) {
        Employee e1 = new Employee(1,50,100);
        Employee e2 = new Employee(2,40,50);

        Employee [] arr = {e1,e2};

        Arrays.sort(arr);

        for(Employee e : arr){
            System.out.println(e.id);
        }

        Arrays.sort(arr, experienceComparator);
        for(Employee e : arr){
            System.out.println(e.id);
        }

    }

    public static Comparator<Employee> experienceComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.experience - o1.experience;
        }
    };

}

