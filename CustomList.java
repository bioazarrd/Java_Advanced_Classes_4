package JavaAdvancedLecture6.ExProblem9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomList<E extends Comparable<E>> implements Iterable<E>{
    private List<E> list;
    public int size;


    public CustomList() {
        this.list = new ArrayList<>();
    }


    public E get(int index) {
        if (isNotRange(index)) {
            System.out.println("Index is not valid!");
            return null;
        }
        return this.list.get(index);
    }


    public void add(E element) {
        this.size++;
        list.add(element);
    }



    public E remove(int index) {
        if (isNotRange(index)) {
            return null;
        }
        this.size--;
        return list.remove(index);
    }


    public boolean contains(E element) {
        return this.list.contains(element);
    }


    public void swap(int firstIndex, int secondIndex) {
        if (isNotRange(firstIndex) || isNotRange(secondIndex)) {
            System.out.println("FirstIndex/SecondIndex is not a valid index!");
        } else {
            E first = this.list.get(firstIndex);
            E second = this.list.get(secondIndex);

            list.set(firstIndex, second);
            list.set(secondIndex, first);

        }
    }


    public int countGreaterThen (E element) {
        int count = 0;

        for (E e : list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        E max = this.list.get(0);
        for (E current : list) {
            if (current.compareTo(max) > 0) {     //> 0 защото ако първото число е по-голямото от второто - ще върне 1;
                max = current;
            }
        }
        return max;
    }

    public E getMin() {
        E min = this.list.get(0);
        for (E current : list) {
        if (current.compareTo(min) < 0) {         //< 0 защото ако първото число е по-голямото от второто - ще върне -1;
                min = current;
            }
        }
        return min;
    }

    private boolean isNotRange ( int index) {
        return index < 0 || index >= this.list.size();
    }




    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;          //добавяме го този ред
            @Override
            public boolean hasNext() {
                if (index < 0 || index >= list.size()) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {

                return list.get(index++);        //дописваме след РЕТЪРН.....
            }
        };
    }
}
