package com.feng.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by Fengunion on 2017/6/7.
 * 数据库工具类
 */
public class DataBaseUtils {
    private static String username;//用户名
    private static String password;// 密码
    private static String dataBaseName;//数据库名

    static {
        config("com/feng/config/jdbc.properties");
    }

    /**
     * 配置数据库信息
     *
     * @param path 配置文件路径
     */
    public static void config(String path) {
        InputStream inputStream = DataBaseUtils.class.getClassLoader().getResourceAsStream(path);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            dataBaseName = properties.getProperty("db.dataBaseName");
        } catch (IOException e) {


        }

    }

    /**
     * 获取数据库连接
     *
     * @return Connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/" + dataBaseName
                    + "?useUnicode=true&characterEncoding=utf8", username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     * @param statement
     * @param rs
     */
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     *
     * @param sql
     * @param objects
     */
    public static void update(String sql, Object... objects) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement, null);
        }
    }

    /**
     * 查询所有数据
     *
     * @param sql
     * @param objects
     * @return
     */
    public static List<Map<String, Object>> queryForList(String sql, Object... objects) {
        List<Map<String, Object>> result = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new LinkedHashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    map.put(metaData.getColumnName(i + 1), resultSet.getObject(metaData.getColumnName(i + 1)));
                }
                result.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement, resultSet);
        }
        return result;
    }

    /**
     * 查询单个数据
     *
     * @param sql
     * @param objects
     * @return
     */
    public static Map<String, Object> queryForMap(String sql, Object... objects) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> list = queryForList(sql, objects);
        if (list.size() != 1) {
            return null;
        }
        result = list.get(0);
        return result;
    }


}
