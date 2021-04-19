package p.database.Models;

public class Hall {

    private Long id;
    private String name;
    private String hallColumns;
    private String hallRows;
    private String hasSection;
    private String additional_seats ;

    public Long getterId() {
        return id;
    }

    public String getterName() {
        return name;
    }

    public String getterHallColumns() {
        return hallColumns;
    }

    public String getterHallRows() {
        return hallRows;
    }

    public String getterHasSection() {
        return hasSection;
    }

    public String getteradditional_seats () {
        return additional_seats ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHallColumns(String hallColumns) {
        this.hallColumns = hallColumns;
    }

    public void setHallRows(String hallRows) {
        this.hallRows = hallRows;
    }

    public void setHasSection(String hasSection) {
        this.hasSection = hasSection;
    }

    public void setAdditional_seats (String addSeats) {
        this.additional_seats  = addSeats;
    }

    public Hall(){

    }

    public static class HallBuilder{
        private String name;
        private String hallColumns;
        private String hallRows;
        private String hasSection;
        private String additional_seats ;
        private Long id;

        public HallBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HallBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public HallBuilder setHallColumns(String hallColumns) {
            this.hallColumns = hallColumns;
            return this;
        }

        public HallBuilder setHallRows(String hallRows) {
            this.hallRows = hallRows;
            return this;
        }

        public HallBuilder setHasSection(String hasSection) {
            this.hasSection = hasSection;
            return this;
        }

        public HallBuilder setAddSeats(String addSeats) {
            this.additional_seats  = addSeats;
            return this;
        }

        public Hall build(){
            Hall hall = new Hall();

            hall.hallColumns = this.hallColumns;
            hall.hallRows = this.hallRows;
            hall.hasSection = this.hasSection;
            hall.additional_seats  = this.additional_seats;
            hall.name = this.name;
            hall.id = this.id;

            return hall;
        }

    }
    public static HallBuilder getInstanceOfHallBuilder(){
        return new HallBuilder();
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", hallColumns='" + hallColumns + '\'' +
                ", hallRows='" + hallRows + '\'' +
                ", hasSection='" + hasSection + '\'' +
                ", addSeats='" + additional_seats  + '\'' +
                '}';
    }
}
