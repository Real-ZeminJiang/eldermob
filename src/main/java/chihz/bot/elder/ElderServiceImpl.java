package chihz.bot.elder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by chihongze on 16/9/19.
 */
public class ElderServiceImpl implements ElderService {

    private static final String[] inscriptions = new String[] {
            "政治合格 军事过硬",
            "军队一律不得经商!",
            "Excited!",
            "闷声发大财"
    };

    private static final String[] englishSentences = new String[] {
            "too young",
            "too simple",
            "sometimes naive",
            "I speak very pool english, but I dare to say! This is very important!"
    };

    private final Random random = new Random();

    public ElderServiceImpl() {

    }

    public Result<String> giveInscription() {
        int idx = random.nextInt(inscriptions.length);
        return Result.ok(inscriptions[idx]);
    }

    public Result<String> answerQuestion(String question) {
        if ("董先森连任吼不吼啊" == question) {
            return Result.ok("吼啊");
        }
        return Result.badRequest("elder_angry", "无可奉告");
    }

    public Result<String> speakEnglish() {
        int idx = random.nextInt(englishSentences.length);
        return Result.ok(englishSentences[idx]);
    }

    public Result<String> throwErr() {
        throw new RuntimeException("蛤蛤");
    }

    public Result<List<String>> three() {
        return Result.ok(Arrays.asList(
                "始终代表中国先进生产力的发展要求",
                "始终代表中国先进文化的发展方向",
                "始终代表中国最广大人民的根本利益"
        ));
    }
}
