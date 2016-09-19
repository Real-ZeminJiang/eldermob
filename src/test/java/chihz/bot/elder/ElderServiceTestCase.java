package chihz.bot.elder;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ElderServiceTestCase {

    private ElderService elderService;

    @Before
    public void setUp() {
        this.elderService = new ElderServiceImpl();
    }

    @Test
    public void testGiveInscription() {
        Result<String> rs = this.elderService.giveInscription();
        assertEquals(rs.getStatusCode(), Result.STATUS_OK);
        assertNotNull(rs.getData());
    }

    @Test
    public void testAnswerQuestion() {
        Result<String> rs = this.elderService.answerQuestion("董先森连任吼不吼啊");
        assertEquals(rs.getStatusCode(), Result.STATUS_OK);
        assertEquals(rs.getData(), "吼啊");

        rs = this.elderService.answerQuestion("钦定呢");
        assertEquals(rs.getStatusCode(), Result.STATUS_BAD_REQUEST);
        assertEquals(rs.getReason(), "elder_angry");
        assertEquals(rs.getMsg(), "无可奉告");
    }

    @Test
    public void testSpeakEnglish() {
        Result<String> rs = this.elderService.speakEnglish();
        assertEquals(rs.getStatusCode(), Result.STATUS_OK);
    }

    @Test
    public void testThree() {
        Result<List<String>> rs = this.elderService.three();
        assertEquals(rs.getStatusCode(), Result.STATUS_OK);
        assertEquals(rs.getData().size(), 3);
    }


}
