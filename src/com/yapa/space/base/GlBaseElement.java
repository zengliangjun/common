package com.yapa.space.base;

import com.yapa.base.SpaceUtils;
import com.yapa.spacev2.GlElement;

public class GlBaseElement {

    protected long mElementId;
    protected GlScene mScene;

    public GlBaseElement() {
        mElementId = SpaceUtils.idGenerater();
    }

    protected GlScene getSceneInner() {
        return mScene;
    }

    protected void setScene(GlScene scene) {
        this.mScene = scene;
    }

    protected void addElementInner(GlElement element) {
        if (mScene != null) {
            mScene.addElementOnly(element);
        }
    }

    public void removeInner(GlElement  element) {
        if (mScene != null) {
            mScene.removeElementOnly(element);
        }
    }

    public void setRootElement() {
        mElementId |= SpaceUtils.ELEMENTROOT_ELEMENT;
    }

    public boolean isRootElement() {
        return SpaceUtils.ELEMENTROOT_ELEMENT == (mElementId & SpaceUtils.ELEMENTROOT_MASK);
    }
}
