package com.yapa.spacev2;

import com.yapa.space.IPackage;

public abstract class ContentAttributeEnty extends GlAttribute.AttributeEnty {

    /**
     * 
     */
    private static final long serialVersionUID = 6842661981136106964L;
    public static final int eIMAGE_CONTENT = GlAttribute.eCONTENTENTY_BEGIN;
    public static final int eSKEYBOXIMAGE_CONTENT = eIMAGE_CONTENT + 1;

    public ContentAttributeEnty(int type) {
        super(type);
    }

    public static class ImageEnty extends ContentAttributeEnty {
        public static final int SPHERECONTENT = -1;
        /**
         * 
         */
        private static final long serialVersionUID = 2810548803541743798L;
        public Resource mResource;

        public ImageEnty() {
            super(eIMAGE_CONTENT);
            mResource = new Resource();
        }

        public ImageEnty(Resource resource) {
            super(eIMAGE_CONTENT);
            mResource = resource;
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mResource.writeToPackage(pck, flage);
        }
    }

    public static class SkeyboxImageEnty extends ContentAttributeEnty {
        /**
         * 
         */
        private static final long serialVersionUID = -4341674328325761022L;

        public Resource mResource;

        public static final int SKEYBOX_HORIZONTAL = 0;
        public static final int SKEYBOX_VERTICAL = 1;
        public static final int SKEYBOX_TILE = 2;

        public static final int POSITION_LEFT = 0;
        public static final int POSITION_FRONT = 1;
        public static final int POSITION_RIGHT = 2;
        public static final int POSITION_BACK = 3;
        public static final int POSITION_TOP = 4;
        public static final int POSITION_BOTTOM = 5;

        public static final int SKEYBOX_POSITIONTYPE = 0;
        public static final int SKEYBOX_LEFT = 1;
        public static final int SKEYBOX_FRONT = 2;
        public static final int SKEYBOX_RIGHT = 3;
        public static final int SKEYBOX_BACK = 4;
        public static final int SKEYBOX_TOP = 5;
        public static final int SKEYBOX_BOTTOM = 6;
        public static final int SKEYBOX_MAXPOSITION = 7;

        public static final int SKEYBOX_POSITION_TILEROW = SKEYBOX_LEFT;
        public static final int SKEYBOX_POSTIION_TILECOL = SKEYBOX_FRONT;

        public int mPosition[] = {
                SKEYBOX_HORIZONTAL,
                POSITION_LEFT,
                POSITION_FRONT,
                POSITION_RIGHT,
                POSITION_BACK,
                POSITION_TOP,
                POSITION_BOTTOM};

        public SkeyboxImageEnty() {
            super(eSKEYBOXIMAGE_CONTENT);
            mResource = new Resource();
        }

        public SkeyboxImageEnty(Resource resource) {
            super(eSKEYBOXIMAGE_CONTENT);
            mResource = resource;
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mResource.writeToPackage(pck, flage);
            pck.writeArray(mPosition);
        }
    }
}
