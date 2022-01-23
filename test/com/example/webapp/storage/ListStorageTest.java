package com.example.webapp.storage;

import com.example.webapp.exception.StorageException;
import com.example.webapp.model.Resume;
import org.junit.Ignore;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {

    public ListStorageTest() {
        super(new ListStorage());
    }
    @Ignore
    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {

    }
}