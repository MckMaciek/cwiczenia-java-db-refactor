package p.database.Models;

public class History {
    private Long id;
    private String exam_name;
    private String iterations;
    private String proffesorId;
    private String exam_date;
    private String student_id;
    private String hall_row_number;
    private String hall_column_number;



    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }


    public String getterProffesorId() {
        return proffesorId;
    }

    public void setProffesorId(String proffesorId) {
        this.proffesorId = proffesorId;
    }

    public String getterExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getterStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getterHall_row_number() {
        return hall_row_number;
    }

    public void setHall_row_number(String hall_row_number) {
        this.hall_row_number = hall_row_number;
    }

    public String getterHall_column_number() {
        return hall_column_number;
    }

    public void setHall_column_number(String hall_column_number) {
        this.hall_column_number = hall_column_number;
    }

    public Long getterId() {
        return id;
    }

    public String getterExam_name() {
        return exam_name;
    }

    public String getterIteration() {
        return iterations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.exam_name = name;
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
        private String proffesorId;
        private String exam_date;
        private String student_id;
        private String hall_row_number;
        private String hall_column_number;

        public HistoryBuilder setProffesorId(String proffesorId) {
            this.proffesorId = proffesorId;
            return this;
        }

        public HistoryBuilder setExam_date(String exam_date) {
            this.exam_date = exam_date;
            return this;
        }

        public HistoryBuilder setStudent_id(String student_id) {
            this.student_id = student_id;
            return this;
        }

        public HistoryBuilder setHall_row_number(String hall_row_number) {
            this.hall_row_number = hall_row_number;
            return this;
        }

        public HistoryBuilder setHall_column_number(String hall_column_number) {
            this.hall_column_number = hall_column_number;
            return this;
        }

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
            history.exam_name = this.name;
            history.id = this.id;
            history.student_id = this.student_id;
            history.hall_row_number = this.hall_row_number;
            history.hall_column_number = this.hall_column_number;
            history.proffesorId = this.proffesorId;
            history.exam_date = this.exam_date;

            return history;
        }

    }

    public static HistoryBuilder getInstanceOfHistoryBuilder(){
        return new HistoryBuilder();
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", exam_name='" + exam_name + '\'' +
                ", iterations='" + iterations + '\'' +
                ", proffesorId='" + proffesorId + '\'' +
                ", exam_date='" + exam_date + '\'' +
                ", student_id='" + student_id + '\'' +
                ", hall_row_number='" + hall_row_number + '\'' +
                ", hall_column_number='" + hall_column_number + '\'' +
                '}';
    }
}
