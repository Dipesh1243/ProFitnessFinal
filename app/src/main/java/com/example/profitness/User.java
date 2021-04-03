package com.example.profitness;

public class User {

    private String name,age,height,weight;

    public User(){

    }

    public User(String name, String age, String height, String weight){

        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }



    public String getName(){
        return name;
    }

    public String getAge(){
        return age;
    }

    public String getHeight(){
        return height;
    }

    public String getWeight(){
        return weight;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
