package test.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public int solution(int[] priorities, int location) {

        int answer = 0;

        Queue<Document> documents = buildDocumentQueue(priorities);

        boolean isNext = true;
        int maxValue = 0;
        while (!documents.isEmpty()) {
            if(isNext) {
                Document maxDocument = Collections.max(documents);
                maxValue = maxDocument.getPriority();
            }

            Document document = documents.poll();
            if(document.getPriority() < maxValue) {
                documents.offer(document);
                isNext = false;
            } else {
                answer++;
                if(document.getIndex() == location) {
                    break;
                }
                isNext = true;

            }
        }

        return answer;
    }

    private Queue<Document> buildDocumentQueue(int[] priorities) {
        Queue<Document> documents = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            documents.add(new Document(i, priorities[i]));
        }

        return documents;
    }

    public static void main(String[] args) {

        assertThat(new int[]{1,1,9,1,1,1},0,5);
        assertThat(new int[]{2,1,3,2},2,1);

    }

    public static void assertThat(int[] priorities, int location, int answer) {

        Printer printer = new Printer();
        int actualAnswer = printer.solution(priorities, location);

        if(actualAnswer != answer) {
            throw new RuntimeException("Failed test. priorities: " + Arrays.toString(priorities)
                    + ", location: " + location + ", expectedAnswer: " + answer + ", actualAnswer: " + actualAnswer);
        }

        System.out.println("Passed test. priorities: " + Arrays.toString(priorities)
                    + ", location: " + location + ", answer: " + actualAnswer);

    }


    class Document implements Comparable<Document> {

        private int index;
        private int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        int getIndex() {
            return this.index;
        }

        int getPriority() {
            return this.priority;
        }

        @Override
        public int compareTo(Document o) {

            if(this.priority > o.priority) {
                return 1;
            }

            if(this.priority < o.priority) {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "[index: " + index + ", priority: " + priority + "]";
        }
    }

}



