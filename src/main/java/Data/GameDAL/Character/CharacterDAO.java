package Data.GameDAL.Character;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class CharacterDAO implements ICharacterDAO {
    @Override
    public boolean createCharacter(CharacterDTO character) {
        String query1 = "INSERT INTO Characters (charID, charNAME, charBio) VALUES (charID = ?, charNAME = ?, charBio = ?)";

        int charID = character.getChID();
        String charName = character.getChNAME();
        String charBio = character.getChBIO();


        return true;
    }

    @Override
    public CharacterDTO getCharacter(int characterID) {
        return null;
    }

    @Override
    public List<CharacterDTO> getCharacterList() {
        return null;
    }

    @Override
    public List<Integer> getGameCharacterList() {
        return null;
    }

    @Override
    public List<Integer> getActorCharacterList() {
        return null;
    }

    @Override
    public boolean updateCharacterInfo(CharacterDTO newCharacter) {
        return false;
    }

    @Override
    public boolean updateSpecificGameCharacterList(int charID, GameDTO newGame) {
        return false;
    }

    @Override
    public boolean updateSpecificActorCharacterList(int charID, ActorDTO newActor) {
        return false;
    }

    @Override
    public boolean deleteCharacter(int characterID) {
        return false;
    }
}
