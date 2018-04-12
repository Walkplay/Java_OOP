package com.tasks3.linkedlist;

public class LinkedList {

	   int listSize;
	    Node first;
	    Node last;
	    public LinkedList() {
	        first = null;
	        last = null;
	        listSize = 0;
	    }

	    public void add(Integer data) {
	    	
	        Node lastNode = last;
	        Node newNode = new Node();
	        newNode.setNext(null);
	        newNode.setData(data);

	        last = newNode;
	        if (lastNode == null)
	            first = newNode;
	        else
	            lastNode.setNext(newNode);

	        listSize++;
	    }

	    public Integer get(int index) {

	        Node indexedNode = first;
	        for (int i = 0; i < size(); i++) {
	            if (i == index) {
	                return indexedNode.getData();
	            }
	            indexedNode = indexedNode.getNext();
	        }
	        return null;
	    }

	    public boolean delete(int index) {

	        boolean flag = false;
	        Node previousNode = null;
	        Node currentNode = first;

	        if (index < listSize) {
	            for (int i = 0; i <= index; i++) {

	                if (i == index) {

	                    if (previousNode != null) {
	                        previousNode.setNext(currentNode.getNext());
	                    } else {
	                        first = first.getNext();
	                    }
	                    
	                    listSize-=1;
	                    flag = true;
	                }

	                previousNode = currentNode;
	                currentNode = currentNode.getNext();
	            }
	        }

	        return flag;
	    }

	    public int size() {
	        return listSize;
	    }
} 