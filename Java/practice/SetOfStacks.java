package practice;


import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks {
    private List<Stack<Integer>> setOfStacks;
    private int capacity;
    private int currentStackIndex;


    public SetOfStacks() {
        setOfStacks = new ArrayList<>();
        capacity = 10;
        currentStackIndex = -1;
    }

    public SetOfStacks(int capacity) {
        setOfStacks = new ArrayList<>();
        this.capacity = capacity;
        currentStackIndex = -1;
    }

    public void push(int val) {
        // if(setOfStacks.length() == 0 || setOfStacks.get(currentStackIndex).length() == capacity) {
        //     setOfStacks.add(new Stack<Integer>());
        //     currentStackIndex++;
        // }
        //
        // setOfStacks.get(currentStackIndex).push(new Integer(val));
    }

    public int pop() {
        return 0;
    }
}
