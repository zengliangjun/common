package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.ContentAttributeEnty;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;

public class SkeyboxShapeElement extends GlElement {

    public static class SkeyboxShapeAttribute extends GlAttribute {
        public ShapeAttributeEnty.SkeyBoxEnty mShape;
        public ContentAttributeEnty.SkeyboxImageEnty mContent;
        public SkeyboxShapeAttribute() {
            super(eSIMPLESKEYBOX_ATTRIBUTE);
            mShape = new ShapeAttributeEnty.SkeyBoxEnty();
            mContent = new ContentAttributeEnty.SkeyboxImageEnty();
        }

        public SkeyboxShapeAttribute(ShapeAttributeEnty.SkeyBoxEnty shape, ContentAttributeEnty.SkeyboxImageEnty content) {
            super(eSIMPLESKEYBOX_ATTRIBUTE);
            mShape = shape;
            mContent = content;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mShape.writeToPackage(pck, flage);
            mContent.writeToPackage(pck, flage);
        }
    }
    public SkeyboxShapeAttribute mAttribute;

    public SkeyboxShapeElement() {
        super();
        mAttribute = new SkeyboxShapeAttribute();
    }

    public SkeyboxShapeElement(ShapeAttributeEnty.SkeyBoxEnty shape, ContentAttributeEnty.SkeyboxImageEnty content) {
        super();
        mAttribute = new SkeyboxShapeAttribute(shape, content);
    }

    @Override
    public SkeyboxShapeAttribute attribute() {
        return mAttribute;
    }

}
