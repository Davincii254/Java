import models.Student;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) { //type “psvm + tab” to autocreate this :)
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/links", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "link.hbs");
        }, new HandlebarsTemplateEngine());

        post("/student/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String cohort = request.queryParams("cohort");
            Student newStudent = new Student(name,age,cohort);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/students-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "student-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/students-detail",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Student> students = Student.getAll();
            System.out.println(students);
            model.put("student", students);
            return new ModelAndView(model, "student-detail.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
