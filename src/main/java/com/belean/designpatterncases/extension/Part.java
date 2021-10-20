package com.belean.designpatterncases.extension;

import java.util.HashMap;

/**
 * @author belean
 * @date 2021/10/20
 */
public abstract class Part {

    private HashMap extensions = new HashMap();

    public abstract String getPartNumber();
    public abstract String getDescription();

    public void addExtension(String extensionType, PartExtension extension) {
        extensions.put(extensionType, extension);
    }

    public PartExtension getExtension(String extensionType) {
        Object o = extensions.get(extensionType);
        if(o == null) {
            return new BadPartExtension();
        }
        return (PartExtension) o;
    }

}
