package repository;

import models.Aeropuerto;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqliteAeropuertoRepository implements AeropuertoRepository {
    @Override
    public void add(Aeropuerto toSave) {
        String insertQuery = """
                INSERT INTO Aeropuertos ( codigo_internacional, nombre)
                values (?,?);
                """;
        //aca hacemos la conexion a base de datos

        try (
                Connection conn = ConnectionManager.getInstance()
                        .getConnection()
        ){

            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.setString(1,toSave.getCodigoInternacional());
            statement.setString(2,toSave.getNombre());
            //ejecutamos la query en cuestion
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){

            e.printStackTrace();
        }
    }

    @Override
    public Aeropuerto findById(Integer id) {
        String selectByIdQuery = """
                SELECT codigo, codigo_internacional, nombre
                FROM Aeropuertos
                WHERE codigo = ?
                """;
        try(
                Connection conn = ConnectionManager.getInstance()
                        .getConnection())
        {
            PreparedStatement statementSelect = conn.prepareStatement(selectByIdQuery);
            statementSelect.setInt(1,id);
            ResultSet res = statementSelect.executeQuery();
            statementSelect.close();
            if (!res.next()){
                throw new SQLException();
            }

            return resultSetToAeropuerto(res);



        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Aeropuerto> findAll() {
        List<Aeropuerto> resultado = new ArrayList<>();
        String selectAll = """
                SELECT codigo, codigo_internacional, nombre
                FROM Aeropuertos
                """;
        try(
                Connection conn = ConnectionManager.getInstance()
                        .getConnection()
        ){
            PreparedStatement statementSelect = conn.prepareStatement(selectAll);
            ResultSet res = statementSelect.executeQuery();
            statementSelect.close();
            while (res.next()){
                Aeropuerto aeropuerto = resultSetToAeropuerto(res);
                resultado.add(aeropuerto);
            }
            return resultado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Aeropuerto resultSetToAeropuerto(ResultSet res) throws SQLException {
        int cod = res.getInt("codigo");
        String nombre = res.getString("nombre");
        String codigoInternacion = res.getString("codigo_internacional");
        return new Aeropuerto(cod,nombre,codigoInternacion);
    }
}
