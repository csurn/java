import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SqlBuilder {
    public static SqlBuilder create()
    {
        return new SqlBuilder();
    }

    private SqlBuilder()
    {
        this.sql="";
    }

    private String sql;

    public String Build()
    {
        return this.sql;
    }

    private SqlBuilder append()
    {
        this.sql+=Thread.currentThread().getStackTrace()[2].getMethodName()+" ";
        return this;
    }
    private  SqlBuilder append(String value)
    {
        this.sql+=value+" ";
        return this;
    }

    private static  <T> String GetName(PropertyFunc<T,?> func) {
        Method method = null;
        try {
            method = func.getClass().getDeclaredMethod("writeReplace");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(Boolean.TRUE);

        SerializedLambda serializedLambda = null;
        try {
            serializedLambda = (SerializedLambda)(method.invoke(func));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String getMethodName = serializedLambda.getImplMethodName();

        if (getMethodName.startsWith("get")) {
            getMethodName = getMethodName.substring(3);
        } else if (getMethodName.startsWith("is")) {
            getMethodName = getMethodName.substring(2);
        }
        return getMethodName.substring(0, 1).toLowerCase() + getMethodName.substring(1);
    }

    public SqlBuilder from()
    {
        return this.append();
    }

    public SqlBuilder select()
    {
        return this.append();
    }

    public SqlBuilder where()
    {
        return this.append();
    }

    public <T> SqlBuilder column(PropertyFunc<T, ?> value)
    {
        return this.append(GetName(value));
    }

    public SqlBuilder equals()
    {
        return this.append();
    }

    public <T> SqlBuilder param(PropertyFunc<T, ?> value)
    {
        return this.append(GetName(value));
    }

    public <T> SqlBuilder table(Class<?> value)
    {
        return this.append(value.getName());
    }
}
