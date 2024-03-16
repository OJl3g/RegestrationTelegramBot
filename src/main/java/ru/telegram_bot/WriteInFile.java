package ru.telegram_bot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class WriteInFile {
    public void writeUser(User user){
        File file =
                new File("C:\\Users\\1\\IdeaProjects\\RegestrationBot\\src\\main\\java\\ru\\telegram_bot\\users.csv");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:").append(user.getName()).append(",");
        stringBuilder.append("age:").append(user.getAge()).append(",");
        stringBuilder.append("nameCity:").append(user.getNameCity()).append(",");
        stringBuilder.append("gender:").append(user.getGender()).append(",");
        stringBuilder.append("language:").append(user.getLanguage_programming());
        stringBuilder.append("\n");

        try {
            Files.writeString(file.toPath(),stringBuilder, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
