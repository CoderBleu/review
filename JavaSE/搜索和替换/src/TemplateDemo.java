import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lauy
        * @date 2021/2/20
        */
public class TemplateDemo {
    public static void main(String[] args) {
        String s = "Hello, ${name}! You are learning ${lang}!";
        MyTemplate myTemplate = new MyTemplate(s);
        Map<String, String> map = new HashMap<>();
        map.put("name", "Bob");
        map.put("lang", "Java");
        System.out.println(myTemplate.render(map));
    }
}

class MyTemplate {
    private final String template;
    private final Pattern pattern = Pattern.compile("\\$\\{(\\w+)}");

    public MyTemplate(String template) {
        this.template = template;
    }

    public String render(Map<String, String> data) {
        Matcher m = pattern.matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            // Start 方法返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引，
            // end 方法最后一个匹配字符的索引加 1。
            String key = template.substring(m.start() + 2, m.end() - 1);
            m.appendReplacement(sb, data.get(key));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
