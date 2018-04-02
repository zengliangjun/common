package com.yapa.base;

import java.lang.reflect.Method;

import com.yapa.space.api.IScene;
import com.yapa.spacev2.ContentAttributeEnty;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;
import com.yapa.spacev2.ContentAttributeEnty.SkeyboxImageEnty;
import com.yapa.spacev2.simple.SkeyboxShapeElement;
import com.yapa.spacev2.simple.SphereShapeElement;

import android.os.Build;
import android.os.Looper;
import android.util.Log;

public class SpaceUtils {

    static Class gHasSyncBarrierClass;
    static Method gPostSyncBarrier;
    static Method gRemoveSyncBarrier;

    private static void setupSystem() {

        if (null != gHasSyncBarrierClass)
            return;
        try {
            if (Build.VERSION.SDK_INT > 22) {
                gHasSyncBarrierClass = Class.forName("android.os.MessageQueue");
    
            } else {
                gHasSyncBarrierClass = Class.forName("android.os.Looper");
            }

            gPostSyncBarrier = gHasSyncBarrierClass.getMethod("postSyncBarrier");
            gRemoveSyncBarrier = gHasSyncBarrierClass.getMethod("removeSyncBarrier", Integer.class);

        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("setupSystem");
        }
    }

    public static int postSyncBarrier() {
        setupSystem();

        Object object = null;
        if (Build.VERSION.SDK_INT > 22) {
            object = Looper.myQueue();
        } else {
            object = Looper.myLooper();
        }
        Integer result = null;

        try {
            result = (Integer)gPostSyncBarrier.invoke(object);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("postSyncBarrier");
        }

        return result.intValue();
    }

    public static void removeSyncBarrier(int barrier) {
        setupSystem();

        Object object = null;
        if (Build.VERSION.SDK_INT > 22) {
            object = Looper.myQueue();
        } else {
            object = Looper.myLooper();
        }
        try {
            gRemoveSyncBarrier.invoke(barrier);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("postSyncBarrier");
        }
    }

    // sample as IIYapaWorker
    static final int ELEMENT = 0;
    static final int NORMALWORKER = 1;
    static final int SYSTEMWORKER = 2;
    static final int BILLBOARD_FRONTTOP = 3;
    static final int BILLBOARD_FRONTCENTER = 4;
    static final int BILLBOARD_FRONTBOTTOM = 5;

    static final int BILLBOARD_LEFTTOP = 6;
    static final int BILLBOARD_LEFTCENTER = 7;
    static final int BILLBOARD_LEFTBOTTOM = 8;

    static final int BILLBOARD_RIGHTTOP = 9;
    static final int BILLBOARD_RIGHTCENTER = 10;
    static final int BILLBOARD_RIGHTBOTTOM = 11;

    static final int BILLBOARD_BACKGROUNDTOP = 12;
    static final int BILLBOARD_BACKGROUNDCENTER = 13;
    static final int BILLBOARD_BACKGROUNDBOTTOM = 14;

    public static final long ELEMENTROOT_MASK    = 0X00FF000000000000L;
    public static final long ELEMENTROOT_ELEMENT = 0X0001000000000000L;
    // static final long gTextureFlag  = 0X2000000000000000L;
    // static final long gSystemUIFlag = 0X4000000000000000L;
    static long gElementId = 0;

    public static long idGenerater() {
        return idGenerater(ELEMENT);
    }

    public static long idGenerater(int type) {
        long result = gElementId;
        switch (type) {
            case ELEMENT: {
                result = gElementId | 0X0000000000000000L;
                break;
            }
            case NORMALWORKER: {
                result = gElementId | 0X0100000000000000L;
                break;
            }
            case SYSTEMWORKER: {
                result = gElementId | 0X0200000000000000L;
                break;
            }
            case BILLBOARD_FRONTTOP: {
                result = gElementId | 0X0300000000000000L;
                break;
            }
            case BILLBOARD_FRONTCENTER: {
                result = gElementId | 0X0400000000000000L;
                break;
            }
            case BILLBOARD_FRONTBOTTOM: {
                result = gElementId | 0X0500000000000000L;
                break;
            }
            case BILLBOARD_LEFTTOP: {
                result = gElementId | 0X0600000000000000L;
                break;
            }
            case BILLBOARD_LEFTCENTER: {
                result = gElementId | 0X0700000000000000L;
                break;
            }
            case BILLBOARD_LEFTBOTTOM: {
                result = gElementId | 0X0800000000000000L;
                break;
            }
            case BILLBOARD_RIGHTTOP: {
                result = gElementId | 0X0900000000000000L;
                break;
            }
            case BILLBOARD_RIGHTCENTER: {
                result = gElementId | 0X0A00000000000000L;
                break;
            }
            case BILLBOARD_RIGHTBOTTOM: {
                result = gElementId | 0X0B00000000000000L;
                break;
            }
            case BILLBOARD_BACKGROUNDTOP: {
                result = gElementId | 0X0C00000000000000L;
                break;
            }
            case BILLBOARD_BACKGROUNDCENTER: {
                result = gElementId | 0X0D00000000000000L;
                break;
            }
            case BILLBOARD_BACKGROUNDBOTTOM: {
                result = gElementId | 0X0E00000000000000L;
                break;
            }
            default: {
                throw new RuntimeException("Don't support type now" + type);
            }
        }
        gElementId ++ ;
        return result;
    }

    public static void updateRootContent(IScene scene, ContentAttributeEnty enty) {
        GlElement element = scene.rootElement();
        if (ContentAttributeEnty.eIMAGE_CONTENT == enty.mEntyType &&
            (null == element || !(element instanceof SphereShapeElement))) {
            ShapeAttributeEnty.SphereEnty shape = new ShapeAttributeEnty.SphereEnty();
            shape.mRadius = 9.3f;
            ContentAttributeEnty.ImageEnty content = (ContentAttributeEnty.ImageEnty) enty;
            SphereShapeElement sphereShapeElement = new SphereShapeElement(shape, content);
            sphereShapeElement.setRootElement();
            scene.addElement(sphereShapeElement);
            return;
        }

        if (ContentAttributeEnty.eSKEYBOXIMAGE_CONTENT == enty.mEntyType &&
            (null == element || !(element instanceof SkeyboxShapeElement))) {
            ShapeAttributeEnty.SkeyBoxEnty shape = new ShapeAttributeEnty.SkeyBoxEnty();
            shape.mEdgeSize = 5.3f;
            ContentAttributeEnty.SkeyboxImageEnty content = (SkeyboxImageEnty) enty;
            SkeyboxShapeElement skeyboxShapeElement = new SkeyboxShapeElement(shape, content);
            skeyboxShapeElement.setRootElement();
            scene.addElement(skeyboxShapeElement);
            return;
        }

        assert (null != element);
        if (element instanceof SphereShapeElement) {
            SphereShapeElement sphereShapeElement = (SphereShapeElement) element;
            ContentAttributeEnty.ImageEnty imageEnty = (ContentAttributeEnty.ImageEnty) enty;
            sphereShapeElement.update(imageEnty);
            sphereShapeElement.finishUpdate();
        } else if (element instanceof SkeyboxShapeElement) {
            SkeyboxShapeElement skeyboxShapeElement = (SkeyboxShapeElement) element;
            ContentAttributeEnty.SkeyboxImageEnty imageEnty = (ContentAttributeEnty.SkeyboxImageEnty) enty;
            skeyboxShapeElement.update(imageEnty);
            skeyboxShapeElement.finishUpdate();
        } else {
            throw new RuntimeException();
        }
    }
}
