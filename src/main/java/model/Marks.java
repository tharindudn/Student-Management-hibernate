package model;

/**
 * Created by tharindu on 7/19/17.
 */
public class Marks {

    private int id;
    private int marks1;
    private int marks2;

    public Marks() {

    }

    public Marks(int id, int marks1, int marks2) {
        id = this.id;
        marks1 = this.marks1;
        marks2 = this.marks2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }


}
