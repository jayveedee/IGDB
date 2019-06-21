import javax.ws.rs.*;


@Path("service")
public class HelloService {

    @POST
    @Path("form")
    public String getFormParameters (@FormParam("name") String name, @FormParam("id") Integer id, @FormParam("amount") int amount ){
        return ("The chosen input is the following: name= "+ name + " id= " + id + " amount= " + amount);
    }

    @GET
    public String getHello(){
        return "Hello";
    }

    @POST
    public String customHello(String string){
        return "Hello" + string + "!";
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

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)