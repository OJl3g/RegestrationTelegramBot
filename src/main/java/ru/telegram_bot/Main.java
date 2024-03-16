package ru.telegram_bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot("6963260725:AAEBSpDiHmHQFDW58eI2ChTGuxfsfi_8HIQ");

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);



        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
