public class Student{
  private String name;
  private int age;
  private float grade;

  public Student(){
    this.name = "";
    this.age = 0;
    this.grade = 0.0f;
  };

  public Student(String name, int age, float grade){
    this.name = name;
    this.age = age;
    this.grade = grade;
  };

  public String getName(){
    return this.name;
  };

  public int getAge(){
    return this.age;
  };

  public float getGrade(){
    return this.grade;
  };

  public void setName(String name){
    this.name = name;
  };

  public void setAge(int age){
    if (age < 0) {
      System.out.println("Invalid age");
    }

    this.age = age;
  };

  public void setGrade(float grade){
    if (grade < 0.0f || grade > 5.0f) {
      System.out.println("Invalid grade");
      return;
    }

    this.grade = grade;
  };

  public void displayStudentInfo(){
    System.out.println("Student Name: " + this.name);
    System.out.println("Student Age: " + this.age);
    System.out.println("Student grade: " + this.grade);
  };
};
