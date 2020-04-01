package dao;

import entity.Adress;

import java.util.List;

public interface AdressDAO{
    void createOne(Adress adress);

    List<Adress> getAll();

    Adress findById(Long id);

    void updateOne(Adress adress);

    void deleteOne(Adress adress);
}
