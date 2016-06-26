package adt.queue;

public class QueueArrayImpl<E> {

    Object[] queue;
    Integer capacity;
    Integer front;
    Integer rear;

    public QueueArrayImpl() {
        front = 0;
        rear = -1;
        capacity = 10;
        queue = new Object[capacity];
    }

    public E push(E item) {

        if (rear == capacity - 1) {
            System.out.println("Queue Overflow!!");
            return null;
        }
        add(item);
        return item;
    }

    public Integer size() {
        return (rear - front);
    }

    private void add(E item) {
        if (item != null) {
            queue[++rear] = item;
        }
    }

    public Object remove() {
        Object item = null;

        if (-1 == this.rear) {
            System.out.println("Queue Underflow!!");
        } else {
            item = queue[front];
            queue[front] = null;
            front++;
        }

        return item;
    }

    public Integer capacity() {
        return this.capacity;
    }

    public Boolean isEmpty() {
        Boolean isEmpty = false;
        if (-1 == this.rear) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static void main(String[] args) {

        QueueArrayImpl<String> queueArray = new QueueArrayImpl<String>();
        System.out.println("Queue size : " + queueArray.size());
        System.out.println("Queue capacity : " + queueArray.capacity());

/*		for (int index = 1; index <= 5; index++) {
            queueArray.add("S" + index);
		}
		System.out.println(queueArray);
		for (int index = 1; index <= 6; index++) {
			queueArray.add("S" + index);
		}
		System.out.println(queueArray);
		queueArray.remove();
		System.out.println(queueArray);
		System.out.println("Queue size : " + queueArray.size());
		System.out.println("Empty : " + queueArray.isEmpty());
		for (; queueArray.size() > 0;) {
			queueArray.remove();
		}
		System.out.println(queueArray);
		System.out.println("Empty : " + queueArray.isEmpty());*/

    }
}
