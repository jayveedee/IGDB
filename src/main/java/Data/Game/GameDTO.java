package Data.Game;

import Data.Game.Character.CharacterDTO;
import Data.Game.GameCompany.*;

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
    private Developer developer;
    private Publisher publisher;
    private SoundtrackDTO soundtrackDTO;
    private ComposerDTO composerDTO;
    private WriterDTO writerDTO;
    private List<CharacterDTO> characterDTOS;
    private List<ActorDTO> actorDTOS;
    private List<Genre> genres;
    private List<GameMode> gameModes;

    public GameDTO(int gameid, int ageRating, String name, String biography, DateDTO releaseDate, List<RatingDTO> ratingDTO, Developer developer, Publisher publisher, SoundtrackDTO soundtrackDTO, ComposerDTO composerDTO, WriterDTO writerDTO, List<CharacterDTO> characterDTOS, List<ActorDTO> actorDTOS, List<Genre> genres, List<GameMode> gameModes) {
        this.gameid = gameid;
        this.ageRating = ageRating;
        this.name = name;
        this.biography = biography;
        this.releaseDate = releaseDate;
        this.ratingDTO = ratingDTO;
        this.developer = developer;
        this.publisher = publisher;
        this.soundtrackDTO = soundtrackDTO;
        this.composerDTO = composerDTO;
        this.writerDTO = writerDTO;
        this.characterDTOS = characterDTOS;
        this.actorDTOS = actorDTOS;
        this.genres = genres;
        this.gameModes = gameModes;
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

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public void setGameModes(List<GameMode> gameModes) {
        this.gameModes = gameModes;
    }
}
