package org.example;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String url = "rmi://localhost:8883";
        Context ctx = new InitialContext();
        ctx.lookup(url);
    }
}
