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

    @Getter
    public String getFirst_name() {
        return first_name;
    }

    @Getter
    public String getLast_name() {
        return last_name;
    }

    @Getter
    public String getIndex_Number() {
        return index_number;
    }

    @Getter
    public String getGroup_id() {
        return group_id;
    }

    @Getter
    public String getSub_group() {
        return sub_group;
    }

    @Getter
    public String getId() {
        return id;
    }

    @Setter
    public void setFirst_name(String fname) {
        this.first_name = fname;
    }

    @Setter
    public void setLast_name(String lname) {
        this.last_name = lname;
    }

    @Setter
    public void setIndex_Number(String indexNumber) {
        this.index_number = indexNumber;
    }

    @Setter
    public void setGroup_id(String group) {
        this.group_id = group;
    }

    @Setter
    public void setSub_group(String sub_group) {
        this.sub_group = sub_group;
    }

    @Setter
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
