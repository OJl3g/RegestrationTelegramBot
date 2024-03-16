package ru.telegram_bot;

public class RegisterManager {
    private final int COUNT_ATTRIBUTE = 5;
    WriteInFile writeInFile = new WriteInFile();

    public boolean reg(String text) {
       int indexStart =  text.indexOf(" ") + 1;
        text = text.substring(indexStart, text.length());

        String[] attributeUser = text.split(",");

        if (attributeUser.length != COUNT_ATTRIBUTE) {
            return false;
        }

        User user = new User();

//        String name = attributeUser[0]; //Не сокращенная запись,того, что снизу
//        user.setName(name);

        int numberAttribute = 0;
        user.setName(attributeUser[numberAttribute++]);
        user.setAge(Integer.valueOf(attributeUser[numberAttribute++]));
        user.setNameCity(attributeUser[numberAttribute++]);
        user.setGender(attributeUser[numberAttribute++]);
        user.setLanguage_programming(attributeUser[numberAttribute]);

        writeInFile.writeUser(user);


        return true;
    }
}
