package Data.Game;

import Data.Game.Character.CharacterDTO;
import Data.Game.Development.*;
import Data.Game.Development.Company.DeveloperDTO;
import Data.Game.Info.*;

import java.util.List;

public class GameDTO {

    private int gameid;
    private int ageRating;
    private String name;
    private String biography;
    private DateDTO releaseDate;
    private List<RatingDTO> ratingDTO;
    //private List<String> trivia;
    //private List<String> language;
    //private List<String> quotes;
    private DeveloperDTO developerDTO;
    private PublisherDTO publisherDTO;
    private SoundtrackDTO soundtrackDTO;
    private ComposerDTO composerDTO;
    private WriterDTO writerDTO;
    private List<CharacterDTO> characterDTOS;
    private List<ActorDTO> actorDTOS;
    private List<GenreDTO> genreDTOS;
    private List<GameModeDTO> gameModeDTOS;

    public GameDTO(int gameid, int ageRating, String name, String biography, DateDTO releaseDate, List<RatingDTO> ratingDTO, DeveloperDTO developerDTO, PublisherDTO publisherDTO, SoundtrackDTO soundtrackDTO, ComposerDTO composerDTO, WriterDTO writerDTO, List<CharacterDTO> characterDTOS, List<ActorDTO> actorDTOS, List<GenreDTO> genreDTOS, List<GameModeDTO> gameModeDTOS) {
        this.gameid = gameid;
        this.ageRating = ageRating;
        this.name = name;
        this.biography = biography;
        this.releaseDate = releaseDate;
        this.ratingDTO = ratingDTO;
        this.developerDTO = developerDTO;
        this.publisherDTO = publisherDTO;
        this.soundtrackDTO = soundtrackDTO;
        this.composerDTO = composerDTO;
        this.writerDTO = writerDTO;
        this.characterDTOS = characterDTOS;
        this.actorDTOS = actorDTOS;
        this.genreDTOS = genreDTOS;
        this.gameModeDTOS = gameModeDTOS;
    }

    public GameDTO() {
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public DateDTO getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(DateDTO releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<RatingDTO> getRatingDTO() {
        return ratingDTO;
    }

    public void setRatingDTO(List<RatingDTO> ratingDTO) {
        this.ratingDTO = ratingDTO;
    }

    public DeveloperDTO getDeveloperDTO() {
        return developerDTO;
    }

    public void setDeveloperDTO(DeveloperDTO developerDTO) {
        this.developerDTO = developerDTO;
    }

    public PublisherDTO getPublisherDTO() {
        return publisherDTO;
    }

    public void setPublisherDTO(PublisherDTO publisherDTO) {
        this.publisherDTO = publisherDTO;
    }

    public SoundtrackDTO getSoundtrackDTO() {
        return soundtrackDTO;
    }

    public void setSoundtrackDTO(SoundtrackDTO soundtrackDTO) {
        this.soundtrackDTO = soundtrackDTO;
    }

    public ComposerDTO getComposerDTO() {
        return composerDTO;
    }

    public void setComposerDTO(ComposerDTO composerDTO) {
        this.composerDTO = composerDTO;
    }

    public WriterDTO getWriterDTO() {
        return writerDTO;
    }

    public void setWriterDTO(WriterDTO writerDTO) {
        this.writerDTO = writerDTO;
    }

    public List<CharacterDTO> getCharacterDTOS() {
        return characterDTOS;
    }

    public void setCharacterDTOS(List<CharacterDTO> characterDTOS) {
        this.characterDTOS = characterDTOS;
    }

    public List<ActorDTO> getActorDTOS() {
        return actorDTOS;
    }

    public void setActorDTOS(List<ActorDTO> actorDTOS) {
        this.actorDTOS = actorDTOS;
    }

    public List<GenreDTO> getGenreDTOS() {
        return genreDTOS;
    }

    public void setGenreDTOS(List<GenreDTO> genreDTOS) {
        this.genreDTOS = genreDTOS;
    }

    public List<GameModeDTO> getGameModeDTOS() {
        return gameModeDTOS;
    }

    public void setGameModeDTOS(List<GameModeDTO> gameModeDTOS) {
        this.gameModeDTOS = gameModeDTOS;
    }
}
