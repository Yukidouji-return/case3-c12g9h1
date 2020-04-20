package model;

public class Classes {
    private int idClass;
    private String nameClass;
    private int amountStudent;

    public Classes(int idClass, String nameClass, int amountStudent) {
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.amountStudent = amountStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getAmountStudent() {
        return amountStudent;
    }

    public void setAmountStudent(int amountStudent) {
        this.amountStudent = amountStudent;
    }
}