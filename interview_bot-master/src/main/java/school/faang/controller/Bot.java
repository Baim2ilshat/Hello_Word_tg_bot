package school.faang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import school.faang.model.Command;


import java.util.List;


@Component
public class Bot extends TelegramLongPollingBot {

    private final List<Command> commands;

    public Bot(@Value("${bot.token}") String token, List<Command> commands) {
        super(token);
        this.commands = commands;
    }

    @Override
    public void onUpdateReceived(Update update) {
        commands.stream()
                .filter(command -> command.isApplicable(update))
                .findFirst()
                .ifPresent(command -> {
                    String answer = command.process(update);
                    SendMessage message = new SendMessage();
                    message.setChatId(update.getMessage().getChatId().toString());
                    message.setText(answer);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new IllegalStateException(e);
                    }
                });

    }

    @Override
    public String getBotUsername() {
        return "Hello_Worder_bot";
    }
}
