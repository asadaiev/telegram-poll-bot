package bots;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.antonioaltieri.telegram.botapi.TelegramBot;
import com.antonioaltieri.telegram.botapi.requests.TelegramApi;

public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());

        // Send Message
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "568629079:AAFZEsyrTXTJLQ8R8_4vWFTK_uvUUPnBk64";
    }
}
