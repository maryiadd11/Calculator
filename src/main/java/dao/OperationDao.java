package dao;

import entity.Operation;

import java.util.List;

public interface OperationDao {

    String SET_OPERATION = "INSERT INTO operations VALUES (null, ?, ?, ?, ?, ?)";
    String GET_OPERATIONS_LIST_BY_ID = "SELECT * FROM operations WHERE user_id = ?";
    String CLEAR_OPERATIONS_LIST_BY_ID = "DELETE FROM operations WHERE user_id = ?";

    void setOperationsList(List<Operation> operations);
    List<Operation> getOperationsListByUserId(long userId);
    void clearOperationsListByUserId(long userId);
    boolean operationsListByUserIdContain(long userId);
}
