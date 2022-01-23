package models;

import org.sql2o.Sql2o;

public class Database {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-3-224-157-224.compute-1.amazonaws.com:5432/d77lt7qbj6353v", "zrhnsmzqioxbnw", "552af7d0ff0587d54480f161c47dc5208ae1a254e6ba70e051330070d24e558f");


    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringaschool", "h");

}
