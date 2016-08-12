package com.devarchi33.dao;

import static org.junit.Assert.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by donghoon on 15. 8. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mybatis-scan.xml"})
public class ConnectionTest {

    @Autowired
    ComboPooledDataSource dataSource;

    @Test
    public void dbConnectionTest() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            assertNotNull(conn);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM cubeone_user");

            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id") + ", email : " + rs.getString("email") +
                        ", password : " + rs.getString("password") + ", phone : " + rs.getInt("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
