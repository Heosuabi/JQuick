package eu.scilled.jquick;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Properties;

/**
 * <p>JQuick "wraps" an user defined interface and backs it up with a Map or Properties.</p>
 */
public final class JQuick {

    private JQuick() {
    }

    public static <T> T create(final Properties properties, final Class<T> target) {
        return createProxyInstance(properties, target);
    }

    public static <T> T create(final Map<String, String> map, final Class<T> target) {
        return createProxyInstance(map, target);
    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxyInstance(final Map<?, ?> properties, final Class<T> target) {
        InvocationHandler handler = new MapInvocationHandler((Map<Object, Object>) properties);
        return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[] { target }, handler);
    }

}
