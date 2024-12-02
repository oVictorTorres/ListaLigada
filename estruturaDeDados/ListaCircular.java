package estruturaDeDados;

public class ListaCircular {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListaCircular() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insereInicio(int valor) {
        Node newNode = new Node(valor);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public boolean buscaElemento(int valor) {
        if (size == 0) return false;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == valor) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Object buscaIndice(int indice) {
        if (size == 0) {
            throw new IndexOutOfBoundsException("A lista está vazia.");
        }
        int index = indice % size;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void insereFim(int valor) {
        Node newNode = new Node(valor);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void removeInicio() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void removeFim() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
        size--;
    }

    public void removeIndice(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        if (indice == 0) {
            removeInicio();
        } else if (indice == size - 1) {
            removeFim();
        } else {
            Node current = head;
            for (int i = 0; i < indice - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public void insereElementoPosicao(int valor, int indice) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        if (indice == 0) {
            insereInicio(valor);
        } else if (indice == size) {
            insereFim(valor);
        } else {
            Node newNode = new Node(valor);
            Node current = head;
            for (int i = 0; i < indice - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
}
