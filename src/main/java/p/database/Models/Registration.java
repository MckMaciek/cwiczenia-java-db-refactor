package p.database.Models;

import p.database.Annotations.Getter;
import p.database.Annotations.Setter;

public class Registration {

    public String id;
    private String email;
    private String password;
    private String professor_name;
    private String professor_last_name;

    @Getter(columnName = "professor_name")
    public String getProfessor_name() {
        return professor_name;
    }

    @Getter(columnName = "professor_last_name")
    public String getProfessor_last_name() {
        return professor_last_name;
    }

    @Setter(columnName = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    @Setter(columnName = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Getter(columnName = "email")
    public String getEmail() {
        return email;
    }

    @Getter(columnName = "password")
    public String getPassword() {
        return password;
    }

    @Setter(columnName = "professor_name")
    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    @Setter(columnName = "professor_last_name")
    public void setProfessor_last_name(String professor_last_name) {
        this.professor_last_name = professor_last_name;
    }

    @Setter(columnName = "id")
    public void setId(String id) {
        this.id = id;
    }

    @Getter(columnName = "id")
    public String getId() {
        return id;
    }

    public Registration(){

    }

    public static class RegistrationBuilder{
        private String email;
        private String password;
        private String professor_name;
        private String professor_last_name;
        public String id;

        public RegistrationBuilder setProfessor_name(String professor_name) {
            this.professor_name = professor_name;
            return this;
        }

        public RegistrationBuilder setProfessor_last_name(String professor_last_name) {
            this.professor_last_name = professor_last_name;
            return this;
        }

        public RegistrationBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public RegistrationBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RegistrationBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public Registration build(){
            Registration registration = new Registration();
            registration.email = this.email;
            registration.password = this.password;
            registration.id = this.id;
            registration.professor_last_name = this.professor_last_name;
            registration.professor_name = this.professor_name;

            return registration;
        }

    }
    public static RegistrationBuilder getInstanceOfRegistrationBuilder(){
        return new RegistrationBuilder();
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", professor_name='" + professor_name + '\'' +
                ", professor_last_name='" + professor_last_name + '\'' +
                '}';
    }
}
