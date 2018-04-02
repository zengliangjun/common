package com.yapa.space.base;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.yapa.space.IPackage;
import com.yapa.space.api.IScene;
import com.yapa.spacev2.GlElement;

import android.support.v4.util.ArrayMap;
import android.util.Log;

public class GlScene implements IScene {

    private static final String TAG = "GlScene";

    protected GlElement mRootElement;

    protected ArrayMap<Long, GlElement> mElements = new ArrayMap<Long, GlElement>();
    protected ArrayMap<Long, GlElement> mSubElements = new ArrayMap<Long, GlElement>();

    private List<IScene.ISceneObserver> mObservers = new ArrayList<IScene.ISceneObserver>();

    protected void addElementOnly(GlElement element) {
        Iterator<HashMap.Entry<Long, GlElement>> iterator = element.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Long, GlElement> entry = iterator.next();
            addElementOnly(entry.getValue());
        }
        for (IScene.ISceneObserver observer: mObservers) {
            observer.onAddElement(element);
        }
        mElements.put(element.elementId(), element);
        element.setScene(this);
    }

    protected void removeElementOnly(GlElement element) {
        Iterator<HashMap.Entry<Long, GlElement>> iterator = element.iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Long, GlElement> entry = iterator.next();
            removeElementOnly(entry.getValue());
        }
        for (IScene.ISceneObserver observer: mObservers) {
            observer.onRemoveElement(element);
        }
        mElements.remove(element.elementId());
        element.setScene(null);
    }

    public void addObserver(ISceneObserver observer) {
        mObservers.add(observer);
    }

    public void removeObserver(ISceneObserver observer) {
        mObservers.remove(observer);
    }

    public void addElement(GlElement element) {
        if (element.isRootElement()) {
            mRootElement = element;
            for (IScene.ISceneObserver observer: mObservers) {
                observer.onAddElement(element);
            }
            element.setScene(this);
            return;
        }

        if (GlElement.ELEMENT_NONEPARENT_ID != element.parentId()) {

            GlElement parent = valueFor(element.parentId());
            if (parent == null) {
                element.setParentId(GlElement.ELEMENT_NONEPARENT_ID);
                // root element
                mSubElements.put(element.elementId(), element);
                addElementOnly(element);
            } else {
                if (parent.valueFor(element.elementId()) == null)
                    parent.addElement(element);
                else {
                    addElementOnly(element);
                }
            }
        } else {
            // root element
            mSubElements.put(element.elementId(), element);
            addElementOnly(element);
        }
    }

    public IPackage startUpdate(GlElement element) {
        for (IScene.ISceneObserver observer: mObservers) {
            IPackage pck = observer.onBeginUpdate(element);
            if (null != pck) {
                return pck;
            }
        }
        return null;
    }

    public void finishUpdate(IPackage pak) {
        for (IScene.ISceneObserver observer: mObservers) {
            if (observer.onEndUpdate(pak))
                return;
        }
    }

    public void remove(GlElement element) {
        if (element.getScene() == null)
            return;

        if (GlElement.ELEMENT_NONEPARENT_ID != element.parentId()) {

            GlElement parent = valueFor(element.parentId());
            if (parent != null) {
                parent.remove(element);
                return;
            }
        }

        mSubElements.remove(element.elementId());
        removeElementOnly(element);
    }

    public void remove(Long id) {
        GlElement element = valueFor(id);
        if (element != null)
            remove(element);
    }

    public int size() { return mElements.size(); }
    public GlElement rootElement() { return mRootElement; }
    public GlElement valueFor(long id) { return mElements.get(id); }
    public GlElement valueAt(int index) {
        return mElements.valueAt(index);
    }
    public Iterator<HashMap.Entry<Long, GlElement>> iterator() {
        return mElements.entrySet().iterator();
    }

    public int subSize() { return mSubElements.size(); }
    public GlElement subValueFor(long id) { return mSubElements.get(id); }
    public GlElement subValueAt(int index) {
        return mSubElements.valueAt(index);
    }
    public Iterator<HashMap.Entry<Long, GlElement>> subIterator() {
        return mSubElements.entrySet().iterator();
    }

}
