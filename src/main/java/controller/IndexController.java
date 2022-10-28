package controller;

import model.StudentModel;
import persistence.service.StudentService;
import persistence.service.StudentServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index")
public class IndexController {

    @Path("/get/{name}")
    @GET
    public String sayHello(@PathParam("name")String ad){
        return "Pirivet " + ad;
    }

    private StudentService studentService=new StudentServiceImpl();

    @Path("/get")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentModel> getAllStudent(){
        return studentService.getAllStudents();
    }

    @Path(("/update"))
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateStudent(StudentModel model){ studentService.updateStudent(model);}

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addStudent(StudentModel model){ studentService.addStudent(model);}

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(@PathParam("id") Integer id){ studentService.deleteStudent(id);}





}
