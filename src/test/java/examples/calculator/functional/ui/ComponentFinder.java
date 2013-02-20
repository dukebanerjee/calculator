package examples.calculator.functional.ui;

import junit.framework.AssertionFailedError;

import java.awt.*;

public class ComponentFinder {
    private Component root;

    public ComponentFinder(Component root) {
        this.root = root;
    }

    public <T> T findComponentByLabel(Class<T> componentClass, String name) {
        T component = findComponentByLabel(root, componentClass, name);
        if(component == null) {
            throw new AssertionFailedError("Componenent named '" + name + "' not found");
        }
        return component;
    }

    @SuppressWarnings("unchecked")
    private <T> T findComponentByLabel(Component parent, Class<T> componentClass, String name) {
        if(componentClass.isInstance(parent) && name.equals(parent.getName())) {
            return (T) parent;
        }
        for(Component child : ((Container) parent).getComponents()) {
            T foundComponent = findComponentByLabel(child, componentClass, name);
            if(foundComponent != null) {
                return foundComponent;
            }
        }
        return null;
    }
}
