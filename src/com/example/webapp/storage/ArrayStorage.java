package com.example.webapp.storage;

import com.example.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
