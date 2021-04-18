package p.database.Models;

public class History {
    private String name;
    private String iterations;
    private Long id;


    public void setName(String name) {
        this.name = name;
    }

    public void setIterations(String iterations) {
        this.iterations = iterations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getIterations() {
        return iterations;
    }

    private History(){

    }

    public static class HistoryBuilder{
        private String name;
        private String iterations;

        public HistoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HistoryBuilder setIterations(String iterations) {
            this.iterations = iterations;
            return this;
        }

        public History build(){
            History history = new History();
            history.iterations = this.iterations;
            history.name = this.name;

            return history;
        }

    }

    public static HistoryBuilder getInstanceOfHistoryBuilder(){
        return new HistoryBuilder();
    }

    @Override
    public String toString() {
        return "History{" +
                "name='" + name + '\'' +
                ", iterations='" + iterations + '\'' +
                '}';
    }
}
