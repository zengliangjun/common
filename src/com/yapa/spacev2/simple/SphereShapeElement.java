package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.ContentAttributeEnty;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;

public class SphereShapeElement extends GlElement {

    public static class SphereShapeAttribute extends GlAttribute {
        public ShapeAttributeEnty.SphereEnty mShape;
        public ContentAttributeEnty.ImageEnty mContent;

        public SphereShapeAttribute() {
            super(eSIMPLESPHERE_ATTRIBUTE);
            mShape = new ShapeAttributeEnty.SphereEnty();
            mContent = new ContentAttributeEnty.ImageEnty();
        }

        public SphereShapeAttribute(ShapeAttributeEnty.SphereEnty shape, ContentAttributeEnty.ImageEnty content) {
            super(eSIMPLESPHERE_ATTRIBUTE);
            mShape = shape;
            mContent = content;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mShape.writeToPackage(pck, flage);
            mContent.writeToPackage(pck, flage);
        }
    }

    public SphereShapeAttribute mAttribute;

    public SphereShapeElement() {
        super();
        mAttribute = new SphereShapeAttribute();
    }

    public SphereShapeElement(ShapeAttributeEnty.SphereEnty shape, ContentAttributeEnty.ImageEnty content) {
        super();
        mAttribute = new SphereShapeAttribute(shape, content);
    }

    @Override
    public SphereShapeAttribute attribute() {
        return mAttribute;
    }

}
