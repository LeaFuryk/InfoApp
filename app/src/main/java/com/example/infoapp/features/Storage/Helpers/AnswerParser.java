package com.example.infoapp.features.Storage.Helpers;

import java.util.HashMap;

public class AnswerParser {

    public String parse(HashMap<String,String> answers){

        String parsedAnswers = "";
        for (String key: answers.keySet()) {
            parsedAnswers += key + ":" + answers.get(key) +",";
        }

        return parsedAnswers;
    }

    public HashMap<String,String> parse(String answers){

        HashMap<String,String> map = new HashMap<>();

        String [] separatedAnswers = answers.split(",");
        for (String answer: separatedAnswers) {
            if(answer != ""){
                String [] splitted = answer.split(":");
                map.put(splitted[0], splitted[1]);
            }
        }
        return map;
    }

}
