package com.tej.ComparatorAndComparable;

public class Employee implements Comparable<Employee>{
    Integer id;
    Integer age;
    Integer experience;

    @Override
    public int compareTo(Employee o) {
        return experience - o.experience;
    }

    public Employee(int id, int age, int experience){
        this.id = id;
        this.age = age;
        this.experience = experience;
    }
}
