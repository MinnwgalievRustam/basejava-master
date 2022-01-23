package com.example.webapp.storage;

import com.example.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage{
    private Map<String, Resume> map = new HashMap<>();
    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected List<Resume> doCopyAll() {
       return new ArrayList<>(map.values());
    }


    @Override
    public void clear() {
        map.clear();
    }


    @Override
    public int size() {
        return map.size();
    }
}
