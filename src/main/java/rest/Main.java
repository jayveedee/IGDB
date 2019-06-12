package rest;

public class Main {

    public static void main(String[] args) {

        //DETTE KODE KILLER ALLE ACTIVE CONNECTIONS!!
        /*IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            String query = "SHOW FULL processlist";
            mysqlConnection.setPrepStatment(mysqlConnection.getConnection().prepareStatement(query));
            ResultSet resultSet = mysqlConnection.getPrepStatement().executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                System.out.println(id);
                mysqlConnection.setPrepStatment(mysqlConnection.getConnection().prepareStatement("KILL " + id));
                mysqlConnection.getPrepStatement().execute();
            }
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        //TESTER OM LISTEN AF GAME NAMES FRA SERVER FUNGERE ORDENTLIGT. TEST STATUS = INGEN PROBLEMER. KRÆVER AT GAMENAMESERVICE RETURNERE ET ARRAYLIST
        /*
        rest.Services services = new rest.Services();
        ArrayList<String> list = new ArrayList<>();

        services.createConnection();
        list = services.GameNamesService("p");
        services.closeConnection();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        //TESTER OM JSON STRINGEN BLIVER LAVET KORREKT ALT EFTER HVILKE SPIL MAN SØGER EFTER. TEST STATUS = INGEN PROBLEMER.
        Services services = new Services();
        services.createConnection();
        String json = services.GameNamesService("p");
        services.closeConnection();
        System.out.println(json);


        /*IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
            System.out.println(mysqlConnection.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (mysqlConnection.getConnection() == null){
            System.out.println("there are no connection");
        }else {
            System.out.println("there is a connection or something went wrong");
            try {
                mysqlConnection.closeConnection(mysqlConnection.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /*try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            IUserDAO userDAO = new UserDAO(mysqlConnection);
            UserDTO userDTO = new UserDTO();
            userDTO = userDAO.getUser("detteFindesIkke");

            System.out.println(userDTO.getUserNAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*IUserDAO userDAO = new UserDAO(mysqlConnection);
        IRoleDAO roleDAO = new RoleDAO(mysqlConnection);
        UserDTO userDTO = new UserDTO();

        ArrayList<RoleDTO> roleList = new ArrayList<>();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleNAME("user");
        roleDTO.setRoleID(1);
        roleList.add(roleDTO);

        ArrayList<Integer> gameList = new ArrayList<>();

        userDTO.setUserROLEs(roleList);
        userDTO.setUserGAMEs(gameList);
        userDTO.setUserPASS("hejsa");
        userDTO.setUserNAME("Asama");
        userDTO.setUserEMAIL("asama@yahoo.dk");
        userDTO.setUserPFP("skerder.dk");

        userDAO.deleteAllUserRoles("asamahayder");
        userDAO.deleteAllUserGameLists("asamahayder");
        userDAO.deleteUser("asamahayder");*/


    }
}
