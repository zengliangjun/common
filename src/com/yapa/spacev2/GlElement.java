package com.yapa.spacev2;

import java.util.HashMap;
import java.util.Iterator;

import com.yapa.space.IPackage;
import com.yapa.space.api.IScene;
import com.yapa.space.base.GlBaseElement;

import android.support.v4.util.ArrayMap;
import android.util.Log;

public abstract class GlElement extends GlBaseElement implements IPackage.IPackageable {

    public static final int ELEMENTID_ONLY = 0;
    public static final int ELEMENT_FULL = 1;

    public static final long ELEMENT_NONEPARENT_ID = -1;
    private static final String TAG = "GlElement";

    protected long mParentId = ELEMENT_NONEPARENT_ID;
    protected ArrayMap<Long, GlElement> mSubElements = new ArrayMap<Long, GlElement>();

    protected IPackage mPackage;

    public IScene getScene() {
        return super.getSceneInner();
    }

    public void addElement(GlElement element) {
        element.setParentId(mElementId);
        mSubElements.put(element.elementId(), element);
        addElementInner(element);
    }

    public void startUpdate() {
        assert null != mScene;
        if (null == mPackage) {
            mPackage = getScene().startUpdate(this);
        } else {
            Log.w(TAG, "you had startUpdate");
        }
    }

    public void update(GlAttribute.AttributeEnty enty) {
        assert null != mScene;
        if (null == mPackage)
            startUpdate();

        if (null == mPackage) {
            Log.w(TAG, "there are no update");
            return;
        }
        enty.writeToPackage(mPackage, ELEMENT_FULL);
    }

    public void finishUpdate() {
        assert null != mScene;
        if (null == mPackage) {
            Log.w(TAG, "there are no update");
            return;
        }
        getScene().finishUpdate(mPackage);
        mPackage = null;
    }

    public void remove(GlElement  element) {
        mSubElements.remove(element.elementId());
        removeInner(element);
    }

    public void remove(long id) {
        GlElement  element = valueFor(id);
        remove(element);
    }

    public abstract GlAttribute attribute();

    public long elementId() { return mElementId; }
    public long parentId() { return mParentId; }

    public void setParentId(long parentId) { mParentId = parentId; }

    public int size() { return mSubElements.size(); }
    public GlElement valueFor(long id) { return mSubElements.get(id); }
    public GlElement valueAt(int index) { return mSubElements.valueAt(index); }
    public Iterator<HashMap.Entry<Long, GlElement>> iterator() {
        return mSubElements.entrySet().iterator();
    }

/*
    @Override
    public void writeToParcel(Parcel parcel, int arg1) {
        parcel.writeLong(mElementId);
        parcel.writeLong(mParentId);

        if (ELEMENTID_ONLY == arg1)
            return;

        GlAttribute attribute = attribute();
        attribute.writeToParcel(parcel, arg1);

        parcel.writeInt(size());

        Iterator<HashMap.Entry<Long, GlElement>> iterator = iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Long, GlElement> entry = iterator.next();
            entry.getValue().writeToParcel(parcel, arg1);
        }

    }
*/
    @Override
    public void writeToPackage(IPackage pck, int flag) {
        pck.write(mElementId);
        pck.write(mParentId);

        if (ELEMENTID_ONLY == flag)
            return;

        GlAttribute attribute = attribute();

        attribute.writeToPackage(pck, flag);

        pck.write(size());

        Iterator<HashMap.Entry<Long, GlElement>> iterator = iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Long, GlElement> entry = iterator.next();
            entry.getValue().writeToPackage(pck, flag);
        }
    }
}
