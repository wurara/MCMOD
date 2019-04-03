package cn.yonyou;

import java.sql.*;

public class SQLUtils {
    /**
     *
     * @param name1 一个表的表名
     * @param name2  另一个表的表名
     */
    public  String ConnectTable(String name1,String name2,String username,String pwd,String url){

        String Filed = new String("无法链接"+name1+"和"+name2);
        Connection conn;

        try {
            //加载驱动类
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2:获取连接
            conn = DriverManager.getConnection(username,pwd,url);
            //获取数据库操作对象
            Statement st = conn.createStatement();
            //执行数据库查询语句
            ResultSet rs1 = st.executeQuery("select * from" + name1);
            ResultSetMetaData rsmd1 =  rs1.getMetaData();
            ResultSet rs2 = st.executeQuery("select * from" + name2);
            ResultSetMetaData rsmd2 =  rs2.getMetaData();

            int n = rsmd2.getColumnCount();
            rs1.next();
            for (int i = 0; i < n; i++) {

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1){
            e1.printStackTrace();
        }

        return Filed;
    }

    public static void main(String[] args) {
        SQLUtils sq = new SQLUtils();

    }
}
