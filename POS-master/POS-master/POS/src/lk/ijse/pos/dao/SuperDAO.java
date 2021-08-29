package lk.ijse.pos.dao;

import java.util.ArrayList;

public interface SuperDAO<T,ID>{
    public boolean add(T t) throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(T t) throws Exception;

    public T search(ID id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
}
