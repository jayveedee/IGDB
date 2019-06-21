package Data.GameDAL;

import Data.GameDTO.GameDTO;

import java.util.ArrayList;
import java.util.List;

public interface IGameDAO {

    //CREATE
    boolean createGame              (GameDTO game);

    //READ
    GameDTO getGame                 (int gameID);
    int getGameID                   (String gameName);
    ArrayList<String> getGameNames  (String characters);
    List<GameDTO> getGameList();

    //UPDATE
    boolean updateGame              (int gameID, GameDTO updatedGame);

    //DELETE
    boolean deleteGame(int gameID);

}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)