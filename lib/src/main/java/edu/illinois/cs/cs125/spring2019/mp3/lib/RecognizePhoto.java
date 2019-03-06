package edu.illinois.cs.cs125.spring2019.mp3.lib;

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
    }

    /**
     * Get the image height.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the height or 0 on failure
     */
    public static int getHeight(final String json) {
    }

    /**
     * Get the image file type.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the type of the image or null
     */
    public static String getFormat(final String json) {
    }

    /**
     * Return the caption describing the image created by the Microsoft Cognitive
     * Services API. If multiple captions are provided your code should return the
     * first one.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the caption describing the image created by Microsoft or null on failure
     */
    public static String getCaption(final String json) {
    }

    /**
     * Determine whether the image contains a dog. You should do this by examining the tags
     * returned by the Cognitive Services API. If a tag with the name "dog" exists with at
     * least the provided confidence, you should return true. Otherwise false.
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @param lowConfidence the minimum confidence required for this determination
     * @returna boolean indicating whether the image contains a dog or false on failure
     */
    public static boolean isADog(final String json, final double lowConfidence) {
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
    }
}
