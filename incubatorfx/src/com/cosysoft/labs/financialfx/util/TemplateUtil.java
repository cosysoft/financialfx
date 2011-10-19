package com.cosysoft.labs.financialfx.util;

import com.cosysoft.labs.financialfx.template.BaseTree;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javax.xml.bind.JAXBException;

public class TemplateUtil {

    public static void copyMenu(BaseTree baseTree) {
    }

    public static TreeItem<BaseTree> buildTreeItem4XML(String xmlPath) {
        BaseTree baseTree =null;
        try {
            baseTree = JAXBUtil.XML2Bean(BaseTree.class, xmlPath);
        } catch (JAXBException ex) {
            Logger.getLogger(TemplateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buildTreeItem(baseTree);
    }

    public static TreeItem<BaseTree> buildTreeItem(BaseTree baseTree) {
        return new TreeItem<BaseTree>(baseTree) {

            private boolean isFirstTimeChildren = true;

            @Override
            public ObservableList<TreeItem<BaseTree>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                return CollectionUtil.isEmpty(getValue().getChildren());
            }

            private ObservableList<TreeItem<BaseTree>> buildChildren(TreeItem<BaseTree> TreeItem) {
                BaseTree f = TreeItem.getValue();
                if (!CollectionUtil.isEmpty(f.getChildren())) {
                    ObservableList<TreeItem<BaseTree>> children = FXCollections.observableArrayList();
                    for (BaseTree childFile : f.getChildren()) {
                        children.add(buildTreeItem(childFile));
                    }
                    return children;
                }

                return FXCollections.emptyObservableList();
            }
        };
    }
}
