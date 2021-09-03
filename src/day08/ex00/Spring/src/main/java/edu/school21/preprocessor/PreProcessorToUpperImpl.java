package edu.school21.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String preProcessor(String message) {
        return message.toUpperCase();
    }
}

