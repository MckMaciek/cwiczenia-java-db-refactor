package p.database.Models;

public class Student {
    private String fname;
    private String lname;
    private String indexNumber;
    private String group;
    private String sub_group;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getGroup() {
        return group;
    }

    public String getSub_group() {
        return sub_group;
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

    public Student(){

    }

    public static class StudentBuilder{
        private String fname;
        private String lname;
        private String indexNumber;
        private String group;
        private String sub_group;

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
