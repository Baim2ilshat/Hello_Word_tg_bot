package school.faang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AnsRepository {
    public static String getStartAns() {
        return """
                Привет, данный бот возвращает на любое сообщение фразу: Hello, World!
                """;
    }

    public static String getAnotherAns() {
        return "Hello, World!";
    }
}
