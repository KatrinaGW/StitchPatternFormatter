package pattern_printer.infrastructure;

import java.lang.System.Logger;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Config;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Query;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.exceptions.Neo4jException;

public class StitchGlossaryDatabaseDriver implements AutoCloseable {
    // private static final Logger LOGGER =
    // Logger.getLogger(StitchGlossaryDatabaseDriver.class.getName());
    private final Driver driver;

    public StitchGlossaryDatabaseDriver() {
        driver = GraphDatabase.driver();
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

}
