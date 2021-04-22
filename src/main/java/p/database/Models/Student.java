package p.database.Models;

import p.database.Annotations.Getter;
import p.database.Annotations.Setter;

public class Student {

    private String id;
    private String first_name;
    private String last_name;
    private String index_number;
    private String group_id;
    private String sub_group;

    @Getter(columnName = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    @Getter(columnName = "last_name")
    public String getLast_name() {
        return last_name;
    }

    @Getter(columnName = "index_number")
    public String getIndex_Number() {
        return index_number;
    }

    @Getter(columnName = "group_id")
    public String getGroup_id() {
        return group_id;
    }

    @Getter(columnName = "sub_group")
    public String getSub_group() {
        return sub_group;
    }

    @Getter(columnName = "id")
    public String getId() {
        return id;
    }

    @Setter(columnName = "first_name")
    public void setFirst_name(String fname) {
        this.first_name = fname;
    }

    @Setter(columnName = "last_name")
    public void setLast_name(String lname) {
        this.last_name = lname;
    }

    @Setter(columnName = "index_number")
    public void setIndex_Number(String indexNumber) {
        this.index_number = indexNumber;
    }

    @Setter(columnName = "group_id")
    public void setGroup_id(String group) {
        this.group_id = group;
    }

    @Setter(columnName = "sub_group")
    public void setSub_group(String sub_group) {
        this.sub_group = sub_group;
    }

    @Setter(columnName = "id")
    public void setId(String id) {
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
        private String id;

        public StudentBuilder setId(String id) {
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
            student.first_name = this.fname;
            student.last_name = this.lname;
            student.group_id = this.group;
            student.sub_group = this.sub_group;
            student.index_number = this.indexNumber;

            return student;
        }

    }

    public static StudentBuilder getInstanceOfStudentBuilder(){
        return new StudentBuilder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", indexNumber='" + index_number + '\'' +
                ", group_id='" + group_id + '\'' +
                ", sub_group='" + sub_group + '\'' +
                '}';
    }
}
