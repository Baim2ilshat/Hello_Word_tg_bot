package school.faang.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import school.faang.dao.AnsRepository;

@Component
@RequiredArgsConstructor
public class OtherCommand extends Command {


    @Override
    public String process(Update update) {
        return AnsRepository.getAnotherAns();
    }

    @Override
    public boolean isApplicable(Update update) {
        return !update.getMessage().getText().equals("/start");
    }
}
