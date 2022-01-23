package com.example.webapp.storage;

import com.example.webapp.exception.ExistStorageException;
import com.example.webapp.exception.NotExistStorageException;
import com.example.webapp.exception.StorageException;
import com.example.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {
        for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
            storage.save(new Resume("Name" + i));
        }
        storage.save(new Resume("Overflow"));
    }
}