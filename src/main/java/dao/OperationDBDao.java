package dao;

import dao.exceptions.NoResultException;
import entity.Operation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDBDao implements OperationDao {
    private Connection connection;
    private static OperationDao instance = null;

    private OperationDBDao(Connection connection) {
        this.connection = connection;
    }

    public static OperationDao getInstance(Connection connection) {
        if (instance == null) {
            instance = new OperationDBDao(connection);
        }
        return instance;
    }

    @Override
    public void setOperationsList(List<Operation> operations) {
        try {
            PreparedStatement statement = connection.prepareStatement(SET_OPERATION);
            for (Operation operation : operations){
                statement.setLong(1, operation.getUserId());
                statement.setDouble(2, operation.getNum1());
                statement.setDouble(3, operation.getNum2());
                statement.setString(4, operation.getType());
                statement.setDouble(5, operation.getResult());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> getOperationsListByUserId(long userId) {
        List<Operation> operations = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_OPERATIONS_LIST_BY_ID);
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                operations.add(new Operation(
                        rs.getDouble("num1"),
                        rs.getDouble("num2"),
                        rs.getString("type"),
                        rs.getDouble("result")
                ));
            }
            if (!operations.isEmpty()) {
                return operations;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoResultException();
    }

    @Override
    public void clearOperationsListByUserId(long userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(CLEAR_OPERATIONS_LIST_BY_ID);
            statement.setLong(1, userId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean operationsListByUserIdContain(long userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(GET_OPERATIONS_LIST_BY_ID);
            statement.setInt(1,(int) userId);
            return statement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
