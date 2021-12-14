package com.example.bodycalculator.database;

import com.example.bodycalculator.models.TestResult;
import com.google.gson.Gson;

public class JSONHelper {
    private static final String FILE_NAME = "data.json";
    
    public static String exportTestResultToJSON(TestResult testResult) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setTestResult(testResult);
        String jsonString = gson.toJson(dataItems);
        return jsonString;
    }
    
    public static TestResult importTestResultFromJSON(String jsonString) {

        try{
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(jsonString, DataItems.class);
            return dataItems.getTestResult();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    private static class DataItems {

        private TestResult testResult;

        TestResult getTestResult() {
            return testResult;
        }
        void setTestResult(TestResult testResult) {
            this.testResult = testResult;
        }
    }
}
