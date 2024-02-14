import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    // App#exec
    public static void exec() throws IOException {
        Runtime.getRuntime().exec("open -a calculator");
    }
}
