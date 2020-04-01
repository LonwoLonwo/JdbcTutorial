package service;

import buisnessLogic.Util;
import dao.CruDDAO;
import entity.Adress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdressService extends Util implements CruDDAO<Adress, Long> {


    public void createOne(Adress adress) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ADRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, adress.getId());
            preparedStatement.setString(2, adress.getCountry());
            preparedStatement.setString(3, adress.getCity());
            preparedStatement.setString(4, adress.getStreet());
            preparedStatement.setString(5, adress.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    public List<Adress> getAll() throws SQLException {
        Connection connection = getConnection();
        List<Adress> adressList = new ArrayList<Adress>();

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADRESS";

        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Adress adress = new Adress();
                adress.setId(resultSet.getLong("ID"));
                adress.setCountry(resultSet.getString("COUNTRY"));
                adress.setCity(resultSet.getString("CITY"));
                adress.setStreet(resultSet.getString("STREET"));
                adress.setPostCode(resultSet.getString("POST_CODE"));

                adressList.add(adress);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return adressList;
    }

    public Adress findById(Long id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADRESS WHERE ID=?";

        Adress adress = new Adress();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){//или while? в любом случае, без это строчки сетаться не будет
                adress.setId(resultSet.getLong("ID"));
                adress.setCountry(resultSet.getString("COUNTRY"));
                adress.setCity(resultSet.getString("CITY"));
                adress.setStreet(resultSet.getString("STREET"));
                adress.setPostCode(resultSet.getString("POST_CODE"));
            }
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return adress;
    }

    public void updateOne(Adress adress) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ADRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, adress.getCountry());
            preparedStatement.setString(2, adress.getCity());
            preparedStatement.setString(3, adress.getStreet());
            preparedStatement.setString(4, adress.getPostCode());
            preparedStatement.setLong(5, adress.getId());

            preparedStatement.executeUpdate();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    public void deleteOne(Adress adress) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ADRESS WHERE ID=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, adress.getId());

            preparedStatement.executeUpdate();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
