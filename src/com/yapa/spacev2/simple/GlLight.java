package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;

public class GlLight extends GlElement {

    public static final int ePOINTLIGHT_ATTRIBUTE = GlAttribute.ePOINTLIGHT_ATTRIBUTE;
    public static final int eDIRECTLIGHT_ATTRIBUTE = GlAttribute.eDIRECTLIGHT_ATTRIBUTE;

    public static class GlLightAttribute extends GlAttribute {

        public float mDiffuseColour[];
        public float mSpecularColour[];

        public float mPositionOrDirection[];

        public float mShininessFactor;

        public GlLightAttribute() {
            super(ePOINTLIGHT_ATTRIBUTE);
            init();
        }

        public GlLightAttribute(int typ) {
            super(typ);
            init();
        }

        void init() {
            mDiffuseColour = new float[]{1.0f, 1.0f, 1.0f};
            mSpecularColour = new float[]{1.0f, 1.0f, 1.0f};
            mPositionOrDirection = new float[]{0.0f, 20.0f, 10.0f};
            mShininessFactor = 40.0f;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mDiffuseColour);
            pck.writeArray(mSpecularColour);
            pck.writeArray(mPositionOrDirection);
            pck.write(mShininessFactor);
        }
    }

    protected GlLightAttribute mAttribute;

    public GlLight() {
        super();
        mAttribute = new GlLightAttribute();
    }

    public GlLight(int type) {
        super();
        mAttribute = new GlLightAttribute(type);
    }

    public GlLight(GlLightAttribute attribute) {
        super();
        mAttribute = attribute;
    }

    @Override
    public GlLightAttribute attribute() {
        return mAttribute;
    }

}
