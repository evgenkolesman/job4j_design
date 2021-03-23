package ru.job4j.tree;

import java.util.*;

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
        Node<E> child1 = new Node<>(child);
        Node<E> parent1 = new Node<>(parent);
        if (parentNode.isPresent() && childNode.isEmpty()) {
            parent1.children.add(child1);
            root.children.add(parent1);
            return rsl = true;
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
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!rsl.isEmpty()) {
            root.children.iterator(); // на до подумать или через итереатор
            // или сделать  условие в findByPredicate и проверить по нему,
            // можно кстати проверять итератором на условие conditions...
        }

        return false;
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
