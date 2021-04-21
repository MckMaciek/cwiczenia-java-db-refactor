package p.database.Models;

import org.springframework.data.annotation.Id;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class Group {
    private String name;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

    public Long getterId() {
        return id;
    }
    public String getterName() {
        return name;
    }

    public Group(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class GroupBuilder{
        private String name;
        private Long id;

        public GroupBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GroupBuilder setId(Long id) {
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
