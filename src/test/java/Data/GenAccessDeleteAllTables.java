package Data;

import java.sql.SQLException;

public class GenAccessDeleteAllTables {

    private IMysqlConnection mySql = new MysqlConnection();

    public void deleteAllTables(){
        String query01 = "DELETE FROM ActorList";           String query02 = "DELETE FROM CharacterList";
        String query03 = "DELETE FROM SoundtrackList";      String query04 = "DELETE FROM MusicalArtistList";
        String query05 = "DELETE FROM ComposerList";        String query06 = "DELETE FROM WriterList";
        String query07 = "DELETE FROM GenreList";           String query08 = "DELETE FROM GameModeList";
        String query09 = "DELETE FROM PlatformList";        String query10 = "DELETE FROM TrailerList";
        String query11 = "DELETE FROM PictureList";         String query12 = "DELETE FROM UserGameList";
        String query13 = "DELETE FROM DeveloperList";       String query14 = "DELETE FROM ParentCompany";
        String query15 = "DELETE FROM PublisherList";       String query16 = "DELETE FROM RatingList";
        String query17 = "DELETE FROM ChangeList";          String query18 = "DELETE FROM UserRoleList";
        String query19 = "DELETE FROM Roles";               String query20 = "DELETE FROM Users";
        String query21 = "DELETE FROM Game";
        handleDeleteALL(query01);handleDeleteALL(query02);handleDeleteALL(query03);handleDeleteALL(query04);handleDeleteALL(query05);
        handleDeleteALL(query06);handleDeleteALL(query06);handleDeleteALL(query07);handleDeleteALL(query08);handleDeleteALL(query09);
        handleDeleteALL(query10);handleDeleteALL(query11);handleDeleteALL(query12);handleDeleteALL(query13);handleDeleteALL(query14);
        handleDeleteALL(query15);handleDeleteALL(query16);handleDeleteALL(query17);handleDeleteALL(query18);handleDeleteALL(query19);
        handleDeleteALL(query20);handleDeleteALL(query21);
    }

    private boolean handleDeleteALL(String query){
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
