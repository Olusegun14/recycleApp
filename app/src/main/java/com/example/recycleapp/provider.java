package com.example.recycleapp;

import java.util.ArrayList;

public class provider {

    public static ArrayList<QuestionModel> getQuestion()
    {
        ArrayList<QuestionModel> mylist= new ArrayList<>();

        mylist.add(new QuestionModel("Is plastic recyclable?","Yes","No","Yes", "Yes, Plastic can be recycled at some out of home recycling centres."));
        mylist.add(new QuestionModel("Are Laptop Batteries recyclable?","Yes","No","Yes","These items should not be disposed of in the waste bin and should be recycled at the appropriate recycle centres."));
        mylist.add(new QuestionModel("Are Phones recyclable?","Yes","No","Yes","Yes,  phone is an electrical gadget and  can be recycled at some out of home recycling centres."));
        mylist.add(new QuestionModel("Are Printers recyclable?","Yes","No","Yes","Yes, printer is an electrical items and  can be recycled at some out of home recycling centres."));
        mylist.add(new QuestionModel("Are Computers (PCs),recyclable?","Yes","No","Yes","Yes, These items should not be disposed of in the waste bin and should be recycled."));
        mylist.add(new QuestionModel("Are Fridges recyclable?","Yes","No","No","No, White goods like fridges cannot currently be recycled at home, it require expertise to be handled."));
        mylist.add(new QuestionModel("Are Laptops recyclable?","Yes","No","Yes"," Although laptops cannot currently be recycled at home. Laptops can be recycled at some out of home recycling centres."));
        mylist.add(new QuestionModel("Are Fans recyclable?","Yes","No","Yes","Desk fans, standing fans, and ceiling fans can all be recycled at recycling centres when it is time to replace them."));
        mylist.add(new QuestionModel("Are Fire Extinguishers recyclable?","Yes","No","No","No, Fire extinguishers are classified as hazardous waste and need to be disposed of carefully."));
        mylist.add(new QuestionModel("Is a Cassette recyclable?","Yes","No","No","Cassettes are now rarely accepted at Recycling Centres and charity shops and are generally sent to landfill."));
        mylist.add(new QuestionModel("Is a Game Console recyclable?","Yes","No","Yes","Yes, Game Console can be recycled at some out of home recycling centres."));
        mylist.add(new QuestionModel("Is Glass cookware recyclable?","Yes","No","No","While Glass cookware (Pyrex ovenware) is a type of glass, it has been specially treated in the manufacturing process to withstand high temperatures, which makes it non-recyclable. Broken or chipped Pyrex should be disposed of carefully in the waste bin."));
        mylist.add(new QuestionModel("Is Printer cartridges recyclable?","Yes","No","Yes","Yes, Printer cartridges can be recycled at some out of home recycling centres. NOTE: Printer cartridges cannot currently be recycled at home."));
        mylist.add(new QuestionModel("Are VHS tapes recyclable?","Yes","No","No","VHS tapes are now rarely accepted at Recycling Centres and charity shops and are generally sent to landfill."));
        mylist.add(new QuestionModel("Is Microwave Plates recyclable?","Yes","No","No","No, Microwave Plates cannot currently be recycled. It has been specially treated in the manufacturing process to withstand high temperatures, which makes it non-recyclable. Broken or chipped microwave plates should be disposed of carefully in the right waste bin."));
        return  mylist;
    }
}
