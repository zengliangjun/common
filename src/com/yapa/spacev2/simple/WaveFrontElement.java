package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.ContentAttributeEnty;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;

public class WaveFrontElement extends GlElement {

    public static class WaveFrontAttribute extends GlAttribute {
        public ShapeAttributeEnty.ResourceEnty mShape;
        public ContentAttributeEnty.ImageEnty mContent;

        public WaveFrontAttribute() {
            super(eSIMPLEWAVEFRONT_ELEMENT);
            mShape = new ShapeAttributeEnty.ResourceEnty();
            mContent = new ContentAttributeEnty.ImageEnty();
        }

        public WaveFrontAttribute(ShapeAttributeEnty.ResourceEnty shape, ContentAttributeEnty.ImageEnty content) {
            super(eSIMPLEWAVEFRONT_ELEMENT);
            mShape = shape;
            mContent = content;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mShape.writeToPackage(pck, flage);
            mContent.writeToPackage(pck, flage);
        }
    }

    public WaveFrontAttribute mAttribute;

    public WaveFrontElement() {
        super();
        mAttribute = new WaveFrontAttribute();
    }

    @Override
    public WaveFrontAttribute attribute() {
        return mAttribute;
    }

}
