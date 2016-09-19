package chihz.bot.elder;

import java.util.List;

/**
 * 身经百战的长者服务
 * Created by chihongze on 16/9/19.
 */
public interface ElderService {

    /**
     * 请长者题词
     * 题词内容会随机给出
     * @return
     */
    Result<String> giveInscription();

    /**
     * 回答问题
     * @param question
     * @return
     */
    Result<String> answerQuestion(String question);

    /**
     * 讲洋文
     * @return
     */
    Result<String> speakEnglish();


    /**
     * 三个代表的重要思想
     * @return
     */
    Result<List<String>> three();
}
