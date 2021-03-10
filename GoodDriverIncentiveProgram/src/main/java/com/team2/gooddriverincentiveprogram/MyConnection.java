/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.gooddriverincentiveprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfgre
 */
//https://medium.com/modernnerd-code/connecting-to-mysql-db-on-aws-ec2-with-jdbc-for-java-91dba3003abb
//https://1bestcsharp.blogspot.com/2018/05/java-login-and-register-form-with-mysql-database.html
//https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-rds.html
public class MyConnection {
    
    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, e);
            return con;
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://team-2-database-4910.cd0dbvuyb2fe.us-east-1.rds.amazonaws.com:3306/application_db?user=admin&password=Team2rules");
        } catch (Exception e) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return con;
    }
}
