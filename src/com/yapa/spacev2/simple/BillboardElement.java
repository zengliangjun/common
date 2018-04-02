package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.ContentAttributeEnty;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;

public class BillboardElement extends GlElement {

    public static class BillboardAttribute extends GlAttribute {
        public ShapeAttributeEnty.RegularPolygonEnty mShape;
        public ContentAttributeEnty.ImageEnty mContent;

        public BillboardAttribute() {
            super(eSIMPLEBILLBOARD_ELEMENT);
            mShape = new ShapeAttributeEnty.RegularPolygonEnty();
            mContent = new ContentAttributeEnty.ImageEnty();
        }

        public BillboardAttribute(ShapeAttributeEnty.RegularPolygonEnty shape, ContentAttributeEnty.ImageEnty content) {
            super(eSIMPLEBILLBOARD_ELEMENT);
            mShape = shape;
            mContent = content;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mShape.writeToPackage(pck, flage);
            mContent.writeToPackage(pck, flage);
        }
    }

    public BillboardAttribute mAttribute;

    public BillboardElement() {
        super();
        mAttribute = new BillboardAttribute();
    }

    public BillboardElement(ShapeAttributeEnty.RegularPolygonEnty shape, ContentAttributeEnty.ImageEnty content) {
        super();
        mAttribute = new BillboardAttribute(shape, content);
    }

    @Override
    public BillboardAttribute attribute() {
        return mAttribute;
    }

}
