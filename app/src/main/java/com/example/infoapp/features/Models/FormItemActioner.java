package com.example.infoapp.features.Models;

import java.util.Iterator;

public interface FormItemActioner {

    void executeWithQuestion(String question, QuestionType type);

    void executeWithOptions(String question, Iterator<String> options, QuestionType type);

}
