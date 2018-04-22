package web.template;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {
    private Map<String, String> variables = new HashMap<>();

    public String process(String text) {
        text = replaceVariables(text);

        return text;
    }

    public void set(String key, String value) {
        variables.put("${" + key + "}", value);
    }

    private String replaceVariables(String text) {
        Date date = new Date();
        String today = new SimpleDateFormat("hh:mm:ss - YYYY:MM:DD").format(date);
        text = text.replace("${today}", today);

        for(Map.Entry<String, String> entry: variables.entrySet()) {
            String var = entry.getKey();
            String value = entry.getValue();

            text = text.replace(var, value);
        }

        return text;
    }

}
