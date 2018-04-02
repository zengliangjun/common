package com.yapa.spacev2;

import java.io.Serializable;

import com.yapa.space.IPackage;

public abstract class GlAttribute implements IPackage.IPackageable {

    public static final int eNONE_ELEMENT = 0;
    public static final int ePOINTLIGHT_ATTRIBUTE = eNONE_ELEMENT + 1;
    public static final int eDIRECTLIGHT_ATTRIBUTE = ePOINTLIGHT_ATTRIBUTE + 1;

    public static final int eSIMPLEELEMENTBEGIN = 100;
    //
    public static final int eSIMPLEBILLBOARD_ELEMENT = eSIMPLEELEMENTBEGIN;
    public static final int eSIMPLESPHERE_ATTRIBUTE = eSIMPLEBILLBOARD_ELEMENT + 1;
    public static final int eSIMPLESKEYBOX_ATTRIBUTE = eSIMPLESPHERE_ATTRIBUTE + 1;
    public static final int eSIMPLEWAVEFRONT_ELEMENT = eSIMPLESKEYBOX_ATTRIBUTE + 1;
    public static final int eSIMPLEASSIMP_ATTRIBUTE = eSIMPLEWAVEFRONT_ELEMENT + 1;

    public static final int eSIMPLEELEMENTEND = 100;

    public int mElementType = eNONE_ELEMENT;

    public GlAttribute(int type) {
        mElementType = type;
    }

    @Override
    public void writeToPackage(IPackage pck, int flage) {
        pck.write(mElementType);
    }

    /********************************************/
    public static final int eSHAPEENTY_BEGIN = 0;
    public static final int eSHAPEENTY_END = 0xFFFF;

    public static final int eCONTENTENTY_BEGIN = eSHAPEENTY_END + 1;
    public static final int eCONTENTENTY_END = 0x1FFFF;

    public static final int ePOSTIONENTY_BEGIN = eCONTENTENTY_END + 1;
    public static final int ePOSTIONENTY_END = 0x2FFFF;

    public static final int eEFECTENTY_BEGIN = ePOSTIONENTY_END + 1;
    public static final int eEFECTENTY_END = 0x3FFFF;

    public static abstract class AttributeEnty implements IPackage.IPackageable, Serializable {
    /**
 * 
 */
private static final long serialVersionUID = 8948306359594654588L;

public int mEntyType;

        AttributeEnty(int type) {
            mEntyType = type;
        }

        @Override
        public void writeToPackage(IPackage pck, int flage) {
            pck.write(mEntyType);
        }
    }

}
