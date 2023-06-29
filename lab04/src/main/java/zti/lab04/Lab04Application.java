package zti.lab04;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import zti.util.LogFilter;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class Lab04Application extends Application {
    public Lab04Application() {}

    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();
        set.add(HelloResource.class);
        set.add(JDBCResource.class);
        set.add(JPAResource.class);
        set.add(CorsFilter.class);
        set.add(LogFilter.class);
        return set;
    }

}