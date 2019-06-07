package Data.GameDAL.Character;

import Data.GameDTO.Character.CharacterDTO;

import java.util.List;

public interface ICharacterDAO {

    boolean createCharacter(CharacterDTO character);
    CharacterDTO getCharacter(int characterID);
    List<CharacterDTO> getCharacterList();
    boolean updateCharacterInfo(CharacterDTO newCharacter);
    boolean deleteCharacter(int characterID);
}
