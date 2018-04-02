package com.yapa.spacev2;

import com.yapa.space.IPackage;

public abstract class PostionAttributeEnty extends GlAttribute.AttributeEnty {

    public static final int eMOVE_POSTION = GlAttribute.ePOSTIONENTY_BEGIN;
    public static final int eROTATE_POSTION = eMOVE_POSTION + 1;
    public static final int eSCALE_POSTION = eROTATE_POSTION + 1;

    public static final int eMOVELOCAL_POSTION = eSCALE_POSTION + 1;
    public static final int eROTATELOCAL_POSTION = eMOVELOCAL_POSTION + 1;
    public static final int eSCALELOCAL_POSTION = eROTATELOCAL_POSTION + 1;

    public PostionAttributeEnty(int type) {
        super(type);
    }
    
    public static class MoveEnty extends PostionAttributeEnty {
        public float mDistance[] = new float[] { 0f, 0f, 0f };

        public MoveEnty(int type) {
            super(type);
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mDistance);
        }
    };

    public static class RotateEnty extends PostionAttributeEnty {
        public float mAngle;
        public float mAxis[];
        public float mCenter[];

        public RotateEnty(int type) {
            super(type);
            mAngle = 0.f;
            mAxis = new float[] {1f, 1f, 1f};
            mCenter = new float[] {0f, 0f, 0f};
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            float value[] = new float[] {mAngle,
                    mAxis[0], mAxis[1], mAxis[2],
                    mCenter[0], mCenter[1], mCenter[2]};

            pck.writeArray(value);
        }
    };

    public static class ScaleEnty extends PostionAttributeEnty {
        public float mScale[];

        public ScaleEnty(int type) {
            super(type);
            mScale = new float[] {1f, 1f, 1f};
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            pck.writeArray(mScale);
        }
    };
    
}
