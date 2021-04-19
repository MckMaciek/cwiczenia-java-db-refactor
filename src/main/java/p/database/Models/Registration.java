package p.database.Models;

public class Registration {

    public Long id;
    private String email;
    private String password;
    private String professor_name;
    private String professor_last_name;

    public String getterProfessor_name() {
        return professor_name;
    }


    public String getterProfessor_last_name() {
        return professor_last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getterEmail() {
        return email;
    }

    public String getterPassword() {
        return password;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }
    public void setProfessor_last_name(String professor_last_name) {
        this.professor_last_name = professor_last_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Registration(){

    }

    public static class RegistrationBuilder{
        private String email;
        private String password;
        private String professor_name;
        private String professor_last_name;
        public Long id;

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

        public RegistrationBuilder setId(Long id) {
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
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
