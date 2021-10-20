package com.belean.designmodecases.extension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author belean
 * @date 2021/10/19
 */
public class Element {

    private String name;
    private String text;
    private List<Element> contents = new ArrayList<>();

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Element getChild(String tag) {
        return contents.stream().filter(e -> tag.equals(e.getName())).collect(Collectors.toList()).get(0);
    }

    public String getTextTrim() {
        return this.text.trim();
    }

    public List getChildren() {
        return this.contents;
    }

    public Element setText(String text) {
        this.text = text;
        return this;
    }

    public void addContent(Element e) {
        contents.add(e);
    }
}
