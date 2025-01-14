package spaghetti;

import spaghetti.exception.StackException;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Spaghetti stack implementation, with a wrapper to handle it
 * @param <T>
 */
public class SpaghettiWrapper<T> {

    private final Stack<SpaghettiStack<T>> stack;

    /**
     * Create a stack
     */
    public SpaghettiWrapper(){
        stack = new Stack<>();
        stack.add(new SpaghettiStack<>());
    }

    /**
     * Get a value on the actual level and the upper levels
     * @param name of the variable
     * @return the value
     */
    public T get(String name) throws StackException {
        return stack.peek().get(name);
    }

    /**
     * Check if the value is already assign on the stack
     * @param name
     * @return
     */
    public boolean exists(String name) {
        return stack.peek().exist(name);
    }

    /**
     * Get the list of variables defined in a block
     * @return
     */
    public List<String> listInChildren(){
        List<String> list = new ArrayList<>();
        stack.peek().listInChildren(list);
        return list;
    }

    /**
     * Add or update a value
     * @param name of the variable
     * @param obj the value
     */
    public void set(String name, T obj) throws StackException {
        stack.peek().set(name, obj);
    }

    /**
     * Declare a new variable in this scope
     * @param name
     * @param obj
     * @throws StackException is the name already exist
     */
    public void newSet(String name, T obj) throws StackException{
        stack.peek().newSet(name, obj);
    }

    /**
     * @return the level of where you are
     */
    public int getDepth(){
        return stack.size();
    }

    /**
     * Lower the level, going toward global
     */
    public void up(){
        if(stack.size() > 1)
            stack.pop();
    }

    /**
     * Grow the level, going toward blocks
     */
    public void down(){
        SpaghettiStack<T> parent = stack.peek();
        stack.add(new SpaghettiStack<T>(parent));
    }
    @Override
    public String toString(){
        return stack.get(0).toString();
    }
}
