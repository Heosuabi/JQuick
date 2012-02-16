package eu.scilled.jquick;

import eu.scilled.jquick.parser.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
class MapInvocationHandler implements InvocationHandler {

    private static final NullParser NULL_PARSER = new NullParser();
    private final Map<Object, Object> map;
    private final Map<Class<?>, Parser<?, ?>> parsers;

    MapInvocationHandler(final Map<Object, Object> map) {
        this.map = map;
        parsers = new HashMap<Class<?>, Parser<?, ?>>();
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args)
            throws Throwable {
        if (method.isAnnotationPresent(Config.class)) {
            MethodType type = getMethodType(method);
            if (type == MethodType.SETTER) {
                invokeAsSetter(method, args);
            } else {
                return invokeAsGetter(method);
            }
        }
        return null;
    }

    private Object invokeAsGetter(final Method method) {
        String key = getConfigKey(method);
        Object value = map.get(key);
        Class<?> parser = getParserClass(method);
        if (isAutomaticParser(parser)) {
            return automaticParse(method, value);
        }
        return userDefinedParse(parser, value);
    }

    private Object userDefinedParse(final Class<?> parserClass, final Object value) {
        Parser parserInstance = getParserInstance(parserClass);
        return parserInstance.load(value);
    }

    private boolean isAutomaticParser(final Class<?> parser) {
        return parser == AutomaticParser.class;
    }

    private Class<?> getParserClass(final Method method) {
        return method.getAnnotation(Config.class).parser();
    }

    private Object automaticParse(final Method method, final Object value) {
        Class<?> returnType = method.getReturnType();
        Parser parser = getParserFromClassType(returnType);
        return parser.load(value);
    }

    private Parser getParserFromClassType(final Class<?> classType) {
        if (classType == String.class) {
            return getParserInstance(StringParser.class);
        } else if (classType == Integer.TYPE) {
            return getParserInstance(IntParser.class);
        } else if (classType == Double.TYPE) {
            return getParserInstance(DoubleParser.class);
        } else if (classType == Float.TYPE) {
            return getParserInstance(FloatParser.class);
        } else if (classType == Long.TYPE) {
            return getParserInstance(LongParser.class);
        } else if (classType == Boolean.TYPE) {
            return getParserInstance(BooleanParser.class);
        } else if (classType == Character.TYPE) {
            return getParserInstance(CharParser.class);
        } else if (classType == Short.TYPE) {
            return getParserInstance(ShortParser.class);
        } else if (classType == Byte.TYPE) {
            return getParserInstance(ByteParser.class);
        }
        return NULL_PARSER;
    }

    private Parser getParserInstance(final Class<?> class1) {
        if (parsers.containsKey(class1)) {
            return parsers.get(class1);
        }

        try {
            Parser parser = (Parser) class1.newInstance();
            parsers.put(class1, parser);
            return parser;
        } catch (InstantiationException e) {
            // TODO Better exception handling...
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Better exception handling...
            e.printStackTrace();
        }

        return NULL_PARSER;
    }

    private void invokeAsSetter(final Method method, final Object[] args) {
        String key = getConfigKey(method);
        if (args != null && args.length > 0) {
            Object toSet = args[0];
            Class<?> parserClass = getParserClass(method);
            Object realValue;
            if (isAutomaticParser(parserClass)) {
                realValue = parseParameterToConfigValue(method.getParameterTypes()[0], toSet);
            } else {
                realValue = parseParameterWithUserDefinedParser(parserClass, toSet);
            }
            map.put(key, realValue);
        }
    }

    private Object parseParameterWithUserDefinedParser(final Class<?> parserClass, final Object parameter) {
        Parser parser = getParserInstance(parserClass);
        return parser.save(parameter);
    }

    private Object parseParameterToConfigValue(final Class<?> type, final Object parameter) {
        Parser parser = getParserFromClassType(type);
        return parser.save(parameter);
    }

    private String getConfigKey(final Method method) {
        Config config = method.getAnnotation(Config.class);
        return config.value();
    }

    private MethodType getMethodType(final Method method) {
        Class<?> returnType = method.getReturnType();
        if (returnType == Void.TYPE) {
            return MethodType.SETTER;
        }

        String methodName = method.getName();
        if (methodName.startsWith("set")) {
            return MethodType.SETTER;
        }

        return MethodType.GETTER;
    }

}
