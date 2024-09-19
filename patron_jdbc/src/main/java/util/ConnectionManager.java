package util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConnectionManager {
    //%s es una variable que se puede formatear y poner lo que yo quiera
    private static final String CONNECTION_STRING_PATTERN = "jdbc:sqlite:%s";
    private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());
    private static ConnectionManager instance;
    private String connectionString;


    private ConnectionManager() {
        try {
            //especificio el drive
            DriverManager.registerDriver(new org.sqlite.JDBC());
            //buscamos el path del archivo,
            // con getResource buscamos el path mediante un string
            //get Path me devuelve el path
            String absolutePath = getClass().getResource("/data/aeropuerto.db")
                    .getPath();
            //aca reemplazo el %s por el path absoluto
            connectionString = String.format(CONNECTION_STRING_PATTERN, absolutePath);

        } catch (SQLException e) {
            //cacheamos el error de driver no encontrado
            LOGGER.log(Level.SEVERE, "Error: JDBC Driver Not Found", e);
        }
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
    //este efectivamente me va a terminar de crear un objeto conexion a base de datos
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(connectionString);
            System.out.println("Connection Successful");
            return conn;
        } catch (SQLException e) {
            System.err.println("Error: Unable to establish a connection to the database " + e.getMessage());
            return null;
        }
    }



}
