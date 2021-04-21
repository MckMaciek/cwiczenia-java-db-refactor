package p.database.Models;

public class Hall {

    private String id;
    private String name;
    private String hall_columns;
    private String hall_rows;
    private String has_section;
    private String additional_seats ;

    public String getterId() {
        return id;
    }

    public String getterName() {
        return name;
    }

    public String getterHall_columns() {
        return hall_columns;
    }

    public String getterHall_rows() {
        return hall_rows;
    }

    public String getterHas_section() {
        return has_section;
    }

    public String getteradditional_seats () {
        return additional_seats ;
    }

    public void setterName(String name) {
        this.name = name;
    }

    public void setterId(String id) {
        this.id = id;
    }

    public void setterHall_Columns(String hallColumns) {
        this.hall_columns = hallColumns;
    }

    public void setterHall_Rows(String hallRows) {
        this.hall_rows = hallRows;
    }

    public void setterHas_Section(String hasSection) {
        this.has_section = hasSection;
    }

    public void setterAdditional_seats (String addSeats) {
        this.additional_seats  = addSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallColumns() {
        return hall_columns;
    }

    public void setHallColumns(String hallColumns) {
        this.hall_columns = hallColumns;
    }

    public String getHallRows() {
        return hall_rows;
    }

    public void setHallRows(String hallRows) {
        this.hall_rows = hallRows;
    }

    public String getHasSection() {
        return has_section;
    }

    public void setHasSection(String hasSection) {
        this.has_section = hasSection;
    }

    public String getAdditional_seats() {
        return additional_seats;
    }

    public void setAdditional_seats(String additional_seats) {
        this.additional_seats = additional_seats;
    }

    public Hall(){

    }

    public static class HallBuilder{
        private String name;
        private String hallColumns;
        private String hallRows;
        private String hasSection;
        private String additional_seats ;
        private String id;

        public HallBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HallBuilder setId(String id) {
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

            hall.hall_columns = this.hallColumns;
            hall.hall_rows = this.hallRows;
            hall.has_section = this.hasSection;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", hallColumns='" + hall_columns + '\'' +
                ", hallRows='" + hall_rows + '\'' +
                ", hasSection='" + has_section + '\'' +
                ", additional_seats='" + additional_seats + '\'' +
                '}';
    }
}
