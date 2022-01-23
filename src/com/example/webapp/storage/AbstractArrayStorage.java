package com.example.webapp.storage;

import com.example.webapp.exception.ExistStorageException;
import com.example.webapp.exception.NotExistStorageException;
import com.example.webapp.exception.StorageException;
import com.example.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
          if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) searchKey);
            size++;
        }

    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeletedElement((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }


    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract Integer getSearchKey(String uuid);


    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer)searchKey >= 0;
    }
}
