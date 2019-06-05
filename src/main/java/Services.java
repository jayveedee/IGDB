import javax.ws.rs.Path;

public class Services{

    @Path("services")
    public Services() {
    }

    @Path("user/createUser"){
        UserService service = new UserService()
    }


}
