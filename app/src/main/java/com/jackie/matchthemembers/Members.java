/** Holds all the members and performs actions on them.
 * Functions similarly to a deck of cards.
 * @author: Jacqueline Zhang
 * */
package com.jackie.matchthemembers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Members {
    private String[] memberNamesArr = {"Aayush Tyagi", "Abhinav Koppu", "Aditya Yadav",
            "Ajay Merchia", "Alice Zhao", "Amy Shen", "Anand Chandra", "Andres Medrano",
            "Angela Dong", "Anika Bagga", "Anmol Parande", "Austin Davis", "Ayush Kumar",
            "Brandon David", "Candice Ye", "Carol Wang", "Cody Hsieh", "Daniel Andrews",
            "Daniel Jing", "Eric Kong", "Ethan Wong", "Fang Shuo", "Izzie Lau", "Jaiveer Singh",
            "Japjot Singh", "Jeffrey Zhang", "Joey Hejna", "Julie Deng", "Justin Kim", "Kaden Dippe",
            "Kanyes Thaker", "Kayli Jiang", "Kiana Go", "Leon Kwak", "Levi Walsh", "Louie Mcconnell",
            "Max Miranda", "Michelle Mao", "Mohit Katyal", "Mudabbir Khan", "Natasha Wong",
            "Nikhar Arora", "Noah Pepper", "Paul Shao", "Radhika Dhomse", "Sai Yandapalli",
            "Saman Virai", "Sarah Tang", "Sharie Wang", "Shiv Kushwah", "Shomil Jain", "Shreya Reddy",
            "Shubha Jagannatha", "Shubham Gupta", "Srujay Korlakunta", "Stephen Jayakar", "Suyash Gupta",
            "Tiger Chen", "Vaibhav Gattani", "Victor Sun", "Vidya Ravikumar", "Vineeth Yeevani", "Wilbur Shi",
            "William Lu", "Will Oakley", "Xin Yi Chen", "Young Lin"};
    private int index;
    private ArrayList<String> memberNames;
    private ArrayList<String> choices;
    private int correctChoice;
    private String correctName;

    public Members() {
        index = 0;
        memberNames = new ArrayList<String>(Arrays.asList(memberNamesArr));
        choices = new ArrayList<String>(4);
        correctChoice = -1;
        correctName = "";
        Collections.shuffle(memberNames);
    }

    /** <------- SHUFFLING -------> */

    /** Shuffles members randomly and returns the name of a member. */
    String shuffleMembers() {
        if (index == memberNames.size()) {
            index = 0;
            Collections.shuffle(memberNames);
        }
        index++;
        return memberNames.get(index);
    }

    /** Generates answer choices and assigns values to variables. */
    void generateChoices(String name) {
        ArrayList<String> choices = new ArrayList<>(4);
        Random random = new Random();
        int placefillers = 3;
        int pIndex = random.nextInt(memberNamesArr.length);
        for (int i = 0; i < placefillers; i++) {
            while (memberNamesArr[pIndex].equals(name) || choices.contains(memberNamesArr[pIndex])) {
                pIndex = random.nextInt(memberNamesArr.length);
            }
            choices.add(memberNamesArr[pIndex]);
        }
        choices.add(name);
        Collections.shuffle(choices);
        setCorrectName(name);
        setCorrectChoice(choices.indexOf(name));
        setChoices(choices);
    }

    /** <------- ACCESSOR AND SETTER METHODS -------> */

    /** Returns the member names in a String array data structure. */
    public String[] getMembersArr() {
        return memberNamesArr;
    }

    /** Returns the member names in an ArrayList data structure. */
    public ArrayList<String> getMembers() {
        return memberNames;
    }

    /** Returns the four choices to be used for the current round. */
    public ArrayList<String> getChoices() {
        return choices;
    }

    /** Getter method for CORRECTCHOICE instance variable. */
    public int getCorrectChoice() {
        return correctChoice;
    }

    /** Getter method for CORRECTNAME instance variable. */
    public String getCorrectName() {
        return correctName;
    }

    /** Returns the four choices to be used for the current round. */
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    /** Setter method for CORRECTCHOICE instance variable. */
    public void setCorrectChoice(int choice) {
        correctChoice = choice;
    }

    /** Setter method for CORRECTNAME instance variable. */
    public void setCorrectName(String name) {
        correctName = name;
    }



}
