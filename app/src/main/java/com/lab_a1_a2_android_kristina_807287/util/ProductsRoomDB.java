package com.lab_a1_a2_android_kristina_807287.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lab_a1_a2_android_kristina_807287.data.ProductsDao;
import com.lab_a1_a2_android_kristina_807287.model.Products;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities =  {Products.class}, version = 1, exportSchema = false)
public abstract class ProductsRoomDB extends RoomDatabase {

    private static final String DB_NAME = "room_products_db";


    public abstract ProductsDao productsDao();

    private static volatile ProductsRoomDB INSTANCE;

    private static final int NUMBER_OF_THREADS = 4; // any number doesn't matter

    //executor service that helps to work in the background thread
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProductsRoomDB getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductsRoomDB.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ProductsRoomDB.class, DB_NAME)
                            //.addCallback(getRoomDatabaseCallBack())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

//    @NonNull
//    private static Callback getRoomDatabaseCallBack() {
//        return roomDatabaseCallBack;
//    }
//
//    //TODO: complete room db call back
//    private static final RoomDatabase.Callback roomDatabaseCallBack = onCreate(db) -> {
//        super.onCreate(db);
//
//        databaseWriteExecutor.execute();
//    }



}