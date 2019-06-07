package Data.GameDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.*;

import java.util.List;

public interface IGameDAO {

    boolean createGame(GameDTO gmae);
    GameDTO getGame(int gameID);
    List<GameDTO> getGameList();
    boolean updateGame(GameDTO newGame);
    boolean deleteGame(int gameID);


    //Create lists
    boolean addCharacterToGameList      (GameDTO existingGame, CharacterDTO     existingCharacter);
    boolean addActorToGameList          (GameDTO existingGame, ActorDTO         existingActor);
    boolean addWriterToGameList         (GameDTO existingGame, WriterDTO        existingWriter);
    boolean addSoundtrackToGameList     (GameDTO existingGame, SoundtrackDTO    existingSoundtrack);
    boolean addComposerToGameList       (GameDTO existingGame, ComposerDTO      existingComposer);
    boolean addMusicalArtistToGameList  (GameDTO existingGame, MusicArtistDTO   existingMusicArtist);

    boolean addGenreToGameList          (GameDTO existingGame, GenreDTO         existingGenre);
    boolean addGameModeToGameList       (GameDTO existingGame, GameModeDTO      existingGameMode);
    boolean addPlatformToGameList       (GameDTO existingGame, PlatformDTO      existingPlatform);

    boolean addDeveloperToGameList      (GameDTO existingGame, DeveloperDTO     existingDeveloper);
    boolean addPublisherToGameList      (GameDTO existingGame, PublisherDTO     existingPublisher);

    boolean addMediaToGameList          (GameDTO existingGame, MediaDTO         existingMedia);

}
