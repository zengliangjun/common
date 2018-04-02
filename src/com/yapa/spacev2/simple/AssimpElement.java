package com.yapa.spacev2.simple;

import com.yapa.space.IPackage;
import com.yapa.spacev2.GlAttribute;
import com.yapa.spacev2.GlElement;
import com.yapa.spacev2.ShapeAttributeEnty;

public class AssimpElement extends GlElement {

    public static class AssimpAttribute extends GlAttribute {
        public ShapeAttributeEnty.EntyAssimp mShape;

        public AssimpAttribute() {
            super(eSIMPLEASSIMP_ATTRIBUTE);
            mShape = new ShapeAttributeEnty.EntyAssimp();
        }

        public AssimpAttribute(ShapeAttributeEnty.EntyAssimp shape) {
            super(eSIMPLEASSIMP_ATTRIBUTE);
            mShape = shape;
        }

        public void writeToPackage(IPackage pck, int flage) {
            super.writeToPackage(pck, flage);
            mShape.writeToPackage(pck, flage);
        }
    }

    public AssimpAttribute mAttribute;

    public AssimpElement() {
        super();
        mAttribute = new AssimpAttribute();
    }

    @Override
    public AssimpAttribute attribute() {
        return mAttribute;
    }

}
