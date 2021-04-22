package p.database.Models;

import p.database.Annotations.Getter;
import p.database.Annotations.Setter;

public class Group {
    private String name;
    private String id;


    public Group(){
    }

    @Getter(columnName = "name")
    public String getName() {
        return name;
    }

    @Setter(columnName = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Getter(columnName = "id")
    public String getId() {
        return id;
    }

    @Setter(columnName = "id")
    public void setId(String id) {
        this.id = id;
    }

    public static class GroupBuilder{
        private String name;
        private String id;

        public GroupBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GroupBuilder setId(String id) {
            this.id = id;
            return this;
        }


        public Group build(){
            Group group = new Group();
            group.name = this.name;
            group.id = this.id;

            return group;
        }
    }

    public static GroupBuilder getInstanceOfGroupBuilder(){
        return new GroupBuilder();
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
