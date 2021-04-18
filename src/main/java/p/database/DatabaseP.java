package p.database;

import p.database.Commands.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseP {

//    private static java.sql.Connection con;
//    private static PreparedStatement pst = null;
//    private static ResultSet rs = null;
//
//
//    public static void insert(){
//        con = DatabaseConnection.connection();
//        try {
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs  = st.executeQuery("SHOW tables;");
//            int i = 1;
//            while(rs.next())
//            {
//                System.out.print("-" + rs.getString(1) + ", ");
//                ++i;
//            }
//            Scanner scan = new Scanner(System.in);
//            String tableChoice = scan.nextLine();
//
//            st = (Statement) con.createStatement();
//            switch(tableChoice){
//
//                case "groups_tb" :{
//                    System.out.println("For groups_tb ...");
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//
//                    st.executeUpdate(String.format("INSERT INTO groups_tb(id, name)" +
//                            "VALUES('%s');",name));
//                    break;
//                } // END OF CASE
//
//                case "hall_tb" :{
//                    System.out.println("For hall_tb ...");
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//                    System.out.print("hall_columns -> ");
//                    String hallColumns = scan.nextLine();
//                    System.out.print("hall_rows -> ");
//                    String hallRows = scan.nextLine();
//                    System.out.print("has_section -> ");
//                    String hasSection = scan.nextLine();
//                    System.out.print("additional_seats ->");
//                    String addSeats = scan.nextLine();
//
//                    st.executeUpdate(String.format("INSERT INTO hall_tb(name, hall_columns,hall_rows,has_section,additional_seats)" +
//                            "VALUES('%s','%s','%s','%s','%s');",name,hallColumns,hallRows,hasSection,addSeats));
//
//                    break;
//                }  //END OF CASE
//
//
//
//                case "history_tb":{
//                    System.out.println("For history_tb ...");
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//                    System.out.print("hall_columns -> ");
//                    String iterations = scan.nextLine();
//                    st.executeUpdate(String.format("INSERT INTO history_tb(name, iterations)" +
//                            "VALUES('%s','%s');",name,iterations));
//
//                    break;
//                } // END OF CASE
//
//
//                case "registration_tb":{
//                    System.out.println("For registration_tb ...");
//                    System.out.print("email -> ");
//                    String email = scan.nextLine();
//                    System.out.print("password -> ");
//                    String password = scan.nextLine();
//                    st.executeUpdate(String.format("INSERT INTO registration_tb(email, password)" +
//                            "VALUES('%s','%s');",email,password));
//
//                    break;
//                } // END OF CASE
//                case "students_tb":{
//                    System.out.println("For students_tb ...");
//                    System.out.print("first_name -> ");
//                    String fname = scan.nextLine();
//                    System.out.print("last_name -> ");
//                    String lname = scan.nextLine();
//                    System.out.print("index_number -> ");
//                    String indexNumber = scan.nextLine();
//                    System.out.print("sub_group -> ");
//                    String sub_group = scan.nextLine();
//                    System.out.print("group -> ");
//                    String group = scan.nextLine();
//                    st.executeUpdate(String.format("INSERT INTO students_tb(first_name, last_name, index_number,sub_group,group_id)" +
//                            "VALUES('%s','%s','%s','%s','%s');",fname,lname,indexNumber,sub_group,group));
//
//                    break;
//                } // END OF CASE
//
//            }
//
//            con.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void select(){
//
//        con = DatabaseConnection.connection();
//        try {
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs  = st.executeQuery("SHOW tables;");
//            int i = 1;
//            while(rs.next())
//            {
//                System.out.print("-" + rs.getString(1) + ", ");
//                ++i;
//            }
//
//
//            Scanner scan = new Scanner(System.in);
//            System.out.println("");
//            System.out.print("Table-> ");
//            String[] tableToShow = scan.nextLine().split(" ");
//
//            switch(tableToShow[0]){
//
//                case  "groups_tb" :{
//
//                    if (tableToShow.length == 2){
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + " WHERE id = " + tableToShow[1] + ";");
//                    }
//                    else {
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + ";");
//                    }
//                    while(rs.next())
//                    {
//                        System.out.print(" " + rs.getString(1) + " " + rs.getString(2));
//                        System.out.println("");
//                    }
//
//                break;
//                } // END OF CASE
//
//                case "hall_tb" :{
//                    if (tableToShow.length == 2){
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + " WHERE id = " + tableToShow[1] + ";");
//                    }
//                    else {
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + ";");
//                    }
//
//                while(rs.next())
//                {
//                    System.out.print(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
//                            + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
//                    System.out.println("");
//                }
//                break;
//                } //END OF CASE
//
//                case "history_tb" :{
//                    if (tableToShow.length == 2){
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + " WHERE id = " + tableToShow[1] + ";");
//                    }
//                    else {
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + ";");
//                    }
//                    while(rs.next())
//                    {
//                        System.out.print(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//                        System.out.println("");
//                    }
//                    break;
//                } //END OF CASE
//
//                case "registration_tb" :{
//                    if (tableToShow.length == 2){
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + " WHERE id = " + tableToShow[1] + ";");
//                    }
//                    else {
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + ";");
//                    }
//                    while(rs.next())
//                    {
//                        System.out.print(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//                        System.out.println("");
//                    }
//                    break;
//                } //END OF CASE
//
//                case "students_tb" :{
//
//                    if (tableToShow.length == 2){
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + " WHERE id = " + tableToShow[1] + ";");
//                    }
//                    else {
//                        rs = st.executeQuery("SELECT * FROM " + tableToShow[0] + ";");
//                    }
//                    while(rs.next())
//                    {
//                        System.out.print(" " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
//                                + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
//                        System.out.println("");
//                    }
//                    break;
//                } //END OF CASE
//
//
//            }
//
//
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static void update(){
//
//        con = DatabaseConnection.connection();
//        try {
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs = st.executeQuery("SHOW tables;");
//            int i = 1;
//            while (rs.next()) {
//                System.out.print("-" + rs.getString(1) + ", ");
//                ++i;
//            }
//            Scanner scan = new Scanner(System.in);
//            String tableChoice = scan.nextLine();
//            System.out.println("User ID -> ");
//            String userID = scan.nextLine();
//
//
//            switch(tableChoice) {
//
//                case "groups_tb" : {
//
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//
//                    st.executeUpdate(String.format("UPDATE groups_tb SET name = '%s' WHERE id = '%s'",name,userID));
//                    break;
//                } // END OF CASE
//                case "hall_tb" : {
//
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//                    System.out.print("hall_columns -> ");
//                    String hallColumns = scan.nextLine();
//                    System.out.print("hall_rows -> ");
//                    String hallRows = scan.nextLine();
//                    System.out.print("has_section -> ");
//                    String hasSection = scan.nextLine();
//                    System.out.print("additional_seats -> ");
//                    String additional_seats = scan.nextLine();
//
//                    st.executeUpdate(String.format("UPDATE hall_tb SET name = '%s', hall_columns = '%s', hall_rows = '%s', " +
//                                    "has_section = '%s', additional_seats = '%s' " +
//                                    "WHERE id = '%s' ",name,hallColumns,hallRows,hasSection,additional_seats,userID));
//                    break;
//                } // END OF CASE
//
//                case "history_tb" :{
//                    System.out.print("name -> ");
//                    String name = scan.nextLine();
//                    System.out.print("iterations -> ");
//                    String iterations = scan.nextLine();
//
//                    st.executeUpdate(String.format("UPDATE history_tb SET name = '%s', iterations = '%s' WHERE id = '%s'",name,iterations,userID));
//
//                    break;
//                } // END OF CASE
//
//                case "registration_tb" :{
//                    System.out.print("email -> ");
//                    String email = scan.nextLine();
//                    System.out.print("password -> ");
//                    String password = scan.nextLine();
//
//                    st.executeUpdate(String.format("UPDATE registration_tb SET email = '%s', password = '%s' WHERE id = '%s'",
//                            email,password,userID));
//                    break;
//                } // END OF CASE
//
//                case "students_tb" :{
//                    System.out.print("first_name -> ");
//                    String fname = scan.nextLine();
//                    System.out.print("last_name -> ");
//                    String lname = scan.nextLine();
//                    System.out.print("index_number -> ");
//                    String indexNumber = scan.nextLine();
//                    System.out.print("sub_group -> ");
//                    String sub_group = scan.nextLine();
//                    System.out.print("group -> ");
//                    String group = scan.nextLine();
//                    st.executeUpdate(String.format("UPDATE students_tb SET first_name = '%s', " +
//                            "last_name = '%s', index_number = '%s', sub_group='%s' ,group_id = '%s'" +
//                            "WHERE id = '%s' ;",fname,lname,indexNumber,sub_group,group,userID));
//
//
//                }
//
//            } // END OF CASE
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//    public static void delete() {
//        con = DatabaseConnection.connection();
//        try {
//            Statement st = (Statement) con.createStatement();
//            ResultSet rs = st.executeQuery("SHOW tables;");
//            int i = 1;
//            while (rs.next()) {
//                System.out.print("-" + rs.getString(1) + ", ");
//                ++i;
//            }
//            Scanner scan = new Scanner(System.in);
//            String tableChoice = scan.nextLine();
//            System.out.println("User ID -> ");
//            String userID = scan.nextLine();
//
//            switch(tableChoice){
//
//                case "groups_tb" : {
//                    st.executeUpdate(String.format("DELETE from groups_tb WHERE id = '%s'",userID));
//                    break;
//                } // END OF CASE
//                case "hall_tb" : {
//                    st.executeUpdate(String.format("DELETE from hall_tb WHERE id = '%s'",userID));
//                    break;
//                } // END OF CASE
//                case "history_tb" : {
//                    st.executeUpdate(String.format("DELETE from history_tb WHERE id = '%s'",userID));
//                    break;
//                } // END OF CASE
//                case "registration_tb" :{
//                    st.executeUpdate(String.format("DELETE from registration_tb WHERE id = '%s'",userID));
//                    break;
//                }
//                case "students_tb" :{
//                    st.executeUpdate(String.format("DELETE from students_tb WHERE id = '%s'",userID));
//                    break;
//                }
//
//
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void launch(String args[]){

        SelectCommand selectCommand = new SelectCommand();
        InsertCommand insertCommand = new InsertCommand();
        UpdateCommand updateCommand = new UpdateCommand();
        DeleteCommand deleteCommand = new DeleteCommand();
        ExitCommand   exitCommand   = new ExitCommand();

        List<Command> commands = new ArrayList<>(){{
            add(selectCommand);
            add(insertCommand);
            add(updateCommand);
            add(deleteCommand);
            add(exitCommand);
        }};

        RunCommands runCommands = new RunCommands(commands);
        runCommands.showMenu();

    }
}
