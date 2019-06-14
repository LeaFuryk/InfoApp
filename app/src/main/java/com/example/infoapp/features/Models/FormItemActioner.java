package com.example.infoapp.features.Models;

import java.util.ArrayList;

public interface FormItemActioner {

    void executeWithQuestion(String question, QuestionType type);

    void executeWithOptions(String question, ArrayList<String> options, QuestionType type);

}
