package in.hocg.zhifou.support.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * Created by hocgin on 2018/10/16.
 * email: hocgin@gmail.com
 * - 使用 #{} 包含 SpEL 表达式
 * @author hocgin
 */
public final class SpelParser {
    private static SpelExpressionParser parser;
    private static TemplateParserContext templateParserContext ;
    
    private SpelParser() {
    }
    
    static {
        templateParserContext = new TemplateParserContext();
        parser = new SpelExpressionParser(new SpelParserConfiguration(true, true));
    }
    
    public static String parser(String spelText, EvaluationContext context) {
        Expression expression = parser.parseExpression(spelText, templateParserContext);
        return expression.getValue(context, String.class);
    }
}
