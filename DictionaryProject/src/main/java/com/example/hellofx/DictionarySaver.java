package com.example.hellofx;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    public HashMap<String,String> dictionaryList;

    DictionarySaver(){
        dictionaryList = new HashMap<>();
    }

    HashMap<String, String> getDictionaryList()
    {
        return dictionaryList;
    }

    void serializeHashmap() throws IOException {
        FileOutputStream fos = new FileOutputStream("dictionarydata");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(dictionaryList);
        oos.close();
        fos.close();
    }

    void deserializeHashmap() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("dictionarydata");
        ObjectInputStream ois = new ObjectInputStream(file);

         dictionaryList = (HashMap<String, String>) ois.readObject();
    }
}
