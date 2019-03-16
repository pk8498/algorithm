package test.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneBook {

    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        Set<String> phoneBookSet = new HashSet<>(Arrays.asList(phone_book));

        for (String prefix : phone_book) {
            phoneBookSet.remove(prefix);

            for (String phoneNumber : phoneBookSet) {
                if(isContainsPrefix(phoneNumber, prefix)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isContainsPrefix(String phoneNumber, String prefix){
        if(phoneNumber.equals(prefix)) {
            return false;
        }
        return phoneNumber.startsWith(prefix);
    }

    public static void main(String[] args){

        assertThat(new String[]{"119", "97674223", "1195524421"}, false);
        assertThat(new String[]{"123", "456", "789"}, true);
        assertThat(new String[]{"12", "123", "1235", "567", "88"}, false);

    }

    public static void assertThat(String[] phone_book, boolean answer) {

        PhoneBook phoneBook = new PhoneBook();
        boolean actualAnswer = phoneBook.solution(phone_book);

        if(actualAnswer != answer) {
            throw new RuntimeException("Failed test. phone_book: " + Arrays.toString(phone_book)
                                        + ", expectedAnswer: " + answer + ", actualAnswer: " + actualAnswer);
        }

        System.out.println("Passed test. phone_book: " + Arrays.toString(phone_book) + ", answer: " + actualAnswer);
    }

}

