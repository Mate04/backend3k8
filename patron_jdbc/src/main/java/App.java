import models.Aeropuerto;
import repository.AeropuertoRepository;
import repository.SqliteAeropuertoRepository;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AeropuertoRepository repository = new SqliteAeropuertoRepository();
        List<Aeropuerto> aeropuertos = repository.findAll();
        aeropuertos.forEach(System.out::println);
        var res = repository.findById(3);
        System.out.println(res);
    }
}
