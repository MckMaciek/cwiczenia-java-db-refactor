package p.database.Models;

public class Student {

    private Long id;
    private String first_name;
    private String last_name;
    private String indexNumber;
    private String group_id;
    private String sub_group;

    public Long getId() {
        return id;
    }


    public String getterFirst_name() {
        return first_name;
    }

    public String getterLast_name() {
        return last_name;
    }

    public String getterIndexNumber() {
        return indexNumber;
    }

    public String getterGroup_id() {
        return group_id;
    }

    public String getterSub_group() {
        return sub_group;
    }

    public Long getterId() {
        return id;
    }

    public void setFirst_name(String fname) {
        this.first_name = fname;
    }

    public void setLast_name(String lname) {
        this.last_name = lname;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setGroup_id(String group) {
        this.group_id = group;
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
            student.first_name = this.fname;
            student.last_name = this.lname;
            student.group_id = this.group;
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
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", group_id='" + group_id + '\'' +
                ", sub_group='" + sub_group + '\'' +
                '}';
    }
}
