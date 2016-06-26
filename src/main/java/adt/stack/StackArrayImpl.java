package adt.stack;

public class StackArrayImpl<E> {

	Object[] stack;
	Integer top;
	Integer capacity;

	public StackArrayImpl() {
		capacity = 10;
		stack = new Object[capacity];
		top = -1;
	}

	public StackArrayImpl(int size) {
		capacity = size;
		stack = new Object[capacity];
		top = -1;
	}

	public E push(E item) {
		add(item);
		return item;
	}

	public Object pop() {
		return remove();
	}

	public Integer size() {
		return top + 1;
	}

	public Integer capacity() {
		return capacity;
	}

	public Boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public String toString() {
		StringBuilder stackElement = new StringBuilder();

		if (top < 0) {
			return "[]";
		}
		stackElement.append("[ ");
		for (int index = 0; index <= top; index++) {
			stackElement.append(stack[index]);
			if (index != top) {
				stackElement.append(", ");
			}
		}
		stackElement.append(" ]");
		return stackElement.toString();
	}

	public Object peek() {
		return stack[top];
	}

	private void add(E item) {

		if (!((top + 1) == capacity)) {
			stack[++top] = item;
		} else {
			System.out.println("Stack Overflow!! for item : " + item);
		}
	}

	private Object remove() {

		if (top < 0) {
			System.out.println("Stack Underflow!!");
			return null;
		}
		Object item = stack[top];
		stack[top] = null;
		top--;
		return item;
	}

	public static void main(String[] args) {

		StackArrayImpl<String> stackArray = new StackArrayImpl<String>();
		System.out.println("Stack size : " + stackArray.size());
		System.out.println("Stack capacity : " + stackArray.capacity());

		for (int index = 1; index <= 5; index++) {
			stackArray.push("S" + index);
		}
		System.out.println(stackArray);
		for (int index = 1; index <= 6; index++) {
			stackArray.push("S" + index);
		}
		System.out.println(stackArray);
		stackArray.pop();
		System.out.println(stackArray);
		System.out.println("Stack size : " + stackArray.size());
		System.out.println("Empty : " + stackArray.isEmpty());
		for (; stackArray.size() > 0;) {
			stackArray.pop();
		}
		System.out.println(stackArray);
		System.out.println("Empty : " + stackArray.isEmpty());

	}
}
