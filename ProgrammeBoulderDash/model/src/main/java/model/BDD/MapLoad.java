package model.BDD;




import java.sql.*;
import java.util.Arrays;

/**
 * @author Achille Brossier
 * Map is coming
 */

public  class MapLoad extends AbstractBDD {
    public static String map;
    public static int posX;
    public static int posY;
    private static int[][] maps;

    public MapLoad() {}

    /**
     *Creation of a table who recovers the data of map in the BDD
     * @param id
     * @return
     * @throws SQLException
     */
    public static int[][] readMap(int id) throws SQLException {

        final CallableStatement callStatementMapCode = prepareCall("{call callMap(?)}");
        // int[][] map= new int[22][42];
        maps = new int[22][42];
        callStatementMapCode.setInt(1,id);
        callStatementMapCode.execute();
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            System.out.println("Test");
            while (result.next()) {
                posX = result.getInt("map_x");
                posY = result.getInt("map_y");
                maps[posX][posY] = result.getInt("element");

            }
            result.close();
        }System.out.println(Arrays.deepToString(maps));
        return maps;

    }

    /**
     *Getter of element position according to the id
     * @param id
     * @return
     * @throws SQLException
     */

    private static ResultSet getPos(int id) throws SQLException {
        BDDConnector jpublankproject = BDDConnector.getInstance();
        Connection conn = jpublankproject.getConnection();
        Statement state = conn.createStatement();
        ResultSet result = state.executeQuery("CALL getPos(" + id + ")");
        return result;
    }



}