package com.feng.util;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dataBaseName
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
    public static int update(String sql, Object... objects) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                statement.setObject(i + 1, objects[i]);
            }
            int i = statement.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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

    public static boolean queryIsExist(String sql, Object... objects) {
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            boolean execute = statement.execute(sql);
            System.out.println("是否存在："+execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    /**
     * 查出数据并返回一个javaBean
     *
     * @param sql
     * @param clazz
     * @param objects
     * @param <T>
     * @return
     */
    public static <T> T queryForBean(String sql, Class clazz, Object... objects) {
        T obj = null;
        Map<String, Object> map = null;
        Field field = null;
        try {
            obj = (T) clazz.newInstance();//创建一个新的bean实例
            map = queryForMap(sql, objects);//先将结果集放在一个Map中
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (map == null) {
            return null;
        }

        for (String columnName : map.keySet()) {
            Method method = null;
            String propertyName = StringUtils.columnToProperty(columnName);
            System.out.println("属性名称：" + propertyName);
            try {
                field = clazz.getDeclaredField(propertyName);

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            String fieldType = field.toString().split(" ")[1];
            System.out.println("javaBean中字段的类型：" + fieldType);
            Object value = map.get(columnName);
            if (value == null) {
                continue;
            }
            String setMethodName = "set" + StringUtils.upperCaseFirstCharacter(propertyName);
            System.out.println("获取javaBean中的set方法：" + setMethodName);
            String valueType = value.getClass().getName();
            if (!fieldType.equalsIgnoreCase(valueType)) {
                System.out.println("类型不匹配");
                if (fieldType.equalsIgnoreCase("java.lang.Integer")) {
                    value = Integer.parseInt(String.valueOf(value));
                } else if (fieldType.equalsIgnoreCase("java.lang.String")) {
                    value = String.valueOf(value);
                } else if (fieldType.equalsIgnoreCase("java.util.Date")) {
                    valueType = "java.util.Date";
                    String dateStr = String.valueOf(value);
                    Timestamp timestamp = Timestamp.valueOf(dateStr);
                    Date date = new Date(timestamp.getTime());
                    value = date;
                }
            }

            try {
                Method declaredMethod = clazz.getDeclaredMethod(setMethodName, Class.forName(fieldType));
                declaredMethod.invoke(obj, value);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }


        return obj;

    }


}
