package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (parentNode.isPresent() && childNode.isEmpty()) {
            parentNode.get().children.add(new Node<E>(child));
            rsl = true;
        }

        return rsl;

    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean rsl = false;
        E value;
        if (findByPredicate()) {
            rsl = true;
        }
        return rsl;
    }

    private Optional<Node> findByPredicate(Predicate<Node<E>> condition) {
        E value = new Node<>();

        findBy()
       if()
    return
    }

   /* public Iterator<Node<E>> iterator() {
        return new Iterator<Node<E>>() {
            Node<E> a = new Node<>();
            @Override
            public boolean hasNext() {
                if(Node<E>)
                return false;
            }

            @Override
            public Node<E> next() {
                return null;
            }
        };
    }*/
}
