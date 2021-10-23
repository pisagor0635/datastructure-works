package com.ab.queue;

import com.ab.stack.MyStack;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class MyQueueTest {

    @Test
    void shouldDequeueWhenQueueHasValues() {

        MyQueue<Integer> queue = new MyQueue<>(3);

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        Assertions.assertThat(queue.dequeue()).isEqualTo(5);
        Assertions.assertThat(queue.dequeue()).isEqualTo(10);

    }

    @Test
    void shouldPeekWithoutRemove() {

        MyQueue<Integer> queue = new MyQueue<>(3);

        Assertions.assertThat(queue.peek()).isNull();

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        Assertions.assertThat(queue.peek()).isEqualTo(5);
        Assertions.assertThat(queue.peek()).isEqualTo(5);
        Assertions.assertThat(queue.peek()).isEqualTo(5);
    }

    @Test
    void shouldReturnNullWhenQueueIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        Assertions.assertThat(queue.dequeue()).isNull();
        Assertions.assertThat(queue.dequeue()).isNull();
        Assertions.assertThat(queue.dequeue()).isNull();
        Assertions.assertThat(queue.dequeue()).isNull();
    }

    @Test
    void shouldCalculateNumberOfItems() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        Assertions.assertThat(queue.getNumberOfIems()).isEqualTo(3);
        queue.dequeue();
        Assertions.assertThat(queue.getNumberOfIems()).isEqualTo(2);
        queue.enqueue(20);
        Assertions.assertThat(queue.getNumberOfIems()).isEqualTo(3);

    }

    @Test
    void shouldFailWhenEnqueueOnFullQueue() {

        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        Assertions.assertThatThrownBy(() -> queue.enqueue(20)).isInstanceOf(RuntimeException.class).hasMessage("Sorry queue is full");

    }

    @Test
    void workWithStringType() {

        MyQueue<String> queue = new MyQueue<>(2);
        queue.enqueue("String1");
        queue.enqueue("String2");

        Assertions.assertThat(queue.dequeue()).isEqualTo("String1");
        Assertions.assertThat(queue.dequeue()).isEqualTo("String2");
    }
}