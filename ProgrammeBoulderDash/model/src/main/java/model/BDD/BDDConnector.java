package model.BDD;

import java.sql.*;
import java.util.Properties;

/**
 * @author Achille Brossier
 * I'am the link Between Class
 */

final class BDDConnector extends Properties {


    private static BDDConnector instance;

    private final static String	PROPERTIES_FILE_NAME	= "model.properties";

    private static String user="root" ;


    private static String password ="admin";


    private static String url="jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false" ;


    private Connection connection;


    private Statement statement;

    /**
     * Open a new connection
     */
    private BDDConnector() {
        this.open();
    }

    /**
     * Get the instance
     * @return
     */
    public static BDDConnector getInstance() {
        if (instance == null) {
            setInstance(new BDDConnector());
        }
        return instance;
    }

    /**
     * Set the instance
     * @param instance
     */
    private static void setInstance(final BDDConnector instance) {
        BDDConnector.instance = instance;
    }

    /**
     * Function for open the Data base
     * @return
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(BDDConnector.url, BDDConnector.user,
                    BDDConnector.password);
            this.statement = this.connection.createStatement();
            return true;

        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Execute the Query
     * @param query
     * @return
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare the call of the Data Base
     * @param query
     * @return
     */
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Do the update
     * @param query
     * @return
     */

    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Get connection
     * @return
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Set connection
     * @param connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * get the state
     * @return
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * set the state
     * @param statement
     */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

}