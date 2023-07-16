package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(secondQueue.poll());
        arrayDeque.add(secondQueue.poll());
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {

            firstQueue.add(arrayDeque.pollLast());
            arrayDeque.add(firstQueue.poll());
            arrayDeque.add(firstQueue.poll());

            secondQueue.add(arrayDeque.pollLast());
            arrayDeque.add(secondQueue.poll());
            arrayDeque.add(secondQueue.poll());
        }

        if (!firstQueue.isEmpty()) {
            arrayDeque.addAll(firstQueue);
        } else if (!secondQueue.isEmpty()) {
            arrayDeque.addAll(secondQueue);
        }

        return arrayDeque;
    }

    public static void main(String[] args) {
        Queue<Integer> firstQueue = new ArrayDeque<>();
        firstQueue.add(1);
        firstQueue.add(5);
        firstQueue.add(7);
        firstQueue.add(6);

        Queue<Integer> secondQueue = new ArrayDeque<>();
        secondQueue.add(2);
        secondQueue.add(5);
        secondQueue.add(8);
        secondQueue.add(3);

        ArrayDequeCreator creator = new ArrayDequeCreator();
        ArrayDeque<Integer> result = creator.createArrayDeque(firstQueue, secondQueue);
        System.out.println(result);
    }
}
