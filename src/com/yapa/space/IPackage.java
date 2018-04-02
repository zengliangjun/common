package com.yapa.space;

import com.yapa.space.api.graphics.Geometry;

public interface IPackage {

    boolean alloc();
    IPackage copyToNew();
    boolean release();

    boolean write(boolean value);
    // boolean write(byte value);
    boolean write(int value);
    boolean write(long value);
    boolean write(float value);
    boolean write(double value);
    boolean write(Geometry.Rect3d value);
    boolean write(Geometry.PlaneXY3d value);
    boolean write(String value);
    boolean write(Object value);

    boolean writeArray(boolean value[]);
    // boolean writeArray(byte value[]);
    boolean writeArray(int value[]);
    boolean writeArray(long value[]);
    boolean writeArray(float value[]);
    boolean writeArray(double value[]);
    boolean writeArray(Geometry.Rect3d value[]);
    boolean writeArray(Geometry.PlaneXY3d value[]);
    boolean writeArray(String value[]);
    boolean writeArray(Object value[]);

    boolean readBool();
    // char    readChar();
    int     readInt();
    long    readLong();
    float   readFloat();
    double  readDouble();
    Geometry.Rect3d readRect3d();
    Geometry.PlaneXY3d readPlaneXY3d();

    String  readString();
    Object  readObject();

    boolean[] readBoolArray();
    // char[]    readCharArray();
    int[]     readIntArray();
    long[]    readLongArray();
    float[]   readFloatArray();
    double[]  readDoubleArray();
    Geometry.Rect3d[] readRect3dArray();
    Geometry.PlaneXY3d[] readPlaneXY3dArray();

    /*
    String[]  readStringArray();
    Object[]  readObjectArray();
*/
    static interface IPackageable {
        public void writeToPackage(IPackage pck, int flage);
    }

    public static final int NOTIFY_ADDELEMENT = 0;   // YapaPackage.h
    public static final int NOTIFY_REMOVEELEMENT = NOTIFY_ADDELEMENT + 1;
    public static final int NOTIFY_UPDATEELEMENT = NOTIFY_REMOVEELEMENT + 1;
    public static final int NOTIFY_SYSTEMEVENT = NOTIFY_UPDATEELEMENT + 1;

    static interface IPackageToNative {
        public IPackage allocPackage();
        public void notifyPackage(IPackage pck);
    }

    static interface IPackageHandleNative {
        public void handleNativePackage(IPackage pck);
    }
}
