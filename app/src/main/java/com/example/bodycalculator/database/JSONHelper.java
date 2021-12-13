package com.example.bodycalculator.database;

import com.example.bodycalculator.models.User;
import com.google.gson.Gson;

import java.util.List;

public class JSONHelper {
    private static final String FILE_NAME = "data.json";


    public static String exportUserToJSON(User user) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setUser(user);
        String jsonString = gson.toJson(dataItems);
        return jsonString;
    }

    public static String exportUsersToJSON(List<User> Users) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setUsers(Users);
        String jsonString = gson.toJson(dataItems);
        return jsonString;
    }

    public static User importUserFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(jsonString, DataItems.class);
            return dataItems.getUser();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }


    public static List<User> importUsersFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(jsonString, DataItems.class);
            return dataItems.getUsers();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    private static class DataItems {
        private User user;
        private List<User> Users;

        User getUser() {
            return user;
        }
        void setUser(User user) {
            this.user = user;
        }

        List<User> getUsers() {
            return Users;
        }
        void setUsers(List<User> Users) {
            this.Users = Users;
        }
    }
}
