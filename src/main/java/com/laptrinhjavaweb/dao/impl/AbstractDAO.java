package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Load drive -> insert driver name according to the DB version
            String url = "jdbc:mysql://localhost:3306/newservlet122020";
            String user = "root";
            String password = "PokemonAv2522!";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            //ClassNotFoundException cho truong hop k tim thay Driver
            //SQLException cho truong hop nhap sai user hoac password
            return null;
        }
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            //truyen Query vao trong Connection(ex: Lenh trong file Query 1 trong MySQL Workbench)
            statement = connection.prepareStatement(sql);
            //set parameter for the SQL statement (ex: WHERE categoryId = ? -> ? = parameter)
            setParameter(statement, parameters);
            //execute Query (Execute lenh trong MySQL Workbench)
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(String sql, Object... parameters) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            //Turn off auto commit to protect DB
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            //use commit method to allow changes in database if the above updating is succeed
            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    //If the updating has any error -> cannot commit and run rollback method to not allow any changes to DB
                    connection.rollback();
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Long id = null;
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length - 1; i++) {
                Object parameter = parameters[i];
                int index = i + 1;

                //Check the datatype of the parameter
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                }
                else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                }
                else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                }
                else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
