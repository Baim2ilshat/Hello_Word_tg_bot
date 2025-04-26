package school.faang.model;

import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class Command {

    public abstract String process(Update update);
    public abstract boolean isApplicable(Update update);
}
