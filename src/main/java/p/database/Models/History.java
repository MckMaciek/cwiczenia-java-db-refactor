package p.database.Models;

import p.database.Annotations.Getter;
import p.database.Annotations.Setter;

public class History {
    private String id;
    private String exam_name;
    private String iteration;
    private String professor_id;
    private String exam_date;
    private String student_id;
    private String hall_row_number;
    private String hall_column_number;

    @Setter
    public void setId(String id) {
        this.id = id;
    }


    @Getter
    public String getProfessor_id() {
        return professor_id;
    }

    @Setter
    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }

    @Setter
    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    @Getter
    public String getExam_date() {
        return exam_date;
    }

    @Setter
    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    @Getter
    public String getStudent_id() {
        return student_id;
    }

    @Setter
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    @Getter
    public String getHall_row_number() {
        return hall_row_number;
    }

    @Setter
    public void setHall_row_number(String hall_row_number) {
        this.hall_row_number = hall_row_number;
    }

    @Getter
    public String getHall_column_number() {
        return hall_column_number;
    }

    @Setter
    public void setHall_column_number(String hall_column_number) {
        this.hall_column_number = hall_column_number;
    }

    @Getter
    public String getId() {
        return id;
    }

    @Getter
    public String getExam_name() {
        return exam_name;
    }

    @Getter
    public String getIteration() {
        return iteration;
    }

    @Setter
    public void setIteration(String iterations) {
        this.iteration = iterations;
    }

    public History(){

    }

    public static class HistoryBuilder{
        private String name;
        private String iterations;
        private String id;
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

        public HistoryBuilder setId(String id) {
            this.id = id;
            return this;
        }



        public History build(){
            History history = new History();
            history.iteration = this.iterations;
            history.exam_name = this.name;
            history.id = this.id;
            history.student_id = this.student_id;
            history.hall_row_number = this.hall_row_number;
            history.hall_column_number = this.hall_column_number;
            history.professor_id = this.proffesorId;
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
                ", iterations='" + iteration + '\'' +
                ", proffesorId='" + professor_id + '\'' +
                ", exam_date='" + exam_date + '\'' +
                ", student_id='" + student_id + '\'' +
                ", hall_row_number='" + hall_row_number + '\'' +
                ", hall_column_number='" + hall_column_number + '\'' +
                '}';
    }
}
