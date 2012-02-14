JQuick
======

What is JQuick?
---------------
JQuick is an API which provides an alternative way of handling configuration properties.
It is often the case that someone has a simple .properties file, reads it somewhere and uses the read values in some way.

JQuick tries to encapsulates this manually handling of property values.

Usage
-----
The first step to use JQuick is to define an interface with setters and getters for the properties.
For example you could create an interface named WindowProperties which gets and sets the last properties of a window:
width, height and last location.

Each setter and getter has to be annotated with the `@Config` annotation. The value of the annotation is the key inside
the properties file. No implementation of this interface is necessary.

After that you just have to load your properties file and call the JQuick `create()` method:

    WindowProperties windowProperties = JQuick.create(properties, WindowProperties.class);

That's it. You are now able to call the defined getter/setter and all changes are reflected at the `Properties`.

The last thing you have to do is to save the properties when your program closes.

### How does this work?
JQuick uses reflection and creates a `Proxy` for the interface backed by the `Properties` or a `Map<String, String>`.

It uses Parsers to convert the property value string to the resulting type and back again.
JQuick is able to automatically parse most of the primitive types and String.

When you need to parse your property value to a type of your own, you can do it. Just define your own parser and set
the parser with the `@Config` annotation.

### Writing an own parser?
You can write an own parser by implementing the generic `Parser` interface.

Because most of the time you need to parse from string to something and back to string again, there is a simplified abstract
class you can inherit: `PropertyParser`

### Still... I have to save my properties manually
This is something I also want to change and in a future release there will be something to tackle this problem
with different attempts.