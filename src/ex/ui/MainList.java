package ex.ui;

import ex.obj.subscriptions.VkSource;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainList extends VBox {

    private int size;

    public MainList() {

        setPrefWidth(410);
    }

    public void add(Object item) {

        assert item != null;
        this.getChildren().add((Node) item);
        size++;
    }

    public void addAll(List<VkSource> sourceList) {
        this.clear();
        this.add(sourceList);
    }

    public void remove(int i) {

        assert (i > 0 && i < getSize());
    }

    public void remove(VkSource source) {

    }

    public void clear() {
        getChildren().clear();
        size = 0;
    }

    public VkSource get(int i) {


        return null;
    }

    public List<VkSource> getAll() {


        return null;
    }

    public int getSize() {
        return size;
    }
}
