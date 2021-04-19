package p.database.Models;

public class Student {

    private Long id;
    private String fname;
    private String lname;
    private String indexNumber;
    private String group;
    private String sub_group;

    public String getterFname() {
        return fname;
    }

    public String getterLname() {
        return lname;
    }

    public String getterIndexNumber() {
        return indexNumber;
    }

    public String getterGroup() {
        return group;
    }

    public String getterSub_group() {
        return sub_group;
    }

    public Long getterId() {
        return id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSub_group(String sub_group) {
        this.sub_group = sub_group;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Student(){

    }

    public static class StudentBuilder{
        private String fname;
        private String lname;
        private String indexNumber;
        private String group;
        private String sub_group;
        private Long id;

        public StudentBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setFname(String fname) {
            this.fname = fname;
            return this;
        }

        public StudentBuilder setLname(String lname) {
            this.lname = lname;
            return this;
        }

        public StudentBuilder setIndexNumber(String indexNumber) {
            this.indexNumber = indexNumber;
            return this;
        }

        public StudentBuilder setGroup(String group) {
            this.group = group;
            return this;
        }

        public StudentBuilder setSub_group(String sub_group) {
            this.sub_group = sub_group;
            return this;
        }

        public Student build(){
            Student student = new Student();
            student.id = this.id;
            student.fname = this.fname;
            student.lname = this.lname;
            student.group = this.group;
            student.sub_group = this.sub_group;
            student.indexNumber = this.indexNumber;

            return student;
        }

    }

    public static StudentBuilder getInstanceOfStudentBuilder(){
        return new StudentBuilder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", group='" + group + '\'' +
                ", sub_group='" + sub_group + '\'' +
                '}';
    }
}
