class Solution {
    public boolean isValid(String word) {
                // Check if the word contains at least 3 characters
        if (word.length() < 3) {
            return false;
        }

        // Check if the word contains only digits or letters
        if (!word.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Check if the word contains at least one vowel
        if (!word.matches(".*[aeiouAEIOU].*")) {
            return false;
        }

        // Check if the word contains at least one consonant
        if (!word.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*")) {
            return false;
        }

        // If all conditions are satisfied, return true
        return true;
    }
}