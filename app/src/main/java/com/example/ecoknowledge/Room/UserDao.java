package com.example.ecoknowledge.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Query("UPDATE diaryTable SET user_title = :t, user_date = :d , user_image=:i WHERE user_id =:id")
    void update(String t, String d, String i, int id);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM  diaryTable")
    List<User> getAll();

    @Query("DELETE FROM diaryTable")
    void deleteAll();

    @Query("SELECT COUNT(*) as cnt FROM diaryTable")
    int getDataCount();
}
