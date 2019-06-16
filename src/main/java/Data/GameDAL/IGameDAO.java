package Data.GameDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.PictureDTO;
import Data.GameDTO.Info.SoundtrackDTO;
import Data.GameDTO.Info.TrailerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IGameDAO {

    //CREATE
    boolean createGame              (GameDTO game);

    //READ
    GameDTO getGame                 (int gameID);
    int getGameID                   (String gameName);
    ArrayList<String> getGameNames  (String characters);

    //UPDATE
    boolean updateGame              (int gameID, GameDTO updatedGame);
    boolean updateGameGenre         (int gameID, int oldGenreID, int updatedGenreID);
    boolean updateGameGM            (int gameID, int oldGMID, int updatedGMID);
    boolean updateGamePlatform      (int gameID, int oldPlatformID, int updatedPlatformID);
    boolean updateGamePicture       (int gameID, int oldPicID, PictureDTO updatedPicture);
    boolean updatedGameTrailer      (int gameID, int oldTrailerID, TrailerDTO updatedTrailer);

    boolean updateGamePublisher     (int gameID, int oldPublisherID, PublisherDTO updatedPublisher);
    boolean updateGameDeveloper     (int gameID, int oldDeveloperID, int oldPCompanyID, DeveloperDTO updatedDeveloper);
    boolean updateGameWriter        (int gameID, int oldWriterID, WriterDTO updatedWriter);

    boolean updateGameCharacter     (int gameID, int oldCharID, CharacterDTO updatedCharacter);
    boolean updateGameActor         (int gameID, int oldActorID, ActorDTO updatedActor);
    boolean updateGameOST           (int gameID, int oldOstID, int oldComposerID, int oldArtistID, SoundtrackDTO updatedOST);
    boolean updateGameComposer      (int gameID, int oldCompID, ComposerDTO updatedComposer);

    //DELETE
    boolean deleteGame(int gameID);

}
