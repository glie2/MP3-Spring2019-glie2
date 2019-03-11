package edu.illinois.cs.cs125.spring2019.mp3.lib;


import com.google.gson.JsonArray;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Image recognition class. Each function takes the JSON returned by the
 * Microsoft Cognitive Services API and extracts some piece of information
 * from it.
 */
class RecognizePhoto {


    /**
     * Get the image width.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width or 0 on failure
     */
    public static int getWidth(final String json) {
        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        int width = result.getAsJsonObject("metadata").get("width").getAsInt();
        return width;

        /**
        JsonParser parser = new JsonParser();
        if (!parser.parse(json).isJsonObject()) {
            return 0;
        } else {
            JsonObject rootObj = parser.parse(json).getAsJsonObject();
            int width = rootObj.get("width").getAsInt();
            return width;

        }

        JsonObject rootObj = parser.parse(json).isJson
        //JsonObject locObj = rootObj.getAsJsonObject("metadata");

        int width = rootObj.get("width").getAsInt();
        return width;*/


    }

    /**
     * Get the image height.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the height or 0 on failure
     */
    public static int getHeight(final String json) {

        if (json == null) {
            return 0;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        int height = result.getAsJsonObject("metadata").get("height").getAsInt();
        return height;

    }

    /**
     * Get the image file type.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the type of the image or null
     */
    public static String getFormat(final String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        String format = result.getAsJsonObject("metadata").get("format").getAsString();
        return format;
    }

    /**
     * Return the caption describing the image created by the Microsoft Cognitive
     * Services API. If multiple captions are provided your code should return the
     * first one.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the caption describing the image created by Microsoft or null on failure
     */
    public static String getCaption(final String json) {
        if (json == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray captions = result.getAsJsonObject("description").get("captions").getAsJsonArray();
        String text = captions.get(0).getAsJsonObject().get("text").getAsString();
        return text;
    }

    /**
     * Determine whether the image contains a dog. You should do this by examining the tags
     * returned by the Cognitive Services API. If a tag with the name "dog" exists with at
     * least the provided confidence, you should return true. Otherwise false.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @param lowConfidence the minimum confidence required for this determination
     * @return boolean indicating whether the image contains a dog or false on failure
     */
    public static boolean isADog(final String json, final double lowConfidence) {
        if (json == null) {
            return false;
        }
        //Standard parser stuff
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        //Get an array of tags
        JsonArray tags = result.get("tags").getAsJsonArray();
        //For-each was too hard to get syntax: standard for loop
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getAsJsonObject().get("name").getAsString().equals("dog")) {

                if (tags.get(i).getAsJsonObject().get("confidence").getAsDouble() >= lowConfidence) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Determine whether the image contains a cat. You should do this by examining the tags
     * returned by the Cognitive Services API. If a tag with the name "cat" exists with at
     * least the provided confidence, you should return true. Otherwise false.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @param lowConfidence the minimum confidence required for this determination
     * @return a boolean indicating whether the image contains a cat or false on failure
     */
    public static boolean isACat(final String json, final double lowConfidence) {
        if (json == null) {
            return false;
        }
        //Standard parser stuff
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        //Get an array of tags
        JsonArray tags = result.get("tags").getAsJsonArray();
        //For-each was too hard to get syntax: standard for loop
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getAsJsonObject().get("name").getAsString().equals("cat")) {

                if (tags.get(i).getAsJsonObject().get("confidence").getAsDouble() >= lowConfidence) {
                    return true;
                }
            }

        }
        return false;
    }
}
