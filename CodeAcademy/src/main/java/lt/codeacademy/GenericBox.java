package lt.codeacademy;

import java.util.ArrayList;
import java.util.List;

public abstract class  GenericBox<T> implements ListBox<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void addElements(T[] values) {
        list.addAll(List.of(values));
    }

    @Override
    public void addElement(T value) {
        list.add(value);
    }

    @Override
    public List<T> getElements() {
        return list;
    }
}
