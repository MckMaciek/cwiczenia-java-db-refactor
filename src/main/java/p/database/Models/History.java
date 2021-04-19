package p.database.Models;

public class History {
    private Long id;
    private String name;
    private String iterations;


    public Long getterId() {
        return id;
    }

    public String getterName() {
        return name;
    }

    public String getterIterations() {
        return iterations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIterations(String iterations) {
        this.iterations = iterations;
    }

    private History(){

    }

    public static class HistoryBuilder{
        private String name;
        private String iterations;
        private Long id;

        public HistoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HistoryBuilder setIterations(String iterations) {
            this.iterations = iterations;
            return this;
        }

        public HistoryBuilder setId(Long id) {
            this.id = id;
            return this;
        }



        public History build(){
            History history = new History();
            history.iterations = this.iterations;
            history.name = this.name;
            history.id = this.id;

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
