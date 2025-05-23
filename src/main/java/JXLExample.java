import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;

import com.qmetry.qaf.automation.util.QAFJexlContext;

public class JXLExample {

	public static void main(String[] args) {
		
		Map<String, String> studentMap = new HashMap<String, String>();
		
		studentMap.put("name", "Prasant");
		
		JexlEngine jexlEngine = new JexlBuilder().create();
		
		JexlContext jexlContext = new QAFJexlContext(studentMap);
		
		String booleanExpression = "name==\"Garima\"";
		
		JexlExpression jexlExpression = jexlEngine.createExpression(booleanExpression);
		
		boolean result = (boolean) jexlExpression.evaluate(jexlContext); // false
		
		booleanExpression = "name==\"Prasant\"";
		
		jexlExpression = jexlEngine.createExpression(booleanExpression);
		
		 result = (boolean) jexlExpression.evaluate(jexlContext); // true
		
		
	}

}
