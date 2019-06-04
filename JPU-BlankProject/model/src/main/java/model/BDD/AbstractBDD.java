package model.BDD;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * @author Achille Brossier
 *The class Is a Lie
 */

public abstract class AbstractBDD {


    protected static ResultSet executeQuery(final String query) {
        return BDDConnector.getInstance().executeQuery(query);
    }


    protected static int executeUpdate(final String query) {
        return BDDConnector.getInstance().executeUpdate(query);
    }


    protected static CallableStatement prepareCall(final String query) {
        return BDDConnector.getInstance().prepareCall(query);
    }
}