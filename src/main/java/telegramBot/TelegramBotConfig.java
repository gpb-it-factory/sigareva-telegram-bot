package telegramBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

    @Configuration
    public class TelegramBotConfig {

        private static final String botUsername = System.getenv("BankBotUsername");

        private static final String botToken = System.getenv("BankBotToken");

        @Bean
        public TelegramBot telegramBot() {
            return new TelegramBot(botUsername, botToken);
        }

        @Bean
        public TelegramBotsApi telegramBotsApi(TelegramBot telegramBot) throws TelegramApiException {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
            return telegramBotsApi;
        }
    }

