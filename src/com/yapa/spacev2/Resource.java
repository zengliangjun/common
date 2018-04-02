package com.yapa.spacev2;

import java.io.Serializable;

import com.yapa.space.IPackage;

public class Resource implements IPackage.IPackageable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 674551027178736462L;
	public static final int RESOURCE_ASSET = 0;
    public static final int RESOURCE_SDCARD = RESOURCE_ASSET + 1;
    public static final int RESOURCE_SYSTEMMEDIA = RESOURCE_SDCARD + 1;

    public int mPathType;
    public String mPath;

    public Resource() {
        mPathType = RESOURCE_ASSET;
    }

    public Resource(int pathType, String path) {
        mPathType = pathType;
        mPath = path;
    }

    public void writeToPackage(IPackage pck, int flage) {
        pck.write(mPathType);
        pck.write(mPath);
    }

}
