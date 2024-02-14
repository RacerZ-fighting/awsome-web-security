package org.example;

import javax.naming.InitialContext;

/**
 * @author by RacerZ
 * @date 2024/2/14.
 */
public class LdapTest {
    public static void main(String[] args) throws Exception {
        new InitialContext().lookup("rmi://localhost:8883/racerz");
    }
}
