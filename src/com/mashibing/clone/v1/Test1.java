package com.mashibing.clone.v1;

public class Test1 {
    public static void main(String[] args) throws Exception{
        Person p1 = new Person();
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.location.local);

        Person p2 = (Person)p1.clone();

        System.out.println(p2.name);
        System.out.println(p2.age);
        System.out.println(p2.location.local);
        p1.name = "Lwx";
        p1.age = 26;
        p1.location.local = "tj";
        System.out.println(p1.name == p2.name);
        System.out.println(p1.age == p2.age);
        System.out.println(p1.location == p2.location);
    }
}

class Person implements Cloneable{
    public String name = "liwenxuan";
    public int age = 27;
    public Location location = new Location("bj");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.location = (Location) location.clone();
        return p;
    }
}

class Location implements Cloneable{
    public String local;

    public Location(String local) {
        this.local = local;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}