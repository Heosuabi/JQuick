package eu.scilled.jquick;

interface ConfigurationInterface {
    @Config("String")
    String getString();

    @Config("String")
    void setString(String value);

    @Config("Int")
    int getInt();

    @Config("Int")
    void setInt(int value);

    @Config("Double")
    double getDouble();

    @Config("Double")
    void setDouble(double value);

    @Config("Float")
    float getFloat();

    @Config("Float")
    void setFloat(float value);

    @Config("Boolean")
    boolean getBoolean();

    @Config("Boolean")
    void setBoolean(boolean value);

    @Config("Long")
    long getLong();

    @Config("Long")
    void setLong(long value);

    String getNonExisting();
    void setNonExisting(String string);
}
