package Dao.Impl;
import Dao.DaoBase;
import Dao.PlantDao;
import Entity.Plant;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlantDaoImpl extends DaoBase implements PlantDao {
    @Override
    /*PreparedStatement 是 Java JDBC 中的一个接口，用于表示预编译的 SQL 语句的对象。
    它是 java.sql.PreparedStatement 接口的实例。通过使用 PreparedStatement，
    可以在执行 SQL 语句之前预先编译它，提高执行效率，并且可以通过占位符（?）来动态设置参数，避免 SQL 注入攻击
     */
    public void addPlant(Plant plant) {
        String sql = "INSERT INTO A_Plant VALUES(?,?,?,?,?,?,?,?) ";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plant.getId());
            preparedStatement.setString(2, plant.getAltername());
            preparedStatement.setString(3, plant.getFamilyname());
            preparedStatement.setString(4, plant.getFeature());
            preparedStatement.setString(5, plant.getValue());
            preparedStatement.setString(6, plant.getSkill());
            preparedStatement.setInt(7, plant.getClassifyID());
            preparedStatement.setString(8, plant.getDisAreaID());
            preparedStatement.executeUpdate();
            System.out.println("Add successful!");
            //preparedStatement.close();
        } /*catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 在适当的地方关闭 PreparedStatement 和 Connection
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭 Connection 等其他资源
        }
    }
    @Override
    public void deletePlant(Plant plant) {
        String sql = "delete from A_Plant where id= ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plant.getId());
            preparedStatement.executeUpdate();
            System.out.println("Delete successful!");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePlant(Plant plant,String[] fieldsToUpdate, String newValue) {
        StringBuilder setClause = new StringBuilder("SET ");
        for (String field : fieldsToUpdate) {
            setClause.append(field).append("=?,");
        }
        setClause.deleteCharAt(setClause.length() - 1); // 移除最后一个逗号

        // 构建 SQL 语句
        String sql = "UPDATE A_Plant " + setClause + " WHERE id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int paramIndex = 1;
            for (String field : fieldsToUpdate) {
                switch (field.trim()) {
                    case "altername":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "familyname":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "feature":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "value":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "skill":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "classifyID":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    case "disAreaID":
                        preparedStatement.setString(paramIndex++, newValue);
                        break;
                    default:
                        System.out.println("Invalid field: " + field);
                        break;
                }
            }
            preparedStatement.setString(paramIndex, plant.getId());
            preparedStatement.executeUpdate();
            System.out.println("Update successful.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findPlant(Plant plant) {
        String sql = "select A_Plant.*, A_Picture.* " +
                "FROM A_Plant p\n" +
                "JOIN A_Plant_Picture pp ON p.id = pp.plantId\n" +
                "JOIN A_Picture pic ON pp.photoId = pic.photoId" +
                "where id= ?;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, plant.getId());
            preparedStatement.executeUpdate();
            System.out.println("Find successful!");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
