package org.example.SBA_2;

import java.util.ArrayList;

class InvalidStringException extends Exception {
    public InvalidStringException(String message) {
        super(message);
    }
}

interface MyList {
    void convert(String[] a);
    void replace(int idx);
    ArrayList<String> compact();
}

class ArrayToList implements MyList {
    private ArrayList<String> arrayToList;

    public ArrayToList() {
        this.arrayToList = new ArrayList<>();
    }

    @Override
    public void convert(String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 5) {
                try {
                    throw new InvalidStringException("Invalid string length: " + a[i]);
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            arrayToList.add(a[i]);
            System.out.println("I have added the string: " + a[i] + " at index: " + i);
        }
    }

    @Override
    public void replace(int idx) {
        if (idx >= 0 && idx < arrayToList.size()) {
            String replacedString = arrayToList.get(idx);
            arrayToList.set(idx, "");
            System.out.println("I have replaced the string: " + replacedString + " with a null string.");
        } else {
            System.out.println("Invalid index for replacement.");
        }
    }

    @Override
    public ArrayList<String> compact() {
        ArrayList<String> compactList = new ArrayList<>();
        for (String str : arrayToList) {
            if (!str.isEmpty()) {
                compactList.add(str);
            }
        }
        return compactList;
    }
}