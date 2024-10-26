package StudentPackage;

import java.util.Arrays;

public class Student {
    private static final int MIN_SCORE = 3;

    private String name;
    private int group;
    private int course;
    private int[] marks;

    public Student(String name, int group, int course, int[]marks){
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public int getCourse() {
        return this.course;
    }

    public boolean tryUpgradeCourse (){
        if (Arrays.stream(this.marks).sum() / this.marks.length >= 3){
            this.course++;
            return true;
        }
        return false;
    }
}
