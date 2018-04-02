package com.yapa.space.api;

import java.util.HashMap;
import java.util.Iterator;

import com.yapa.space.IPackage;
import com.yapa.spacev2.GlElement;

public interface IScene {

    public interface ISceneObserver {
        void onAddElement(GlElement element);
        void onRemoveElement(GlElement element);
        IPackage onBeginUpdate(GlElement element);
        boolean onEndUpdate(IPackage pck);
    }

    public void addElement(GlElement element);
    public IPackage startUpdate(GlElement element);
    public void finishUpdate(IPackage pck);

    public void remove(GlElement element);
    public void remove(Long id);
    public int size();
    public GlElement rootElement();
    public GlElement valueFor(long id);
    public GlElement valueAt(int index);
    public Iterator<HashMap.Entry<Long, GlElement>> iterator();

    public int subSize();
    public GlElement subValueFor(long id);
    public GlElement subValueAt(int index);
    public Iterator<HashMap.Entry<Long, GlElement>> subIterator();

}
