package p.database.Models;

public class Registration {

    public Long id;
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Registration(){

    }

    public static class RegistrationBuilder{
        private String email;
        private String password;
        public Long id;

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
