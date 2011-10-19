package com.cosysoft.labs.financialfx.template;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wb-yaolantian
 *
 * @param <T>
 */
@XmlRootElement
public class BaseTree implements Serializable {

    private static final long serialVersionUID = -2075034492172345985L;
    private int id;
    private String label;
    private String icon;
    private Class<?> command;
    private int order;
    private List<BaseTree> children;

    public BaseTree() {
    }

    public BaseTree(String label, List<BaseTree> children) {
        this.label = label;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Class<?> getCommand() {
        return command;
    }

    public void setCommand(Class<?> command) {
        this.command = command;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    public List<BaseTree> getChildren() {
        return children;
    }

    public void setChildren(List<BaseTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return label;
    }
}
