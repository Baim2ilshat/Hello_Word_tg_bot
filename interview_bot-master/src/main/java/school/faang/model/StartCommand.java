package school.faang.model;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import school.faang.dao.AnsRepository;

@Component
public class StartCommand extends Command {

    @Override
    public String process(Update update) {
        return AnsRepository.getStartAns();
    }

    @Override
    public boolean isApplicable(Update update) {
        return update.getMessage().getText().equals("/start");
    }
}

