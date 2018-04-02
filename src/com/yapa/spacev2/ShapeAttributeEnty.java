package com.yapa.spacev2;

import com.yapa.space.IPackage;
import com.yapa.spacev2.GlAttribute;

public abstract class ShapeAttributeEnty extends GlAttribute.AttributeEnty {

    public static final int eREGULARPOLYGON_SHAPE = GlAttribute.eSHAPEENTY_BEGIN;
    public static final int eSPHERE_SHAPE = eREGULARPOLYGON_SHAPE + 1;
    public static final int eSKEYBOX_SHAPE = eSPHERE_SHAPE + 1;
    public static final int eRESOURCE_SHAPE = eSKEYBOX_SHAPE + 1;
    public static final int eASSIMP_SHAPE = eRESOURCE_SHAPE + 1;

    public ShapeAttributeEnty(int type) {
        super(type);
    }

    public static class RegularPolygonEnty extends ShapeAttributeEnty {

        public float mCenter[];
        public float mRadius;
        public int mEdgeCount;
        public boolean mInner;

        public RegularPolygonEnty() {
            super(eREGULARPOLYGON_SHAPE);
            mCenter = new float[3];
            mRadius = (1.0f);
            mEdgeCount = (3);
            mInner = (true);

            mCenter[0] =  0.f;
            mCenter[1] =  0.f;
            mCenter[2] = -1.f;
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mCenter);
            pck.write(mRadius);
            pck.write(mEdgeCount);
            pck.write(mInner);
        }
    }

    public static class SphereEnty extends ShapeAttributeEnty {

        public float mCenter[];
        public float mRadius;
        public int mLatitude;
        public int mLongitude;

        public SphereEnty() {
            super(eSPHERE_SHAPE);
            mCenter = new float[3];

            mCenter[0] =  0.f;
            mCenter[1] =  0.f;
            mCenter[2] = -1.f;
            mRadius = (1.0f);
            mLatitude = (21);
            mLongitude = (41);
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mCenter);
            pck.write(mRadius);
            pck.write(mLatitude);
            pck.write(mLongitude);
        }
    }

    public static class SkeyBoxEnty extends ShapeAttributeEnty {

        public float mCenter[];
        public float mEdgeSize;

        public SkeyBoxEnty() {
            super(eSKEYBOX_SHAPE);
            mCenter = new float[3];

            mCenter[0] =  0.f;
            mCenter[1] =  0.f;
            mCenter[2] =  0.f;
            mEdgeSize = (1.0f);
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            float att[] = new float[4];
            att[0] =  mCenter[0];
            att[1] =  mCenter[1];
            att[2] =  mCenter[2];
            att[3] =  mEdgeSize;
            pck.writeArray(att);
        }
    }

    public static class ResourceEnty extends ShapeAttributeEnty {
        public float mCenter[];
        public Resource mResource;

        public ResourceEnty() {
            super(eRESOURCE_SHAPE);
            mCenter = new float[3];

            mCenter[0] =  0.f;
            mCenter[1] =  0.f;
            mCenter[2] = -1.f;
            mResource = new Resource();
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mCenter);
            mResource.writeToPackage(pck, flage);
        }
    }

    public static class EntyAssimp extends ShapeAttributeEnty {
        public float mCenter[];
        public Resource mResource;

        public EntyAssimp() {
            super(eASSIMP_SHAPE);
            mCenter = new float[3];

            mCenter[0] =  0.f;
            mCenter[1] =  0.f;
            mCenter[2] = -1.f;
            mResource = new Resource();
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mCenter);
            mResource.writeToPackage(pck, flage);
        }
    }

}
