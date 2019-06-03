package Data.UserDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.Info.RatingDTO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserDAO_TEST {

    @org.junit.Test
    public void createUser() {

            int rid = 1, rrid = 2; String rn = "admin", rrn = "mod";
        RoleDTO r                   = new RoleDTO(rid,rn);
        RoleDTO rr                  = new RoleDTO(rrid,rrn);
            int raid = 1, raaid = 2, rat = 10, raat = 5;
        RatingDTO ra                = new RatingDTO(raid,rat);
        RatingDTO raa               = new RatingDTO(raaid,raat);
        List<RatingDTO> rlist       = new ArrayList<>();
            rlist.add(ra);
            rlist.add(raa);
            int day = 12, month = 12, year = 2012;
        DateDTO d                   = new DateDTO(day,month,year);
        DeveloperDTO dev            = new DeveloperDTO();
        PublisherDTO pub            = new PublisherDTO();
        GameDTO g                   = new GameDTO();
        GameDTO g1                  = new GameDTO();
        List<GameDTO> glist         = new ArrayList<>();
            glist.add(g);
            glist.add(g1);
        UserDTO u                   = new UserDTO();
        UserDTO u1                  = new UserDTO();
        CharacterDTO c              = new CharacterDTO();
        CharacterDTO c1             = new CharacterDTO();
        List<CharacterDTO> clist    = new ArrayList<>();
            clist.add(c);
            clist.add(c1);
            int aid = 1; String afn = "jvd", lfn = "dvj";
        ActorDTO a                  = new ActorDTO(aid,afn,lfn,d,clist,glist);


    }

    @org.junit.Test
    public void getUser() {
    }

    @org.junit.Test
    public void getUserList() {
    }

    @org.junit.Test
    public void updateUser() {
    }

    @org.junit.Test
    public void deleteUser() {
    }
}
