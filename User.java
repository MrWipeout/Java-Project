/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.io.Serializable;

public class User implements Serializable {
    // i klassh auth anaferetai ston xrhsth kai ta stoixeia tou
    // kanei implements Serializable gia na mporesoume to apothikeusoume se arxeio

    private String name; //dhlwsh metavlhtwn
    private int score;
    
public User(String name) {//overload constructor
        this.name = name;
    }
    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    
    //setters kai getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User() {//default constructor
    }
    

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
