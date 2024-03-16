package ru.telegram_bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
     private RegisterManager registerManager = new RegisterManager();
    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();


        Long chatId = message.getChatId();
        String text = message.getText();

        if (text.equals("/reg")){
            response("Форма регистрации\n /add name,age,city,gender,language programming",chatId);
        }else if (text.startsWith("/add")){
            registerManager.reg(text);
            response("Пользователь добавлен",chatId);
        }else {
            response("не существующая команда",chatId);
        }


    }

    private void response(String message,Long id){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(id);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "reg_user_java_bot";
    }
}
