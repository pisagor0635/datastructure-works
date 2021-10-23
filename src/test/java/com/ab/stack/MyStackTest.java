package com.ab.stack;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class MyStackTest {

    @Test
    void shouldPopWhenStackHasValues() {

        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        Assertions.assertThat(stack.pop()).isEqualTo(15);
        Assertions.assertThat(stack.pop()).isEqualTo(10);
        Assertions.assertThat(stack.pop()).isEqualTo(5);

        Assertions.assertThat(stack.pop()).isNull();

    }

    @Test
    void shouldReturnNullWhenStackIsEmpty() {

        MyStack<Integer> stack = new MyStack<>(3);
        Assertions.assertThat(stack.pop()).isEqualTo(null);
    }

    @Test
    void souldFailWhenPushingToAFullStack() {

        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        Assertions.assertThatThrownBy(()->stack.push(20)).isInstanceOf(RuntimeException.class).hasMessage("Sorry stack is full");

    }

    @Test
    void shouldPeekWhenStackHasValues() {

        MyStack<Integer> stack = new MyStack<>(3);
        Assertions.assertThat(stack.peek()).isNull();

        stack.push(5);
        stack.push(10);

        Assertions.assertThat(stack.peek()).isEqualTo(10);
        Assertions.assertThat(stack.peek()).isEqualTo(10);
        Assertions.assertThat(stack.peek()).isEqualTo(10);
    }

    @Test
    void workWithStringType() {

        MyStack<String> stack = new MyStack<>(2);
        stack.push("String1");
        stack.push("String2");

        Assertions.assertThat(stack.pop()).isEqualTo("String2");
        Assertions.assertThat(stack.pop()).isEqualTo("String1");
    }

    @Test
    void workWithDoubleType() {

        MyStack<Double> stack = new MyStack<>(2);
        stack.push(1.2);
        stack.push(2.4);

        Assertions.assertThat(stack.peek()).isEqualTo(2.4);
        Assertions.assertThat(stack.peek()).isEqualTo(2.4);
        Assertions.assertThat(stack.peek()).isEqualTo(2.4);
    }
}