package com.jackie.matchthemembers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Member {
     private final String[] memberNamesConst = {"Aayush Tyagi", "Abhinav Koppu", "Aditya Yadav",
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

    private String name;
    private int photoId;

    private ArrayList<String> memberNames = new ArrayList<String>(Arrays.asList(memberNamesConst));

    /** Shuffles members randomly, updates score, displays the picture, and sets the choices. */

    void shuffleMembers() {
        Random num = new Random();
        // int mem = num.nextInt(memberNames.length);
        // displayPicture(memberNames[mem]);
        // setCorrectChoice(generateChoices(memberNames, memberNames[mem]));
    }

    /** Generates answer choices and returns the index of the correct answer choice. */
    int generateChoices(String[] members, String name) {
        ArrayList<String> choices = new ArrayList<>(4);
        Random random = new Random();
        int placefillers = 3;
        int pIndex = random.nextInt(members.length);
        for (int i = 0; i < placefillers; i++) {
            while (members[pIndex].equals(name) || choices.contains(members[pIndex])) {
                pIndex = random.nextInt(members.length);
            }
            choices.add(members[pIndex]);
        }
        choices.add(name);
        Collections.shuffle(choices);
        // setOptions(choices);
        // setCorrectName(name);
        return choices.indexOf(name);
    }

    /** Displays the picture of a member. */
    void displayPicture(String name) {
        String sourceName = name.toLowerCase().replaceAll("\\s","");
        // final int id = getResources().getIdentifier(sourceName, "drawable", getPackageName());
        // imageView.setImageResource(id);
    }

}
