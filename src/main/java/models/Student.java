package models;

import org.sql2o.Connection;

public class Student {
    public String name;
    public String cohort;

    public Student(String name, String cohort) {

    }

    public String getName() {
        return name;
    }


    public String getCohort() {
        return cohort;
    }



    public void save(Student student){
        try(Connection connect = Database.sql2o.open()) {
            String sql = "INSERT INTO student (name, cohort) VALUES (:name, :cohort)";
            connect.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("cohort",this.cohort)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
}
