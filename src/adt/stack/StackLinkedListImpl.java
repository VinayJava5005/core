package adt.stack;

import java.util.ArrayList;
import java.util.List;

public class StackLinkedListImpl<E> {

	List<E> stack;
	Integer top;

	public StackLinkedListImpl() {
		top = -1;
		stack = new ArrayList<E>();
	}

	public E push(E item) {
		add(item);
		return item;
	}

	public E pop() {
		return remove();
	}

	public Boolean isEmpty() {
		return (top < 0) ? true : false;
	}

	public Integer size() {
		return top + 1;
	}

	@Override
	public String toString() {
		StringBuilder stackElement = new StringBuilder();

		if (top < 0) {
			return "[]";
		}
		stackElement.append("[ ");
		for (int index = 0; index <= top; index++) {
			stackElement.append(stack.get(index));
			if (index != top) {
				stackElement.append(", ");
			}
		}
		stackElement.append(" ]");
		return stackElement.toString();
	}

	public E peek() {
		return stack.get(top);
	}

	private E remove() {
		if (top < 0) {
			System.out.println("Stack Empty!!");
			return null;
		}
		E item = stack.get(top);
		stack.remove(top);
		top--;
		return item;
	}

	private void add(E item) {
		top++;
		stack.add(item);
	}

	public static void main(String[] args) {

		StackLinkedListImpl<String> stackArray = new StackLinkedListImpl<String>();
		System.out.println("Stack size : " + stackArray.size());

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
