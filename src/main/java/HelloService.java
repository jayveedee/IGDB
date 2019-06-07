import javax.ws.rs.*;


@Path("hello")
public class HelloService {

    @GET
    public String getHello(){
        return "Hello";
    }

    @POST
    public String customHello(String string){
        return "Hello" + string + "!";
    }

    @POST
    @Path("form")
    public String tagImodFormParametre(@FormParam("name") String name, @FormParam("id") Integer id, @FormParam("amount") int amount ){
        return ("de indtastede data er følgende: <br>\nname: "+ name + "\nid: " + id + "\namount: " + amount);
        //return "hey";
    }

    @POST
    @Path("query")
    public String tagImodQueryParameters(@QueryParam("name") String name, @QueryParam("id") int id, @QueryParam("amount") int amount){
        return ("de indtastede data er følgende: <br>\nname: "+ name + "\nid: " + id + "\namount: " + amount);
    }

    @POST
    @Path("{name}/{id}/{amount}")
    public String tagImodPathParameters(@PathParam("name") String name, @PathParam("id") int id, @PathParam("amount") int amount){
        return ("de indtastede data er følgende: <br>\nname: "+ name + "\nid: " + id + "\namount: " + amount);
    }
}
