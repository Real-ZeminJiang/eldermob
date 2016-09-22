package chihz.bot.elder;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import spark.ResponseTransformer;
import static spark.Spark.*;

public class API {

    private static class JsonTransformer implements ResponseTransformer {


        @Override
        public String render(Object model) throws Exception {
            return JSON.toJSONString(model);
        }

    }

    public static void main(String[] args) {

        int port = 8081;
        if (args.length >= 1) {
            port = Integer.valueOf(args[0]);
        }

        ElderService elderService = new ElderServiceImpl();

        port(port); // mark web server port

        JsonTransformer jsonTransformer = new JsonTransformer();

        // controllers

        get(
                "/v1/elder/inscription",
                "application/json;charset=utf-8",
                (req, res) -> elderService.giveInscription(),
                jsonTransformer
        );

        post(
                "/v1/elder/answer",
                "application/json;charset=utf-8",
                (req, res) -> {
                    JSONObject bodyObj = JSON.parseObject(req.body());
                    return elderService.answerQuestion(bodyObj.getString("question"));
                },
                jsonTransformer
        );

        get(
                "/v1/elder/speak_english",
                "application/json;charset=utf-8",
                (req, res) -> elderService.speakEnglish(),
                jsonTransformer
        );

        get(
                "/v1/elder/three",
                "application/json;charset=utf-8",
                (req, res) -> elderService.three(),
                jsonTransformer
        );

    }
}
