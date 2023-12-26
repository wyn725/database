import java.sql.*;
public class Dome {
    public static void main(String[] args) {
        //定义加载驱动
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //定义数据库用户
        String userName = "sa";
        //定义数据库密码
        String userPwd = "123456";
        //定义数据库连接对象
        Connection dbConn = null;
        //定义命令对象
        Statement stmt=null;
        try {
            //1.加载及注册驱动
            Class.forName(driverName);
            //2.定义数据库连接字符串
            String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=PLANT";
            //3.数据库连接
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功");
            //4.定义SQL语句
            String sql="select * from A_Plant";
            //5.创建一个执行sql对象
            stmt=dbConn.createStatement();
            //6.执行SQL语句命令
            ResultSet resultSet = stmt.executeQuery(sql);
            //7.处理结果，并获取数据
            while (resultSet.next()){
                String userID=resultSet.getString("id");
                String password=resultSet.getString("altername");
                String name=resultSet.getString("familyname");
                System.out.println(userID+"\t"+password+"\t"+name);
            }
            //8.关闭连接
            resultSet.close();
            dbConn.close();
            stmt.close();
        } catch (SQLException e) {      //数据库的处理异常的方法
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (dbConn!=null){
                try {
                    dbConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

