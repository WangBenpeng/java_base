package com.pengo.design.proxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 12:18
 */
public class ProxyDemo {
    static final String jdbcUrl = "jdbc:mysql://localhost/test?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "root";
    static final String jdbcPassword = "rootroot";

    public static void main(String[] args) throws Exception{
        DataSource ds = new LazyDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
        System.out.println("get lazy connection...");
        try (Connection conn1 = ds.getConnection()) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("get lazy connection...");
        try (Connection conn2 = ds.getConnection()){
            try (PreparedStatement ps = conn2.prepareStatement("select * from user")) {
                try (ResultSet rs = ps.executeQuery()){
                    while (rs.next()) {
                        System.out.println(rs.getString("account"));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //缓存连接
        DataSource pooledDataSource = new PooledDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
        try (Connection conn = pooledDataSource.getConnection()) {
        }
        try (Connection conn = pooledDataSource.getConnection()) {
            // 获取到的是同一个Connection
        }
        try (Connection conn = pooledDataSource.getConnection()) {
            // 获取到的是同一个Connection
        }
    }
}
