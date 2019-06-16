package Data.GameDAL;

import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.GameDTO;
import Data.GenAccessTestMethods;
import Data.GenAccessMethods_GameDAO_TEST;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameDAO_TEST {

    private GenAccessMethods_GameDAO_TEST   a               = new GenAccessMethods_GameDAO_TEST();
    private GenAccessTestMethods del             = new GenAccessTestMethods();
    private IMysqlConnection                mysql           = new MysqlConnection();
    private IGameDAO                        gdao            = new GameDAO(mysql);

    @Test // GOOD TO GO
    public void createGame() {
        try (Connection c = mysql.createConnection()){
            mysql.createConnection();
            del.deleteAllTables();
            GameDTO testGame1 = a.createGameDB(70,"COD1");
            GameDTO testGame2 = a.createGameDB(71,"COD2");
            GameDTO testGame3 = a.createGameDB(72,"COD3");
            GameDTO testGame4 = a.createGameDB(99,"COD4");
            assertTrue(gdao.createGame(testGame1));
            assertTrue(gdao.createGame(testGame2));
            assertTrue(gdao.createGame(testGame3));
            assertTrue(gdao.createGame(testGame4));
            mysql.closeConnection(mysql.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void getGame() {
        try (Connection c = mysql.createConnection()){
            mysql.createConnection();
            del.deleteAllTables();
            GameDTO testGame1       = a.createGameDB(70,"COD1");
            assertTrue(gdao.createGame(testGame1));
            GameDTO testGame1DB     = gdao.getGame(70);

            assertEquals(testGame1.getGameID(),testGame1DB.getGameID());
            assertEquals(testGame1.getGameBG(),testGame1DB.getGameBG());
            assertEquals(testGame1.getGameBIO(),testGame1DB.getGameBIO());
            assertEquals(testGame1.getGameCover(),testGame1DB.getGameCover());
            assertEquals(testGame1.getGameNAME(),testGame1DB.getGameNAME());
            assertEquals(testGame1.getGameRELEASEDATE().getDay(),testGame1DB.getGameRELEASEDATE().getDay());
            assertEquals(testGame1.getGameRELEASEDATE().getMonth(),testGame1DB.getGameRELEASEDATE().getMonth());
            assertEquals(testGame1.getGameRELEASEDATE().getYear(),testGame1DB.getGameRELEASEDATE().getYear());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentID(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentID());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCOUNTRY(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCOUNTRY());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentNAME(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentNAME());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth());
            assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear());
            assertEquals(testGame1.getGameOST().getOstCOMP().getCompID(),testGame1DB.getGameOST().getOstCOMP().getCompID());
            assertEquals(testGame1.getGameOST().getOstCOMP().getCompFN(),testGame1DB.getGameOST().getOstCOMP().getCompFN());
            assertEquals(testGame1.getGameOST().getOstCOMP().getCompLN(),testGame1DB.getGameOST().getOstCOMP().getCompLN());
            assertEquals(testGame1.getGameOST().getOstCOMP().getCompGAME(),testGame1DB.getGameOST().getOstCOMP().getCompGAME());
            List<Integer> compOstList1      = testGame1.getGameOST().getOstCOMP().getCompOSTs();
            List<Integer> compOstList1DB    = testGame1DB.getGameOST().getOstCOMP().getCompOSTs();
            for (int i = 0; i < testGame1.getGameOST().getOstCOMP().getCompOSTs().size(); i++) {
                assertEquals(compOstList1.get(i),compOstList1DB.get(i));
            }
            assertEquals(testGame1.getGameOST().getOstID(),testGame1DB.getGameOST().getOstID());
            assertEquals(testGame1.getGameOST().getOstURL(),testGame1DB.getGameOST().getOstURL());
            assertEquals(testGame1.getGameOST().getOstGAME(),testGame1DB.getGameOST().getOstGAME());
            assertEquals(testGame1.getGameOST().getOstTITLE(),testGame1DB.getGameOST().getOstTITLE());
            List<MusicArtistDTO> ostMaList1     = testGame1.getGameOST().getOstMA();
            List<MusicArtistDTO> ostMaList1DB   = testGame1DB.getGameOST().getOstMA();
            for (int i = 0; i < testGame1.getGameOST().getOstMA().size(); i++) {
                assertEquals(ostMaList1.get(i).getArtID(),ostMaList1DB.get(i).getArtID());
                assertEquals(ostMaList1.get(i).getArtNAME(),ostMaList1DB.get(i).getArtNAME());
                assertEquals(ostMaList1.get(i).getArtPFP(),ostMaList1DB.get(i).getArtPFP());
            }
            assertEquals(testGame1.getGamePUB().getPubCREATED().getDay(),testGame1DB.getGamePUB().getPubCREATED().getDay());
            assertEquals(testGame1.getGamePUB().getPubCREATED().getMonth(),testGame1DB.getGamePUB().getPubCREATED().getMonth());
            assertEquals(testGame1.getGamePUB().getPubCREATED().getYear(),testGame1DB.getGamePUB().getPubCREATED().getYear());
            assertEquals(testGame1.getGamePUB().getPubCOUNTRY(),testGame1DB.getGamePUB().getPubCOUNTRY());
            assertEquals(testGame1.getGamePUB().getPubID(),testGame1DB.getGamePUB().getPubID());
            assertEquals(testGame1.getGamePUB().getPubNAME(),testGame1DB.getGamePUB().getPubNAME());
            assertEquals(testGame1.getGamePUB().getPubGAME(),testGame1DB.getGamePUB().getPubGAME());
            assertEquals(testGame1.getGameWRI().size(),testGame1DB.getGameWRI().size());
            for (int i = 0; i < testGame1.getGameWRI().size(); i++) {
                assertEquals(testGame1.getGameWRI().get(i).getWriterID(),testGame1DB.getGameWRI().get(i).getWriterID());
                assertEquals(testGame1.getGameWRI().get(i).getWriterGAME(),testGame1DB.getGameWRI().get(i).getWriterGAME());
                assertEquals(testGame1.getGameWRI().get(i).getWriterFN(),testGame1DB.getGameWRI().get(i).getWriterFN());
                assertEquals(testGame1.getGameWRI().get(i).getWriterLN(),testGame1DB.getGameWRI().get(i).getWriterLN());
            }
            List<ActorDTO> actTest1     = testGame1.getGameACs();
            List<ActorDTO> actTest1DB   = testGame1DB.getGameACs();
            for (int i = 0; i < testGame1.getGameACs().size(); i++) {
                assertEquals(actTest1.get(i).getAcBDAY().getDay(),actTest1DB.get(i).getAcBDAY().getDay());
                assertEquals(actTest1.get(i).getAcBDAY().getMonth(),actTest1DB.get(i).getAcBDAY().getMonth());
                assertEquals(actTest1.get(i).getAcBDAY().getYear(),actTest1DB.get(i).getAcBDAY().getYear());
                assertEquals(actTest1.get(i).getAcFN(),actTest1DB.get(i).getAcFN());
                assertEquals(actTest1.get(i).getAcLN(),actTest1DB.get(i).getAcLN());
                assertEquals(actTest1.get(i).getAcID(),actTest1DB.get(i).getAcID());
                assertEquals(actTest1.get(i).getAcGAME(),actTest1DB.get(i).getAcGAME());
                assertEquals(actTest1.get(i).getAcPFP(),actTest1DB.get(i).getAcPFP());
                List<Integer> actTest1Ch        = actTest1.get(i).getAcCHs();
                List<Integer> actTest1ChDB      = actTest1DB.get(i).getAcCHs();
                assertEquals(actTest1Ch.size(),actTest1ChDB.size());
                for (int j = 0; j < actTest1.get(i).getAcCHs().size(); j++) {
                    assertEquals(actTest1Ch.get(j),actTest1ChDB.get(j));
                }
            }
            assertEquals(testGame1.getGameGENREs().size(),testGame1DB.getGameGENREs().size());
            for (int i = 0; i < testGame1.getGameGENREs().size(); i++) {
                assertEquals(testGame1.getGameGENREs().get(i).getGenID(),testGame1DB.getGameGENREs().get(i).getGenID());
                assertEquals(testGame1.getGameGENREs().get(i).getGenTITLE(),testGame1DB.getGameGENREs().get(i).getGenTITLE());
                assertEquals(testGame1.getGameGENREs().get(i).getGenGAME(),testGame1DB.getGameGENREs().get(i).getGenGAME());
            }
            assertEquals(testGame1.getGameCHs().size(),testGame1DB.getGameCHs().size());
            for (int i = 0; i < testGame1.getGameCHs().size(); i++) {
                assertEquals(testGame1.getGameCHs().get(i).getChID(),testGame1DB.getGameCHs().get(i).getChID());
                assertEquals(testGame1.getGameCHs().get(i).getChNAME(),testGame1DB.getGameCHs().get(i).getChNAME());
                assertEquals(testGame1.getGameCHs().get(i).getChPFP(),testGame1DB.getGameCHs().get(i).getChPFP());
                assertEquals(testGame1.getGameCHs().get(i).getChGAME(),testGame1DB.getGameCHs().get(i).getChGAME());
            }
            assertEquals(testGame1.getGameGMs().size(),testGame1DB.getGameGMs().size());
            for (int i = 0; i < testGame1.getGameGMs().size(); i++) {
                assertEquals(testGame1.getGameGMs().get(i).getGmID(),testGame1DB.getGameGMs().get(i).getGmID());
                assertEquals(testGame1.getGameGMs().get(i).getGmTITLE(),testGame1DB.getGameGMs().get(i).getGmTITLE());
                assertEquals(testGame1.getGameGMs().get(i).getGmGAME(),testGame1DB.getGameGMs().get(i).getGmGAME());
            }
            assertEquals(testGame1.getGameTRAILERs().size(),testGame1DB.getGameTRAILERs().size());
            for (int i = 0; i < testGame1.getGameTRAILERs().size(); i++) {
                assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerID(),testGame1DB.getGameTRAILERs().get(i).getTrailerID());
                assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerURL(),testGame1DB.getGameTRAILERs().get(i).getTrailerURL());
                assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerGameID(),testGame1DB.getGameTRAILERs().get(i).getTrailerGameID());
            }
            assertEquals(testGame1.getGamePICs().size(),testGame1DB.getGamePICs().size());
            for (int i = 0; i < testGame1.getGamePICs().size(); i++) {
                assertEquals(testGame1.getGamePICs().get(i).getPicID(),testGame1DB.getGamePICs().get(i).getPicID());
                assertEquals(testGame1.getGamePICs().get(i).getPicURL(),testGame1DB.getGamePICs().get(i).getPicURL());
                assertEquals(testGame1.getGamePICs().get(i).getPicGameID(),testGame1DB.getGamePICs().get(i).getPicGameID());
            }
            assertEquals(testGame1.getGamePLAT().size(),testGame1DB.getGamePLAT().size());
            for (int i = 0; i < testGame1.getGamePLAT().size(); i++) {
                assertEquals(testGame1.getGamePLAT().get(i).getPlatID(),testGame1DB.getGamePLAT().get(i).getPlatID());
                assertEquals(testGame1.getGamePLAT().get(i).getPlatTITLE(),testGame1DB.getGamePLAT().get(i).getPlatTITLE());
                assertEquals(testGame1.getGamePLAT().get(i).getPlatGAMEs(),testGame1DB.getGamePLAT().get(i).getPlatGAMEs());
                assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getDay(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getDay());
                assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getMonth(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getMonth());
                assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getYear(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getYear());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void updateGame() {
        try (Connection c = mysql.createConnection()){
            del.deleteAllTables();
            GameDTO insertedGame = a.createGameDB(500, "COD1");
            gdao.createGame(insertedGame);
            GameDTO updatedGame = a.createGameDB1(500,"ZOD1");
            gdao.updateGame(500,updatedGame);
            GameDTO receivedGame = gdao.getGame(500);

            assertEquals(updatedGame.getGameID(),receivedGame.getGameID());
            assertEquals(updatedGame.getGameBG(),receivedGame.getGameBG());
            assertEquals(updatedGame.getGameBIO(),receivedGame.getGameBIO());
            assertEquals(updatedGame.getGameCover(),receivedGame.getGameCover());
            assertEquals(updatedGame.getGameNAME(),receivedGame.getGameNAME());
            assertEquals(updatedGame.getGameRELEASEDATE().getDay(),receivedGame.getGameRELEASEDATE().getDay());
            assertEquals(updatedGame.getGameRELEASEDATE().getMonth(),receivedGame.getGameRELEASEDATE().getMonth());
            assertEquals(updatedGame.getGameRELEASEDATE().getYear(),receivedGame.getGameRELEASEDATE().getYear());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentID(),receivedGame.getGameDEV().getDevPCOMPANY().getParentID());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentCOUNTRY(),receivedGame.getGameDEV().getDevPCOMPANY().getParentCOUNTRY());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentNAME(),receivedGame.getGameDEV().getDevPCOMPANY().getParentNAME());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay(),receivedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth(),receivedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth());
            assertEquals(updatedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear(),receivedGame.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear());
            assertEquals(updatedGame.getGameOST().getOstCOMP().getCompID(),receivedGame.getGameOST().getOstCOMP().getCompID());
            assertEquals(updatedGame.getGameOST().getOstCOMP().getCompFN(),receivedGame.getGameOST().getOstCOMP().getCompFN());
            assertEquals(updatedGame.getGameOST().getOstCOMP().getCompLN(),receivedGame.getGameOST().getOstCOMP().getCompLN());
            assertEquals(updatedGame.getGameOST().getOstCOMP().getCompGAME(),receivedGame.getGameOST().getOstCOMP().getCompGAME());
            List<Integer> compOstList1      = updatedGame.getGameOST().getOstCOMP().getCompOSTs();
            List<Integer> compOstList1DB    = receivedGame.getGameOST().getOstCOMP().getCompOSTs();
            for (int i = 0; i < updatedGame.getGameOST().getOstCOMP().getCompOSTs().size(); i++) {
                assertEquals(compOstList1.get(i),compOstList1DB.get(i));
            }
            assertEquals(updatedGame.getGameOST().getOstID(),receivedGame.getGameOST().getOstID());
            assertEquals(updatedGame.getGameOST().getOstURL(),receivedGame.getGameOST().getOstURL());
            assertEquals(updatedGame.getGameOST().getOstGAME(),receivedGame.getGameOST().getOstGAME());
            assertEquals(updatedGame.getGameOST().getOstTITLE(),receivedGame.getGameOST().getOstTITLE());
            List<MusicArtistDTO> ostMaList1     = updatedGame.getGameOST().getOstMA();
            List<MusicArtistDTO> ostMaList1DB   = receivedGame.getGameOST().getOstMA();
            for (int i = 0; i < updatedGame.getGameOST().getOstMA().size(); i++) {
                assertEquals(ostMaList1.get(i).getArtID(),ostMaList1DB.get(i).getArtID());
                assertEquals(ostMaList1.get(i).getArtNAME(),ostMaList1DB.get(i).getArtNAME());
                assertEquals(ostMaList1.get(i).getArtPFP(),ostMaList1DB.get(i).getArtPFP());
            }
            assertEquals(updatedGame.getGamePUB().getPubCREATED().getDay(),receivedGame.getGamePUB().getPubCREATED().getDay());
            assertEquals(updatedGame.getGamePUB().getPubCREATED().getMonth(),receivedGame.getGamePUB().getPubCREATED().getMonth());
            assertEquals(updatedGame.getGamePUB().getPubCREATED().getYear(),receivedGame.getGamePUB().getPubCREATED().getYear());
            assertEquals(updatedGame.getGamePUB().getPubCOUNTRY(),receivedGame.getGamePUB().getPubCOUNTRY());
            assertEquals(updatedGame.getGamePUB().getPubID(),receivedGame.getGamePUB().getPubID());
            assertEquals(updatedGame.getGamePUB().getPubNAME(),receivedGame.getGamePUB().getPubNAME());
            assertEquals(updatedGame.getGamePUB().getPubGAME(),receivedGame.getGamePUB().getPubGAME());
            assertEquals(updatedGame.getGameWRI().size(),receivedGame.getGameWRI().size());
            for (int i = 0; i < updatedGame.getGameWRI().size(); i++) {
                assertEquals(updatedGame.getGameWRI().get(i).getWriterID(),receivedGame.getGameWRI().get(i).getWriterID());
                assertEquals(updatedGame.getGameWRI().get(i).getWriterGAME(),receivedGame.getGameWRI().get(i).getWriterGAME());
                assertEquals(updatedGame.getGameWRI().get(i).getWriterFN(),receivedGame.getGameWRI().get(i).getWriterFN());
                assertEquals(updatedGame.getGameWRI().get(i).getWriterLN(),receivedGame.getGameWRI().get(i).getWriterLN());
            }
            List<ActorDTO> actTest1     = updatedGame.getGameACs();
            List<ActorDTO> actTest1DB   = receivedGame.getGameACs();
            for (int i = 0; i < updatedGame.getGameACs().size(); i++) {
                assertEquals(actTest1.get(i).getAcBDAY().getDay(),actTest1DB.get(i).getAcBDAY().getDay());
                assertEquals(actTest1.get(i).getAcBDAY().getMonth(),actTest1DB.get(i).getAcBDAY().getMonth());
                assertEquals(actTest1.get(i).getAcBDAY().getYear(),actTest1DB.get(i).getAcBDAY().getYear());
                assertEquals(actTest1.get(i).getAcFN(),actTest1DB.get(i).getAcFN());
                assertEquals(actTest1.get(i).getAcLN(),actTest1DB.get(i).getAcLN());
                assertEquals(actTest1.get(i).getAcID(),actTest1DB.get(i).getAcID());
                assertEquals(actTest1.get(i).getAcGAME(),actTest1DB.get(i).getAcGAME());
                assertEquals(actTest1.get(i).getAcPFP(),actTest1DB.get(i).getAcPFP());
                List<Integer> actTest1Ch        = actTest1.get(i).getAcCHs();
                List<Integer> actTest1ChDB      = actTest1DB.get(i).getAcCHs();
                assertEquals(actTest1Ch.size(),actTest1ChDB.size());
                for (int j = 0; j < actTest1.get(i).getAcCHs().size(); j++) {
                    assertEquals(actTest1Ch.get(j),actTest1ChDB.get(j));
                }
            }
            assertEquals(updatedGame.getGameGENREs().size(),receivedGame.getGameGENREs().size());
            for (int i = 0; i < updatedGame.getGameGENREs().size(); i++) {
                assertEquals(updatedGame.getGameGENREs().get(i).getGenID(),receivedGame.getGameGENREs().get(i).getGenID());
                assertEquals(updatedGame.getGameGENREs().get(i).getGenTITLE(),receivedGame.getGameGENREs().get(i).getGenTITLE());
                assertEquals(updatedGame.getGameGENREs().get(i).getGenGAME(),receivedGame.getGameGENREs().get(i).getGenGAME());
            }
            assertEquals(updatedGame.getGameCHs().size(),receivedGame.getGameCHs().size());
            for (int i = 0; i < updatedGame.getGameCHs().size(); i++) {
                assertEquals(updatedGame.getGameCHs().get(i).getChID(),receivedGame.getGameCHs().get(i).getChID());
                assertEquals(updatedGame.getGameCHs().get(i).getChNAME(),receivedGame.getGameCHs().get(i).getChNAME());
                assertEquals(updatedGame.getGameCHs().get(i).getChPFP(),receivedGame.getGameCHs().get(i).getChPFP());
                assertEquals(updatedGame.getGameCHs().get(i).getChGAME(),receivedGame.getGameCHs().get(i).getChGAME());
            }
            assertEquals(updatedGame.getGameGMs().size(),receivedGame.getGameGMs().size());
            for (int i = 0; i < updatedGame.getGameGMs().size(); i++) {
                assertEquals(updatedGame.getGameGMs().get(i).getGmID(),receivedGame.getGameGMs().get(i).getGmID());
                assertEquals(updatedGame.getGameGMs().get(i).getGmTITLE(),receivedGame.getGameGMs().get(i).getGmTITLE());
                assertEquals(updatedGame.getGameGMs().get(i).getGmGAME(),receivedGame.getGameGMs().get(i).getGmGAME());
            }
            assertEquals(updatedGame.getGameTRAILERs().size(),receivedGame.getGameTRAILERs().size());
            for (int i = 0; i < updatedGame.getGameTRAILERs().size(); i++) {
                assertEquals(updatedGame.getGameTRAILERs().get(i).getTrailerID(),receivedGame.getGameTRAILERs().get(i).getTrailerID());
                assertEquals(updatedGame.getGameTRAILERs().get(i).getTrailerURL(),receivedGame.getGameTRAILERs().get(i).getTrailerURL());
                assertEquals(updatedGame.getGameTRAILERs().get(i).getTrailerGameID(),receivedGame.getGameTRAILERs().get(i).getTrailerGameID());
            }
            assertEquals(updatedGame.getGamePICs().size(),receivedGame.getGamePICs().size());
            for (int i = 0; i < updatedGame.getGamePICs().size(); i++) {
                assertEquals(updatedGame.getGamePICs().get(i).getPicID(),receivedGame.getGamePICs().get(i).getPicID());
                assertEquals(updatedGame.getGamePICs().get(i).getPicURL(),receivedGame.getGamePICs().get(i).getPicURL());
                assertEquals(updatedGame.getGamePICs().get(i).getPicGameID(),receivedGame.getGamePICs().get(i).getPicGameID());
            }
            assertEquals(updatedGame.getGamePLAT().size(),receivedGame.getGamePLAT().size());
            for (int i = 0; i < updatedGame.getGamePLAT().size(); i++) {
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatID(),receivedGame.getGamePLAT().get(i).getPlatID());
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatTITLE(),receivedGame.getGamePLAT().get(i).getPlatTITLE());
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatGAMEs(),receivedGame.getGamePLAT().get(i).getPlatGAMEs());
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatCREATED().getDay(),receivedGame.getGamePLAT().get(i).getPlatCREATED().getDay());
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatCREATED().getMonth(),receivedGame.getGamePLAT().get(i).getPlatCREATED().getMonth());
                assertEquals(updatedGame.getGamePLAT().get(i).getPlatCREATED().getYear(),receivedGame.getGamePLAT().get(i).getPlatCREATED().getYear());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test //GOOD TO GO
    public void deleteGame() {
        try (Connection c = mysql.createConnection()){
            gdao.createGame(a.createGameDB(100,"TEST"));
            assertTrue(gdao.deleteGame(100));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

